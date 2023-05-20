<template>
  <el-card class="box-card" shadow="never" style="opacity: 0.9">
    <div slot="header">
      <span style="font-weight: bold"
        >😂 不知道今天做什么运动？ 选择下方的选项，我来为你推荐一项运动</span
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
        @click="getRecommendation"
      >
        获取推荐</b-button
      >
    </div>
    <div class="body">
      <div class="condition-row">
        <label>温度：</label>
      </div>
      <div class="radio-wrapper">
        <el-radio-group v-model="selectedTemperature">
          <el-radio
            v-for="temperature in temperatures"
            :key="temperature"
            :label="temperature"
            >{{ temperature }}</el-radio
          >
        </el-radio-group>
      </div>
      <hr />

      <div class="condition-row">
        <label>天气：</label>
      </div>
      <div class="radio-wrapper">
        <el-radio-group v-model="selectedWeather">
          <el-radio
            v-for="weather in weathers"
            :key="weather"
            :label="weather"
            >{{ weather }}</el-radio
          >
        </el-radio-group>
      </div>

      <hr />
      <div class="condition-row">
        <label>人数：</label>
      </div>
      <div class="radio-wrapper">
        <el-radio-group v-model="selectedPeople">
          <el-radio v-for="people in peoples" :key="people" :label="people">{{
            people
          }}</el-radio>
        </el-radio-group>
      </div>
      <hr />
      <div class="condition-row">
        <label>距离：</label>
      </div>
      <div class="radio-wrapper">
        <el-radio-group v-model="selectedDistance">
          <el-radio
            v-for="distance in distances"
            :key="distance"
            :label="distance"
            >{{ distance }}</el-radio
          >
        </el-radio-group>
      </div>
      <hr />
      <div class="condition-row">
        <label>是否带球：</label>
      </div>
      <div class="radio-wrapper">
        <el-radio-group v-model="selectedIsBalls">
          <el-radio v-for="isBall in is_balls" :key="isBall" :label="isBall">{{
            isBall
          }}</el-radio>
        </el-radio-group>
      </div>
    </div>
    <div>
      <!-- 展示建议数据 -->
      <el-dialog
        v-if="advice"
        title="运动推荐"
        :visible="showAdviceDialog"
        @close="closeAdviceDialog"
      >
        <div v-if="advice === '足球'">
          <h2>足球介绍</h2>
          <b-button
            class="btn-animate"
            style="
              float: right;
              margin-right: 50px;
              margin-top: -30px;
              font-size: 16px;
              font-weight: bold;
            "
            tag="router-link"
            :to="{ path: `/Team` }"
          >
            前往组队</b-button
          >
          <hr />
          <img src="../../assets/image/football1.jpg" style="width: 700px" />
          <p style="width: 700px">
            足球是一项世界性的运动，也是最受欢迎和最广泛参与的运动之一。它的目标是用脚踢球将球射入对方球门，以获得得分。足球不仅可以提高身体素质，如耐力、速度和协调性，还培养团队合作和战术意识。这项运动能够增强心肺功能，锻炼肌肉，提升身体灵活性，同时也是交友和享受竞技乐趣的良好方式。
          </p>
        </div>
        <div v-else-if="advice === '篮球'">
          <h2>篮球介绍</h2>
          <b-button
            class="btn-animate"
            style="
              float: right;
              margin-right: 50px;
              margin-top: -30px;
              font-size: 16px;
              font-weight: bold;
            "
            tag="router-link"
            :to="{ path: `/Team` }"
          >
            前往组队</b-button
          >
          <hr />
          <img src="../../assets/image/basketball1.jpg" style="width: 700px" />
          <p style="width: 700px">
            篮球是一项流行的团队运动，它的目标是将球投入对方的篮筐得分。篮球要求球员具备敏捷的身体动作、卓越的运球和传球技巧以及准确的投篮能力。此外，篮球也是一项有益于身体健康的运动，通过奔跑、跳跃和变向等动作，能够增强心肺功能、提高肌肉力量和灵活性。参与篮球运动还可以培养团队精神、增强自信心和合作意识。
          </p>
        </div>
        <div v-else-if="advice === '排球'">
          <h2>排球介绍</h2>
          <b-button
            class="btn-animate"
            style="
              float: right;
              margin-right: 50px;
              margin-top: -30px;
              font-size: 16px;
              font-weight: bold;
            "
            tag="router-link"
            :to="{ path: `/Team` }"
          >
            前往组队</b-button
          >
          <hr />
          <img src="../../assets/image/volleyball1.jpg" style="width: 700px" />
          <p style="width: 700px">
            排球是一项室内或沙滩上进行的团队运动，它的目标是将球通过发球、传球和扣球等动作使其落在对方场地得分。排球需要球员具备良好的协调性、反应速度和爆发力，同时还要具备团队合作和战术意识。参与排球运动可以锻炼上肢力量、提高敏捷性和灵活性，对于促进身体协调和平衡也很有帮助。无论是在比赛中还是休闲娱乐中，排球都能带给人们欢乐和健康的体验。
          </p>
        </div>
        <div v-else-if="advice === '乒乓球'">
          <h2>乒乓球介绍</h2>
          <b-button
            class="btn-animate"
            style="
              float: right;
              margin-right: 50px;
              margin-top: -30px;
              font-size: 16px;
              font-weight: bold;
            "
            tag="router-link"
            :to="{ path: `/Team` }"
          >
            前往组队</b-button
          >
          <hr />
          <img src="../../assets/image/ping pong1.jpg" style="width: 700px" />
          <p style="width: 700px">
            乒乓球，又称乒乓球球类运动，是一项使用小巧球拍击打乒乓球的室内运动。它强调快速反应和精确控制球的技巧。乒乓球是一项适合所有年龄段的运动，它可以提高手眼协调能力、反应速度和专注力。此外，乒乓球还对身体健康有益，能够增强肌肉力量、提高心肺功能和促进血液循环。作为一种社交和竞技活动，乒乓球也为人们带来了快乐和紧张的比赛体验。
          </p>
        </div>
        <div v-else-if="advice === '羽毛球'">
          <h2>羽毛球介绍</h2>
          <b-button
            class="btn-animate"
            style="
              float: right;
              margin-right: 50px;
              margin-top: -30px;
              font-size: 16px;
              font-weight: bold;
            "
            tag="router-link"
            :to="{ path: `/Team` }"
          >
            前往组队</b-button
          >
          <hr />
          <img src="../../assets/image/badminton1.jpg" style="width: 700px" />
          <p style="width: 700px">
            羽毛球是一项常见的室内或户外运动，使用羽毛球拍将羽毛球击打过网，与对方进行对抗。羽毛球要求球员具备灵活的脚步、快速的反应和准确的击球技巧。参与羽毛球运动可以锻炼全身肌肉，特别是上肢和下肢力量，提高心肺功能和身体协调性。羽毛球也是一项有趣的休闲运动，与朋友或家人一起打羽毛球不仅能够享受运动乐趣，还可以促进社交交流。
          </p>
        </div>
        <div v-else-if="advice === '网球'">
          <h2>网球介绍</h2>
          <b-button
            class="btn-animate"
            style="
              float: right;
              margin-right: 50px;
              margin-top: -30px;
              font-size: 16px;
              font-weight: bold;
            "
            tag="router-link"
            :to="{ path: `/Team` }"
          >
            前往组队</b-button
          >
          <hr />
          <img src="../../assets/image/tennis1.jpg" style="width: 700px" />
          <p style="width: 700px">
            网球是一项室外进行的运动，使用网球拍在网球场上进行对抗。它强调准确的击球技巧、快速的反应能力和良好的身体耐力。网球可以提高手眼协调能力、灵活性和心肺功能。参与网球运动还可以锻炼肌肉力量、提高反应速度和促进身体协调性。无论是单打还是双打，网球都是一项令人兴奋和有挑战性的运动，让人们在运动中享受竞技乐趣和社交互动。
          </p>
        </div>
        <div v-else-if="advice === '跑步'">
          <h2>跑步介绍</h2>
          <b-button
            class="btn-animate"
            style="
              float: right;
              margin-right: 50px;
              margin-top: -30px;
              font-size: 16px;
              font-weight: bold;
            "
            tag="router-link"
            :to="{ path: `/Team` }"
          >
            前往组队</b-button
          >
          <hr />
          <img src="../../assets/image/jogging1.jpg" style="width: 700px" />
          <p style="width: 700px">
            跑步是一种简单而受欢迎的有氧运动，可以在室内或户外进行。它不仅可以提升心肺功能和身体耐力，还能够减轻压力、促进代谢和维持身体健康。跑步是一项自由灵活的运动，你可以根据自己的喜好和目标来调整跑步的强度和距离。无论是慢跑还是长跑，都能够让你感受到身体的活力和心灵的宁静。
          </p>
        </div>
        <div v-else-if="advice === '游泳'">
          <h2>游泳介绍</h2>
          <b-button
            class="btn-animate"
            style="
              float: right;
              margin-right: 50px;
              margin-top: -30px;
              font-size: 16px;
              font-weight: bold;
            "
            tag="router-link"
            :to="{ path: `/Team` }"
          >
            前往组队</b-button
          >
          <hr />
          <img src="../../assets/image/swim1.jpg" style="width: 700px" />
          <p style="width: 700px">
            游泳是一项全身性的有氧运动，通过在水中进行各种姿势的移动来推动身体。游泳可以锻炼全身肌肉，尤其是背部、腹部和手臂肌肉，同时提高心肺功能和耐力。游泳对于改善姿势、增强柔韧性和减轻关节负担也非常有益。不论是在游泳池还是在海洋中畅游，游泳是一项令人愉悦和放松的运动，同时也是夏季炎热天气下的最佳消暑选择。
          </p>
        </div>
        <div v-else-if="advice === '滑板'">
          <h2>滑板介绍</h2>
          <b-button
            class="btn-animate"
            style="
              float: right;
              margin-right: 50px;
              margin-top: -30px;
              font-size: 16px;
              font-weight: bold;
            "
            tag="router-link"
            :to="{ path: `/Team` }"
          >
            前往组队</b-button
          >
          <hr />
          <img src="../../assets/image/skateboard1.jpg" style="width: 700px" />
          <p style="width: 700px">
            滑板是一项极限运动，通过在滑板上进行各种技巧动作来展现个人的想象力和技巧。滑板运动可以锻炼平衡力、灵活性和反应能力，同时也提高身体的协调性和肌肉力量。滑板运动是一项需要耐心和毅力的运动，它不仅可以满足个人挑战的欲望，还能够带来刺激和成就感。
          </p>
        </div>
        <div v-else-if="advice === '瑜伽'">
          <h2>瑜伽介绍</h2>
          <b-button
            class="btn-animate"
            style="
              float: right;
              margin-right: 50px;
              margin-top: -30px;
              font-size: 16px;
              font-weight: bold;
            "
            tag="router-link"
            :to="{ path: `/Team` }"
          >
            前往组队</b-button
          >
          <hr />
          <img src="../../assets/image/yoga1.jpg" style="width: 700px" />
          <p style="width: 700px">
            瑜伽是一种古老的身体和心灵练习，通过各种体位法、调息和冥想来促进身心健康。瑜伽练习可以提高身体柔韧性、平衡力和核心力量，同时也有助于减轻压力、提高专注力和培养内心平静。无论是在瑜伽馆还是在家中，通过瑜伽练习，你可以找到身心和谐的平衡，享受身体和灵魂的放松与舒展。
          </p>
        </div>

        <div v-else>
          <h2>不建议运动</h2>
          <hr />
          <img src="../../assets/image/stayhome.jpg" style="width: 700px" />
          <p style="width: 700px">
            根据所选信息分析，目前不适合外出运动，建议好好休息
          </p>
        </div>
      </el-dialog>
    </div>
  </el-card>
</template>

<script>
import { recommend } from "@/api/recommend2";
export default {
  data() {
    return {
      temperatures: ["炎热", "适中", "寒冷"],
      weathers: ["晴天", "多云", "雨雾"],
      peoples: ["双人", "多人"],
      distances: ["短", "长"],
      is_balls: ["是", "否"],
      selectedTemperature: "",
      selectedWeather: "",
      selectedPeople: "",
      selectedDistance: "",
      selectedIsBalls: "",
      advice: "", // 建议数据
      showAdviceDialog: false,
    };
  },
  methods: {
    getRecommendation() {
      const temperatureMappings = {
        t1: "炎热",
        t2: "适中",
        t3: "寒冷",
      };

      const weatherMappings = {
        w1: "晴天",
        w2: "多云",
        w3: "雨雾",
      };

      const peopleMappings = {
        p1: "双人",
        p2: "多人",
      };

      const distanceMappings = {
        d1: "短",
        d2: "长",
      };

      const isBallsMappings = {
        b1: "是",
        b2: "否",
      };

      // 获取选中的单选按钮的值
      const selectedTemperature = this.selectedTemperature;
      const selectedWeather = this.selectedWeather;
      const selectedPeople = this.selectedPeople;
      const selectedDistance = this.selectedDistance;
      const selectedIsBalls = this.selectedIsBalls;

      // 根据选中的温度值在temperatureMappings中查找对应的键
      let temperature = "";
      for (const [key, value] of Object.entries(temperatureMappings)) {
        if (value === selectedTemperature) {
          temperature = key;
          break;
        }
      }

      // 根据选中的天气值在weatherMappings中查找对应的键
      let weather = "";
      for (const [key, value] of Object.entries(weatherMappings)) {
        if (value === selectedWeather) {
          weather = key;
          break;
        }
      }

      // 根据选中的人数值在peopleMappings中查找对应的键
      let people = "";
      for (const [key, value] of Object.entries(peopleMappings)) {
        if (value === selectedPeople) {
          people = key;
          break;
        }
      }

      // 根据选中的距离值在distanceMappings中查找对应的键
      let distance = "";
      for (const [key, value] of Object.entries(distanceMappings)) {
        if (value === selectedDistance) {
          distance = key;
          break;
        }
      }

      // 根据选中的是否是球类值在isBallsMappings中查找对应的键
      let isBalls = "";
      for (const [key, value] of Object.entries(isBallsMappings)) {
        if (value === selectedIsBalls) {
          isBalls = key;
          break;
        }
      }

      // 检查变量值是否为空
      if (!temperature || !weather || !people || !distance || !isBalls) {
        // 提示需要全部选择
        alert("选项需要全部选择完毕后才能推荐");
        return;
      }

      const requestData = {
        temperature: temperature,
        weather: weather,
        people: people,
        distance: distance,
        isBalls: isBalls,
      };
      recommend(requestData)
        .then((response) => {
          // 接收到建议数据，将其赋值给advice变量
          this.advice = response.data;
          this.showAdviceDialog = true;
        })
        .catch((error) => {
          console.error(error);
        });
    },
    closeAdviceDialog() {
      // 关闭建议弹出框
      this.showAdviceDialog = false;
    },
  },
};
</script>

<style>
h2 {
  font-size: 24px; /* 可根据需要调整字体大小 */
}
p {
  text-indent: 2em;
  font-size: 16px;
}
.condition-row {
  display: flex;
  align-items: center;
  margin-bottom: 10px;
  font-size: 1.5em;
}
.radio-group-horizontal {
  display: flex;
}
.radio-wrapper {
  display: flex;
  flex-wrap: wrap;
  margin-top: 20px;
}
body {
  display: -webkit-box;
  display: -ms-flexbox;
  /* display: flex; */
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
