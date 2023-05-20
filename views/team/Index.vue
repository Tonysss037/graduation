<template>
  <el-card class="box-card" shadow="never" style="opacity: 0.9">
    <div slot="header">
      <span style="font-weight: bold"
        >😂 进入感兴趣的专区来加入运动, 或者点击右边按钮来查看组队信息吧</span
      >
      <b-button
        class="btn-animate"
        style="
          float: right;
          margin-right: 50px;
          margin-top: 0px;
          font-size: 16px;
          font-weight: bold;
        "
        tag="router-link"
        :to="{ path: `/member/${user.username}/team` }"
      >
        我的组队</b-button
      >
    </div>
    <!-- <el-tabs v-model="activeName" @tab-click="handleClick"> -->
    <el-tabs v-model="activeName">
      <el-tab-pane label="多人运动" name="bigball">
        <div>
          <img
            style="width: 200px; margin-top: 20px"
            src="../../assets/image/football.jpg"
            v-on:click="football"
          />
          <img
            style="width: 200px; margin-top: 20px; margin-left: 70px"
            src="../../assets/image/basketball.jpg"
            v-on:click="basketball"
          />
          <img
            style="width: 200px; margin-top: 20px; margin-left: 70px"
            src="../../assets/image/volleyball.jpg"
            v-on:click="volleyball"
          />
          <img
            style="width: 200px; margin-top: 20px; margin-left: 70px"
            src="../../assets/image/other.jpg"
            v-on:click="others"
          />
        </div>
      </el-tab-pane>
      <el-tab-pane label="少人运动" name="smallball">
        <div>
          <img
            style="width: 200px; margin-top: 20px"
            src="../../assets/image/badminton.jpg"
            v-on:click="badminton"
          />
          <img
            style="width: 200px; margin-top: 20px; margin-left: 70px"
            src="../../assets/image/ping pong.jpg"
            v-on:click="pingpong"
          />
          <img
            style="width: 200px; margin-top: 20px; margin-left: 70px"
            src="../../assets/image/tennis.jpg"
            v-on:click="tennis"
          />
          <img
            style="width: 200px; margin-top: 20px; margin-left: 70px"
            src="../../assets/image/other.jpg"
            v-on:click="others"
          />
        </div>
      </el-tab-pane>
    </el-tabs>
  </el-card>
</template>

<script>
import { mapGetters } from "vuex";

export default {
  name: "Team",
  data() {
    return {
      activeName: "bigball",
    };
  },
  computed: {
    ...mapGetters(["token", "user"]),
  },
  methods: {
    // handleClick(tab) {
    // this.page.current = 1;
    // this.init(tab.name);
    // },
    football() {
      this.$router.push({ path: "/Football" });
    },
    basketball() {
      this.$router.push({ path: "/Basketball" });
    },
    volleyball() {
      this.$router.push({ path: "/Volleyball" });
    },
    badminton() {
      this.$router.push({ path: "/Badminton" });
    },
    pingpong() {
      this.$router.push({ path: "/Pingpong" });
    },
    tennis() {
      this.$router.push({ path: "/Tennis" });
    },
    others() {
      this.$router.push({ path: "/Others" });
    },
  },
};
</script>

<style scoped>
body {
  display: -webkit-box;
  display: -ms-flexbox;
  display: flex;
  -webkit-box-align: center;
  -ms-flex-align: center;
  align-items: center;
  -webkit-box-pack: center;
  -ms-flex-pack: center;
  justify-content: center;
  min-height: 100vh;
  font-family: "Source Sans Pro", sans-serif;
}
.btn-animate {
  color: #fff;
  font-size: 14px;
  font-weight: 600;
  letter-spacing: 2px;
  cursor: pointer;
  position: relative;
  z-index: 1;
  padding: 15px 30px;
  border: none;
  border-radius: 4px;
  box-shadow: 0px 16px 47px -15px #590b9b;
  background: none;
  -webkit-transition: all 0.2s cubic-bezier(0.19, 1, 0.22, 1);
  transition: all 0.2s cubic-bezier(0.19, 1, 0.22, 1);
  border-radius: 8px;
  overflow: hidden;
  outline: none;
  -webkit-transform: translateZ(0);
  transform: translateZ(0);
}
.btn-animate span {
  position: relative;
  z-index: 2;
}
.btn-animate:before,
.btn-animate:after {
  border-radius: 8px;
  content: "";
  z-index: -1;
  background: -webkit-linear-gradient(350deg, #560a9b, #a53498);
  background: linear-gradient(100deg, #560a9b, #d928c3);
  content: "";
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
}
.btn-animate:after {
  background: -webkit-linear-gradient(350deg, #003f77, #05c4b5);
  background: linear-gradient(100deg, #53aaf6, #5aece0);
  -webkit-transform: scaleY(0);
  transform: scaleY(0);
  -webkit-transform-origin: top;
  transform-origin: top;
  -webkit-transition: -webkit-transform 0.5s cubic-bezier(0.19, 1, 0.22, 1);
  transition: -webkit-transform 0.5s cubic-bezier(0.19, 1, 0.22, 1);
  transition: transform 0.5s cubic-bezier(0.19, 1, 0.22, 1);
  transition: transform 0.5s cubic-bezier(0.19, 1, 0.22, 1),
    -webkit-transform 0.5s cubic-bezier(0.19, 1, 0.22, 1);
  -webkit-transition-delay: 0.1s;
  transition-delay: 0.1s;
}
.btn-animate:hover {
  box-shadow: 0px 16px 47px -15px #003f77;
}
.btn-animate:hover:after {
  -webkit-transform: scaleY(1);
  transform: scaleY(1);
  -webkit-transform-origin: bottom;
  transform-origin: bottom;
  -webkit-transition-delay: 0s;
  transition-delay: 0s;
}
.btn-animate:active {
  -webkit-transform: translateY(4px) translateZ(0);
  transform: translateY(4px) translateZ(0);
  box-shadow: 0px 8px 10px -6px #003f77;
}
</style>