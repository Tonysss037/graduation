<template>
  <div class="member">
    <div class="columns">
      <div class="column is-one-quarter">
        <el-card shadow="never">
          <div slot="header" class="has-text-centered">
            <el-avatar
              :size="64"
              :src="`https://cn.gravatar.com/avatar/${clubUser.id}?s=164&d=monsterid`"
            />
            <p class="mt-3">{{ clubUser.alias || clubUser.username }}</p>
          </div>
          <div>
            <p class="content">
              积分：<code>{{ clubUser.score }}</code>
            </p>
            <p class="content">
              入驻：{{
                dayjs(clubUser.createTime).format("YYYY/MM/DD HH:MM:ss")
              }}
            </p>
            <p class="content">简介：{{ clubUser.bio }}</p>
          </div>
        </el-card>
      </div>

      <div class="column">
        <el-card class="box-card content" shadow="never">
          <div slot="header" class="has-text-weight-bold">
            <span>活动</span>
          </div>

          <div v-if="clubs.length === 0">暂无组队</div>

          <div v-else class="clubUser-info">
            <article v-for="(item, index) in clubs" :key="index" class="media">
              <div class="media-content">
                <div class="content ellipsis is-ellipsis-1">
                  <el-tooltip
                    class="item"
                    effect="dark"
                    :content="item.content"
                    placement="top"
                  >
                    <router-link
                      :to="{ name: 'club-edit', params: { id: item.id } }"
                    >
                      {{ item.content }}
                    </router-link>
                  </el-tooltip>
                </div>
                <nav class="level has-text-grey is-size-7">
                  <div class="level-left">
                    <span class="mr-1">
                      加入时间:{{
                        dayjs(item.joinTime).format("YYYY/MM/DD HH:mm:ss")
                      }}
                      活动时间：{{
                        item.beginTime.split(":").slice(0, 2).join(":")
                      }}-{{ item.endTime.split(":").slice(0, 2).join(":") }}
                    </span>
                  </div>
                </nav>
              </div>
              <div v-if="token" class="media-right">
                <div v-if="clubUser.username === user.username" class="level">
                  <div class="level-item mr-1">
                    <!-- <router-link
                      :to="{ name: 'club-edit', params: { id: item.id } }"
                    >
                      <span class="tag is-warning">详情</span>
                    </router-link> -->
                    <!-- <a @click="handleDelete(item.id)"> -->
                    <a @click="handleClick(item)">
                      <span class="tag is-warning">详情</span>
                    </a>
                  </div>
                  <div class="level-item">
                    <a @click="handleDelete(item.id)">
                      <span class="tag is-danger">删除</span>
                    </a>
                  </div>
                </div>
              </div>
            </article>
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
              <el-button @click="dialogFormVisible = false">关 闭</el-button>
            </div>
          </el-dialog>

          <!--分页-->
          <pagination
            v-show="page.total > 0"
            class="mt-5"
            :total="page.total"
            :page.sync="page.current"
            :limit.sync="page.size"
            @pagination="fetchUserById"
          />
        </el-card>
      </div>
    </div>
  </div>
</template>

<script>
import { getInfoByNameC } from "@/api/user";
import pagination from "@/components/Pagination/index";
import { mapGetters } from "vuex";
import { deleteClub } from "@/api/club";

export default {
  name: "Profile",
  components: { pagination },
  data() {
    return {
      clubUser: {},
      clubs: {},
      page: {
        current: 1,
        size: 5,
        total: 0,
      },
      dialogFormVisible: false,
      club: {},
    };
  },
  computed: {
    ...mapGetters(["token", "user"]),
  },
  created() {
    this.fetchUserById();
  },
  methods: {
    fetchUserById() {
      getInfoByNameC(
        this.$route.params.username,
        this.page.current,
        this.page.size
      ).then((res) => {
        const { data } = res;
        this.clubUser = data.user;
        this.page.current = data.clubs.current;
        this.page.size = data.clubs.size;
        this.page.total = data.clubs.total;
        this.clubs = data.clubs.records;
      });
    },
    handleDelete(id) {
      deleteClub(id).then((value) => {
        const { code, message } = value;
        alert(message);
        if (code === 200) {
          setTimeout(() => {
            this.$router.go(0);
          }, 500);
        }
      });
    },
    handleClick(item) {
      this.club = item;
      this.dialogFormVisible = true;
    },
  },
};
</script>

<style scoped>
</style>
