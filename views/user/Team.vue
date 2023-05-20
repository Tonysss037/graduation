<template>
  <div class="member">
    <div class="columns">
      <div class="column is-one-quarter">
        <el-card shadow="never">
          <div slot="header" class="has-text-centered">
            <el-avatar
              :size="64"
              :src="`https://cn.gravatar.com/avatar/${teamUser.id}?s=164&d=monsterid`"
            />
            <p class="mt-3">{{ teamUser.alias || teamUser.username }}</p>
          </div>
          <div>
            <p class="content">
              积分：<code>{{ teamUser.score }}</code>
            </p>
            <p class="content">
              入驻：{{
                dayjs(teamUser.createTime).format("YYYY/MM/DD HH:MM:ss")
              }}
            </p>
            <p class="content">简介：{{ teamUser.bio }}</p>
          </div>
        </el-card>
      </div>

      <div class="column">
        <!--用户发布的话题-->
        <el-card class="box-card content" shadow="never">
          <div slot="header" class="has-text-weight-bold">
            <span>组队</span>
          </div>

          <div v-if="teams.length === 0">暂无组队</div>

          <div v-else class="teamUser-info">
            <article v-for="(item, index) in teams" :key="index" class="media">
              <div class="media-content">
                <div class="content ellipsis is-ellipsis-1">
                  <el-tooltip
                    class="item"
                    effect="dark"
                    :content="item.title"
                    placement="top"
                  >
                    <router-link
                      :to="{ name: 'team-edit', params: { id: item.id } }"
                    >
                      {{ item.title }}
                    </router-link>
                  </el-tooltip>
                </div>
                <nav class="level has-text-grey is-size-7">
                  <div class="level-left">
                    <span class="mr-1">
                      发布于:{{
                        dayjs(item.createTime).format("YYYY/MM/DD HH:mm:ss")
                      }}
                    </span>
                  </div>
                </nav>
              </div>
              <div v-if="token" class="media-right">
                <div v-if="teamUser.username === user.username" class="level">
                  <div class="level-item mr-1">
                    <router-link
                      :to="{ name: 'team-edit', params: { id: item.id } }"
                    >
                      <span class="tag is-warning">编辑</span>
                    </router-link>
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
import { getInfoByNameT } from "@/api/user";
import pagination from "@/components/Pagination/index";
import { mapGetters } from "vuex";
import { deleteTeam } from "@/api/team";

export default {
  name: "Profile",
  components: { pagination },
  data() {
    return {
      teamUser: {},
      teams: {},
      page: {
        current: 1,
        size: 5,
        total: 0,
      },
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
      getInfoByNameT(
        this.$route.params.username,
        this.page.current,
        this.page.size
      ).then((res) => {
        const { data } = res;
        this.teamUser = data.user;
        this.page.current = data.teams.current;
        this.page.size = data.teams.size;
        this.page.total = data.teams.total;
        this.teams = data.teams.records;
      });
    },
    handleDelete(id) {
      console.log(1);
      deleteTeam(id).then((value) => {
        const { code, message } = value;
        alert(message);

        if (code === 200) {
          setTimeout(() => {
            this.$router.go(0);
          }, 500);
        }
      });
    },
  },
};
</script>

<style scoped>
</style>
