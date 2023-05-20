<template>
  <footer class="footer has-text-grey-light has-background-grey-darker">
    <div class="container">
      <div class="">
        <span>江苏海洋大学 连云港</span>

        <span style="float: right">
          <router-link :to="{ path: '/admin/login' }"> 管理员登录 </router-link>
          |
          <a href="/?lang=zh_CN">中文</a> |
          <a href="/?lang=en_US">English</a>
        </span>
      </div>

      <div>
        <span>{{ title }} ALL RIGHTS RESERVED</span>
        <div style="float: right">
          <template>
            <b-taglist attached>
              <b-tag type="is-dark" size="is-normal">联系作者</b-tag>
              <b-tag type="is-info" size="is-normal">{{ author }}</b-tag>
            </b-taglist>
          </template>
        </div>
      </div>
      <span>"嗨约"——江苏海洋大学校园运动信息系统</span>
    </div>
    <back-top></back-top>
  </footer>
</template>

<script>
import BackTop from "@/components/Backtop/BackTop";
export default {
  name: "Footer",
  components: {
    BackTop,
  },
  data() {
    return {
      title: "© " + new Date().getFullYear() + "严安",
      author: "严安",
    };
  },
};
</script>

<style scoped>
footer {
  margin-top: 270px;
  /* 页脚需要调整 */
  height: 150px;
}
footer a {
  color: #bfbfbf;
}
</style>