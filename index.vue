<template>
  <div>
    <div class="mb-5">
      <Header></Header>
    </div>

    <div class="container context">
      <router-view :key="this.$route.fullPath"></router-view>
    </div>
    <div class="mb-5">
      <Footer></Footer>
    </div>
  </div>
</template>

<style>
</style>


<script>
import Header from "@/components/Layout/Header";
import Footer from "@/components/Layout/Footer";
import Home from "@/views/Home";
import { getinitnn } from "@/api/search";
// import {getinitnn} from "@/api/search";

export default {
  name: "Index",
  components: { Home, Header, Footer },
  //全局监听，跳转到新页面的时候默认到达顶部
  created() {
    this.initnn();
  },
  methods: {
    //在刚打开界面时，就对神经网络进行训练，不然去智能匹配的时候要等很久
    initnn() {
      getinitnn().then((response) => {
        const { data } = response;
      });
    },
  },
  watch: {
    $route: function (to, from) {
      document.body.scrollTop = 0;
      document.documentElement.scrollTop = 0;
    },
  },
};
</script>