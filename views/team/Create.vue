<template>
  <div class="columns">
    <div class="column is-full">
      <el-card class="box-card" shadow="never">
        <div slot="header" class="clearfix">
          <span><i class="fa fa fa-book"> 主题 / 发布组队信息</i></span>
        </div>
        <div>
          <el-form
            ref="ruleForm"
            :model="ruleForm"
            :rules="rules"
            class="demo-ruleForm"
          >
            <el-form-item prop="title">
              <el-input
                v-model="ruleForm.title"
                placeholder="请输入运动的名称，地点，时间和其他要求"
              />
            </el-form-item>
            <el-form-item prop="tags">
              <el-select
                v-model="ruleForm.tags"
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
                v-model="ruleForm.tags"
                placeholder="请输入运动类型，双人运动、单人运动、其他运动"
              />
            </el-form-item>
            <el-form-item prop="view">
              <el-input
                style="width: 30%"
                v-model="ruleForm.view"
                placeholder="请输入已有组队人数，若不填写则默认值为1"
              />
            </el-form-item>

            <el-form-item>
              <el-button type="primary" @click="submitForm('ruleForm')"
                >立即发布
              </el-button>
              <el-button @click="resetForm('ruleForm')">重置</el-button>
            </el-form-item>
          </el-form>
        </div>
      </el-card>
    </div>
  </div>
</template>

<script>
import { team } from "@/api/team";

export default {
  name: "TeamPost",

  data() {
    return {
      ruleForm: {
        title: "", // 标题
        tags: "", // 标签
        view: "", //组队人数
      },
      rules: {
        title: [
          { required: true, message: "请输入话题名称", trigger: "blur" },
          {
            min: 1,
            max: 25,
            message: "长度在 1 到 25 个字符",
            trigger: "blur",
          },
        ],
      },
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
  methods: {
    changeShow() {
      if (this.ruleForm.tags === "其他") {
        this.isShow = true;
      } else {
        this.isShow = false;
      }
    },
    submitForm(formName) {
      this.$refs[formName].validate((valid) => {
        console.log(this.ruleForm);
        if (valid) {
          if (this.ruleForm.tags == null || this.ruleForm.tags.length === 0) {
            alert("标签不可以为空");
            return false;
          }
          if (this.ruleForm.view == null || this.ruleForm.tags.length === 0) {
            this.ruleForm.view = 1;
          }
          console.log(this.ruleForm);
          team(this.ruleForm).then((response) => {
            alert("组队添加成功");
            setTimeout(() => {
              this.$router.push({
                name: "team",
              });
            }, 800);
          });
        } else {
          console.log("出错了，可能是已有类似组队名称");
          return false;
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
  },
};
</script>

<style>
</style>
