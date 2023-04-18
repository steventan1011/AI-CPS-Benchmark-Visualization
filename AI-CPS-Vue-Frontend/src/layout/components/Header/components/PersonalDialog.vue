<template>
  <el-dialog v-model="dialogVisible" title="Change password" width="40%">
    <el-form
      ref="ruleFormRef"
      :model="ruleForm"
      :rules="rules"
      label-width="140px"
      class="demo-ruleForm"
      :size="formSize"
    >
      <el-form-item label="Username">
        <el-input v-model="ruleForm.name" disabled></el-input>
      </el-form-item>
      <el-form-item label="Current password" prop="password">
        <el-input v-model="ruleForm.password" type="password"></el-input>
      </el-form-item>
      <el-form-item label="New password" prop="configPassword">
        <el-input v-model="ruleForm.configPassword" type="password"></el-input>
      </el-form-item>
    </el-form>
    <template #footer>
      <span class="dialog-footer">
        <el-button @click="dialogVisible = false">Cancel</el-button>
        <el-button type="primary" @click="submitForm(ruleFormRef)">Yes</el-button>
      </span>
    </template>
  </el-dialog>
</template>

<script lang="ts" setup>
  import { ref, defineExpose, reactive } from 'vue'
  import type { ElForm } from 'element-plus'
  const dialogVisible = ref(false)
  import {useUserStore} from "@/store/modules/user"
  const UserStore = useUserStore()
  const show = () => {
    dialogVisible.value = true
  }
  const hide = () => {
    dialogVisible.value = false
  }
  type FormInstance = InstanceType<typeof ElForm>

  const formSize = ref('')
  const ruleFormRef = ref<FormInstance>()
  const ruleForm = reactive({
    name: UserStore.userInfo.username,
    password: UserStore.userInfo.password,
    configPassword: '',
  })
  const rules = reactive({
    configPassword: [
      {
        required: true,
        message: 'Please enter new password',
        trigger: 'blur',
      },
    ],
  })
  const submitForm = (formEl: FormInstance | undefined) => {
    if (!formEl) return
    formEl.validate((valid) => {
      if (valid) {
        console.log('submit!')
      } else {
        console.log('error submit!')
        return false
      }
    })
  }

  const resetForm = (formEl: FormInstance | undefined) => {
    if (!formEl) return
    formEl.resetFields()
  }

  defineExpose({
    show,
  })
</script>

<style scoped>
  .dialog-footer button:first-child {
    margin-right: 10px;
  }
</style>
