<template>
  <el-card class="box-card" shadow="never" style="opacity: 0.9">
    <div slot="header">
      <span>😂 常用功能</span>
    </div>
    <div>
      <b-button
        size="is-medium"
        type="is-primary"
        tag="router-link"
        :to="{ path: '/Team' }"
        outlined
      >
        🏸 寻找组队</b-button
      >
      <b-button
        size="is-medium"
        style="margin: 0 0 0 20px"
        type="is-primary"
        tag="router-link"
        :to="{ path: '/post/list' }"
        outlined
        >🏓浏览帖子</b-button
      >
      <p>&nbsp;</p>

      <b-button
        size="is-medium"
        style="margin: 20px 0 0 0"
        type="is-primary"
        tag="router-link"
        :to="{ path: '/Recommend' }"
        outlined
      >
        💻 智能推荐</b-button
      >

      <b-button
        size="is-medium"
        style="margin: 20px 0 0 20px"
        type="is-primary"
        @click="matchuser(user.bio)"
        outlined
        >🔍 用户匹配</b-button
      >
      <p>&nbsp;</p>
      <b-button
        size="is-medium"
        style="margin: 20px 0 0 0"
        type="is-primary"
        tag="router-link"
        :to="{ path: '/Club' }"
        outlined
        >⚽ 社团活动</b-button
      >
      <b-button
        size="is-medium"
        style="margin: 20px 0 0 20px"
        type="is-primary"
        tag="router-link"
        :to="{ path: '/Venue' }"
        outlined
      >
        🚩 场馆预约</b-button
      >
      <p>&nbsp;</p>
    </div>
  </el-card>
</template>

<script>
// import carousel2 from "@/components/Carousel/carousel2";
// import riqi from "../../assets/js/riqi.js";
import { mapGetters } from "vuex";

export default {
  name: "Service",
  //   components: { carousel2 },
  computed: {
    ...mapGetters(["token", "user"]),
  },
  data() {
    return {
      gym_reservation:
        "http://yuyue.seu.edu.cn/eduplus/order/initOrderIndex.do?sclId=1&t_s=1648261438486&amp_sec_version_=1&gid_=TCtROFBBdDk3VjVuMjZRVjhWVWhmb3NjaGx2RVcxVy94dlNQZFVucXNTRGJYeHVGWXN6V3VUSkVQT2Qzd0RzcGxiMkh5eUpTNVRKcVk2aG9NaDBWOGc9PQ&EMAP_LANG=zh&THEME=indigo",
    };
  },
  created() {},
  methods: {
    // open() {
    //   this.$alert(this.aa + "天", "预计可跑", {
    //     confirmButtonText: "确定",
    //   });
    // },
    // open2() {
    //   javascrtpt: window.location.href = this.gym_reservation;
    // },
    // matchuser(bio) {
    //   this.$router.push({ path: "/match?key=" + bio });
    // },
  },
};
</script>

<style>
</style>