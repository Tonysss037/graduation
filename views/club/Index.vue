<template>
  <el-card class="box-card" shadow="never" style="opacity: 0.9">
    <div slot="header">
      <el-calendar v-model="value">
        <template slot="dateCell" slot-scope="{ data }">
          <div style="height: 100%" @click="handleClick(data)">
            <div>{{ data.day.split("-").slice(2).join("-") }}</div>
            <div v-if="arr.find((v) => v.date === data.day)">
              {{ arr.find((v) => v.date === data.day).content }}<br />
              {{ arr.find((v) => v.date === data.day).place.slice(0, 2) }}<br />
              {{
                arr
                  .find((v) => v.date === data.day)
                  .beginTime.split(":")
                  .slice(0, 2)
                  .join(":")
              }}~{{
                arr
                  .find((v) => v.date === data.day)
                  .endTime.split(":")
                  .slice(0, 2)
                  .join(":")
              }}
            </div>
          </div>
        </template>
      </el-calendar>
    </div>

    <el-dialog
      title="社团活动详情"
      :visible.sync="dialogFormVisible"
      :show-close="false"
    >
      <el-form :model="club">
        <el-form-item label="日期">
          <el-input v-model="club.date" readonly></el-input>
        </el-form-item>
        <el-form-item label="活动内容">
          <el-input v-model="club.content" readonly></el-input>
        </el-form-item>
        <el-form-item label="社团名称">
          <el-input v-model="club.societies" readonly></el-input>
        </el-form-item>
        <el-form-item label="活动地点">
          <el-input v-model="club.place" readonly></el-input>
        </el-form-item>
        <el-form-item label="开始时间">
          <el-input v-model="club.beginTime" readonly></el-input>
        </el-form-item>
        <el-form-item label="结束时间">
          <el-input v-model="club.endTime" readonly></el-input>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="join(club.id)">加入社团活动</el-button>
        <el-button @click="dialogFormVisible = false">关 闭</el-button>
      </div>
    </el-dialog>
  </el-card>
</template>

<script>
import { getList, getClub, joinClub } from "@/api/club";
export default {
  name: "Club",
  data() {
    return {
      value: new Date(),
      arr: [],
      dialogFormVisible: false,
      club: {},
    };
  },
  created() {
    this.fetchList();
  },
  methods: {
    fetchList() {
      getList().then((response) => {
        const { data } = response;
        this.arr = data;
      });
    },
    handleClick(data) {
      if (data) {
        getClub(data.day).then((response) => {
          const { data } = response;
          this.club = data;
          this.dialogFormVisible = true;
        });
      }
    },
    join(id) {
      joinClub(id);
      alert("加入成功");
      this.dialogFormVisible = false;
    },
  },
};
</script>

<style scoped>
</style>