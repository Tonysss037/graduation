<template>
  <section>
    <div class="columns">
      <div class="column is-full">
        <el-card class="box-card" shadow="never">
          <div slot="header" class="clearfix">
            <span><i class="fa fa fa-book"> 主题 / 更新组队信息</i></span>
          </div>
          <div>
            <el-form :model="team" ref="team" class="demo-team">
              <el-form-item prop="title">
                <el-input
                  v-model="team.title"
                  placeholder="请输入运动的名称，地点，时间和其他要求"
                ></el-input>
              </el-form-item>

              <el-form-item prop="tags">
                <el-select
                  v-model="team.tags"
                  clearable
                  allow-create
                  placeholder="请选择组队类型"
                  @change="changeShow"
                >
                  <el-option
                    v-for="item in options"
                    :key="item.key"
                    :label="item.label"
                    :value="item.value"
                  >
                  </el-option>
                </el-select>
                <el-input
                  style="width: 80%"
                  v-if="isShow"
                  v-model="team.tags"
                  placeholder="请输入运动类型，双人运动、单人运动、其他运动"
                />
              </el-form-item>
              <el-form-item prop="view">
                <el-input
                  style="width: 30%"
                  v-model="team.view"
                  placeholder="请输入已有组队人数，若不填写则默认值为1"
                />
              </el-form-item>

              <el-form-item class="mt-3">
                <el-button type="primary" @click="handleUpdate()"
                  >更新
                </el-button>
                <el-button @click="resetForm('team')">重置</el-button>
              </el-form-item>
            </el-form>
          </div>
        </el-card>
      </div>
    </div>
  </section>
</template>

<script>
import { getTeam, update } from "@/api/team";
import "vditor/dist/index.css";

export default {
  name: "TeamEdit",
  components: {},
  data() {
    return {
      team: {},
      tags: {},
      view: {},
      options: [
        {
          value: "足球",
        },
        {
          value: "篮球",
        },
        {
          value: "排球",
        },
        {
          value: "网球",
        },
        {
          value: "乒乓球",
        },
        {
          value: "羽毛球",
        },
        {
          value: "其他",
        },
      ],
      value: "",
      isShow: false,
    };
  },
  created() {
    this.fetchTeam();
  },
  methods: {
    changeShow() {
      console.log(this.team.tags);
      if (this.team.tags === "其他") {
        this.isShow = true;
      }
    },
    fetchTeam() {
      getTeam(this.$route.params.id).then((value) => {
        this.team = value.data.team;
        this.tags = value.data.tags;
        this.view = value.data.view;
      });
    },
    handleUpdate: function () {
      update(this.team).then((response) => {
        const { data } = response;
        console.log(data);
        setTimeout(() => {
          this.$router.go(0);
        }, 800);
      });
    },

    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
  },
};
</script>

<style>
.vditor-reset pre > code {
  font-size: 100%;
}
</style>
