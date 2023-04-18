<template>
  <div class="app-container">
    <div class="app-container-inner m-chat">
      <u-chat-box class="m-chat-box"/>
    </div>
  </div>
</template>

<script lang="ts" setup>
  import UChatBox from './components/u-chartBox/index.vue'
</script>

<style lang="scss" scoped>
.m-chat{
  display: flex;
  flex-direction: column;
  .m-chat-box{
    flex: 1;
    overflow: hidden;
  }
}
</style>
