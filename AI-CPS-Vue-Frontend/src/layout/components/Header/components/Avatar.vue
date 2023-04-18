<template>
  <el-dropdown >
        <span class="el-dropdown-link">
          <el-avatar :size="30" class="avatar" :src="AvatarLogo"/>
          {{userInfo.username}}
          <el-icon class="header-icon el-icon--right">
            <arrow-down />
          </el-icon>
        </span>
    <template #dropdown>
      <el-dropdown-menu>
        <el-dropdown-item :command="0" @click="switchRolesAction('admin')">
          {{currentRoles==='admin'?'Current role':'Change role'}}：Admin
        </el-dropdown-item>
        <el-dropdown-item :command="0" divided @click="switchRolesAction('other')">
          {{currentRoles==='other'?'Current role':'Change role'}}：User
        </el-dropdown-item>
        <el-dropdown-item :command="3" divided @click="modifyPassword">
          <el-icon><Edit /></el-icon>Change password
        </el-dropdown-item>
        <el-dropdown-item :command="4" divided @click="logOut" >
          <el-icon><SwitchButton /></el-icon>Logout
        </el-dropdown-item>
      </el-dropdown-menu>
    </template>
  </el-dropdown>

  <PersonalDialog ref="person"/>
</template>

<script lang="ts" setup>
import { useRouter } from 'vue-router'
import {ElMessage, ElMessageBox} from "element-plus";
import {computed, ref} from "vue";

import AvatarLogo from '@/assets/image/avatar.png'
import {useUserStore} from "@/store/modules/user"
import {useTagsViewStore} from "@/store/modules/tagsView"
import {usePermissionStore} from "@/store/modules/permission"
import PersonalDialog from './PersonalDialog.vue'

const router = useRouter()
const UserStore = useUserStore()
const TagsViewStore = useTagsViewStore()
const PermissionStore = usePermissionStore()

const currentRoles = computed({
  get() {
    return UserStore.roles[0]
  },
  set(val) {
    ;(async () => {
      await UserStore.getInfo([val])
      router.push({
        path:'/'
      })
      location.reload()
    })()
  },
})

const switchRolesAction = (type:string)=>{
  if(type===currentRoles.value) return
  currentRoles.value = currentRoles.value==='admin'?'other':'admin'
}

// 用户信息
const userInfo = computed(() => UserStore.userInfo)
const person = ref()

const logOut = async () => {
    ElMessageBox.confirm('Confirm Logout?', 'Confirmation', {
      confirmButtonText: 'Yes',
      cancelButtonText: 'Cancel',
      type: 'warning',
    })
    .then(async () => {
      await UserStore.logout()
      await router.push({path: '/login'})
      TagsViewStore.clearVisitedView()
      PermissionStore.clearRoutes()
      ElMessage({
        type: "success",
        message: "Successfully logout！"
      });
    })
    .catch(() => {})
}
const modifyPassword = ()=>{
  person.value.show()
}
</script>

<style lang="scss" scoped>
.avatar{
  margin-right: 6px
}
.el-dropdown-link {
  cursor: pointer;
  //color: var(--el-color-primary);
  display: flex;
  align-items: center;
}
</style>
