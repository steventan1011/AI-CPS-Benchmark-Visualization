<template>
  <div class="app-container" ref="appContainer">
    <PropTable
        :loading="loading"
        @selection-change="selectionChange"
        :columns="column"
        :data="list"
        @reset="reset"
        @onSubmit="onSubmit"
    >

      <template v-slot:isNormal="scope"><span :style="{'color': scope.row.isNormal==0 ? 'red' : 'black'}">{{ scope.row.isNormal ? 'Normal' : 'Error' }}</span></template>
      <template v-slot:operation="scope">
        <el-button type="primary" size="small" icon="Edit" @click="edit(scope.row)">
          View Details
        </el-button>
      </template>
    </PropTable>

    <el-dialog v-model="dialogVisible" :title="title" width="50%">
      <el-form
          ref="ruleFormRef"
          :model="ruleForm"
          label-width="120px"
          class="demo-ruleForm"
          :size="formSize"
      >
        <el-form-item label="Paddle Angle" prop="pa">
          <el-input v-model="ruleForm.pa" />
        </el-form-item>
        <el-form-item label="Engine Speed" prop="es">
          <el-input v-model="ruleForm.es" />
        </el-form-item>
        <el-form-item label="Find Error" prop="isNormal">
          <el-radio-group v-model="ruleForm.isNormal">
            <el-radio :label="0">Error</el-radio>
            <el-radio :label="1">Normal</el-radio>
          </el-radio-group>
        </el-form-item>
      </el-form>
      <template #footer>
          <span class="dialog-footer">
            <el-button @click="dialogVisible = false">Close</el-button>
          </span>
      </template>
    </el-dialog>
  </div>
</template>


<script lang="ts" setup name="comprehensive">

import {ref, reactive, onMounted, nextTick} from 'vue'
import * as dayjs from 'dayjs'
import { ElMessage, ElMessageBox } from 'element-plus'
import type { FormInstance } from 'element-plus'
const loading = ref(true)
const appContainer = ref(null)
import PropTable from '@/components/Table/PropTable/index.vue'
import { AFCList } from '@/api/AFC'


const data = [];

AFCList().then(response => {
  // console.log(response.data['0']['overall_result']['pas']);
  for (let i = 0; i < 100; i++) {
    let S1Detail = response.data['0']['overall_result']['S1_detail'][i];
    let S2Detail = response.data['0']['overall_result']['S2_detail_avg'][i];
    let S3Detail = response.data['0']['overall_result']['S3_detail_percent'][i];
    let S4Detail = response.data['0']['overall_result']['S4_detail'][i];
    if (S4Detail == null) {
      S4Detail = "null";
    }
    let isNormalTemp = 1;
    if (S1Detail != 0 || S2Detail > 0.005 || S3Detail < 0.995 || S4Detail != 1) {
      isNormalTemp = 0;
    }
    data.push({
      id: i + 1,
      S1: S1Detail,
      S2: S2Detail,
      S3: S3Detail,
      S4: S4Detail,
      pa: response.data['0']['overall_result']['pas'][i],
      es: response.data['0']['overall_result']['ess'][i],
      isNormal: isNormalTemp,
    })
  }
})

    
const list = ref(data)


const column = [
  { name: 'id', label: 'id', inSearch: false, valueType: 'input' },
  { name: 'S1', label: 'S1: Hard Safety', inSearch: false, valueType: 'input' },
  { name: 'S2', label: 'S2: Soft Safety', inSearch: false, valueType: 'input' },
  { name: 'S3', label: 'S3: Steady State', inSearch: false, valueType: 'input' },
  { name: 'S4', label: 'S4: Resilience', inSearch: false, valueType: 'input' },
  // { name: 'pa', label: 'Peddle Angle', inSearch: false, valueType: 'input' },
  // { name: 'es', label: 'Engine Speed', inSearch: false, valueType: 'input' },
  {
    name: 'isNormal',
    label: 'isNormal',
    slot: true,
    inSearch: true,
    options: [
      {
        value: 1,
        label: 'Normal',
      },
      {
        value: 0,
        label: 'Error',
      },
    ],
    valueType: 'select',
  },
  { name: 'operation', slot: true, fixed: 'right', width: 200,label: 'Check Details'  },
]

const formSize = ref('default')
const ruleFormRef = ref<FormInstance>()
const ruleForm = reactive({
  pa: null,
  es: null,
  isNormal: null,
})


const dialogVisible = ref(false)
const title = ref('Add')
const rowObj = ref({})
const selectObj = ref([])


const selectionChange = (val) => {
  selectObj.value = val
}

const edit = (row) => {
  title.value = 'Check Details'
  rowObj.value = row
  dialogVisible.value = true
  ruleForm.pa = row.pa
  ruleForm.isNormal = row.isNormal
  ruleForm.es = row.es
}


const reset = () => {
  loading.value = true
  setTimeout(() => {
    loading.value = false
  }, 500)
  ElMessage.success('Reset Query')
}

const onSubmit = (val) => {
  console.log('val===', val)
  ElMessage.success('Search Query')
  loading.value = true
  setTimeout(() => {
    loading.value = false
  }, 500)
}

const getHeight = ()=>{

}

onMounted(() => {
  nextTick(()=>{
    // let data = appContainer.value.data;
  })
  setTimeout(() => {
    loading.value = false
  }, 1000)
})
</script>

<style scoped>
.edit-input {
  padding-right: 100px;
}
.app-container{
  flex: 1;
  display: flex;
  width: 100%;
  padding: 16px;
  box-sizing: border-box;
}
.cancel-btn {
  position: absolute;
  right: 15px;
  top: 10px;
}
</style>
