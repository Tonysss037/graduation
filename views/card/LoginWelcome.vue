<template>
  <el-card class="box-card" shadow="never">
    <div slot="header">
      <span>💐 发布</span>
    </div>
    <div v-if="token != null && token !== ''" class="has-text-centered">
      <b-button
        type="is-primary"
        size="is-medium"
        tag="router-link"
        :to="{ path: '/post/create' }"
        outlined
        >✍ 发表想法</b-button
      >
    </div>
    <div v-if="token != null && token !== ''" class="has-text-centered">
      <b-button
        style="margin-top: 20px"
        size="is-medium"
        type="is-danger"
        tag="router-link"
        :to="{ path: '/team/create' }"
        outlined
        >🏃‍♂️ 发起组队</b-button
      >
    </div>

    <div v-else class="has-text-centered">
      <b-button
        type="is-primary"
        size="is-medium"
        tag="router-link"
        :to="{ path: '/register' }"
        outlined
        >马上入驻</b-button
      >
      <b-button
        type="is-danger"
        size="is-medium"
        tag="router-link"
        :to="{ path: '/login' }"
        outlined
        class="ml-2"
      >
        社区登入</b-button
      >
    </div>
  </el-card>
</template>

<script>
import { mapGetters } from "vuex";

export default {
  name: "LoginWelcome",
  computed: {
    ...mapGetters(["token"]),
  },
};
</script>

<style scoped>
</style>