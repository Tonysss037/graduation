<template>
  <el-card class="box-card" shadow="never" style="opacity: 0.9">
    <div slot="header">
      <span style="font-weight: bold"
        >😂
        浏览选择各个校区的场馆使用情况,或者点击右边按钮来查看预约信息吧</span
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
        我的场馆</b-button
      >
    </div>
    <div>
      <el-row style="display: flex; margin-top: 20px">
        <el-col :span="12" style="margin-right: 10px; text-align: center">
          <img src="../../assets/image/venue1.jpg" alt="场馆图片" />
          <p style="margin: 0; font-size: 20px; font-weight: bold">苍梧校区</p>
        </el-col>
        <el-col :span="12">
          <el-button round @click="showDialog" style="margin-top: 20px"
            >羽毛球馆</el-button
          >
          <el-button round style="margin: 5px">乒乓球馆</el-button>
          <el-button round style="margin: 5px">篮球场</el-button>
          <el-button round style="margin: 5px">排球场</el-button>
          <el-button round style="margin: 5px">足球场</el-button>
          <el-button round style="margin: 5px">健身房</el-button>
        </el-col>
      </el-row>
      <el-row style="display: flex; margin-top: 20px">
        <el-col :span="12" style="margin-right: 10px; text-align: center">
          <img src="../../assets/image/venue2.jpg" alt="场馆图片" />
          <p style="margin: 0; font-size: 20px; font-weight: bold">通灌校区</p>
        </el-col>
        <el-col :span="12">
          <el-button round style="margin-top: 20px">羽毛球馆</el-button>
          <el-button round style="margin: 5px">乒乓球馆</el-button>
          <el-button round style="margin: 5px">篮球场</el-button>
          <el-button round style="margin: 5px">健身房</el-button>
        </el-col>
      </el-row>
      <el-row style="display: flex; margin-top: 20px">
        <el-col :span="12" style="margin-right: 10px; text-align: center">
          <img src="../../assets/image/venue3.jpg" alt="场馆图片" />
          <p style="margin: 0; font-size: 20px; font-weight: bold">宋跳校区</p>
        </el-col>
        <el-col :span="12">
          <el-button round style="margin-top: 20px">羽毛球馆</el-button>
          <el-button round style="margin: 5px">乒乓球馆</el-button>
          <el-button round style="margin: 5px">篮球场</el-button>
          <el-button round style="margin: 5px">足球场</el-button>
        </el-col>
      </el-row>
    </div>
    <hr />
    <div>
      <el-button type="primary" @click="showDialog">预约信息</el-button>
      <el-dialog :visible.sync="dialogVisible" title="苍梧校区羽毛球馆">
        <el-table :data="bookingInfo" stripe style="width: 100%">
          <el-table-column prop="date" label="日期"></el-table-column>
          <el-table-column prop="timeSlot" label="时间段"></el-table-column>
          <el-table-column prop="available" label="可预约"></el-table-column>
        </el-table>
        <div slot="footer" class="dialog-footer">
          <el-button type="primary" @click="dialogVisible = false"
            >关闭</el-button
          >
        </div>
      </el-dialog>
    </div>
  </el-card>
</template>

<script>
import { mapGetters } from "vuex";
// import { mapState } from "vuex";

export default {
  name: "Team",
  data() {
    return {
      activeName: "Campus1",
      dialogVisible: false,
      bookingInfo: [
        {
          date: "2023-05-05",
          timeSlot: "09:00-10:00",
          available: "是",
        },
        {
          date: "2023-05-05",
          timeSlot: "10:00-11:00",
          available: "是",
        },
        {
          date: "2023-05-05",
          timeSlot: "11:00-12:00",
          available: "否",
        },
        {
          date: "2023-05-06",
          timeSlot: "09:00-10:00",
          available: "是",
        },
        {
          date: "2023-05-06",
          timeSlot: "10:00-11:00",
          available: "是",
        },
        {
          date: "2023-05-06",
          timeSlot: "11:00-12:00",
          available: "是",
        },
      ],
    };
  },
  computed: {
    ...mapGetters(["token", "user"]),
    // ...mapState({
    //   bookingInfo: (state) => state.gym.bookingInfo,
    // }),
  },
  methods: {
    showDialog() {
      this.dialogVisible = true;
    },

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
.dialog-footer {
  text-align: center;
}
</style>