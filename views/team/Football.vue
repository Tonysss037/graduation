<template>
  <div>
    <el-card shadow="never">
      <div slot="header" class="clearfix">
        <article
          v-for="(item, index) in articleList"
          :key="index"
          class="media"
        >
          <div class="media-left">
            <figure>
              <img
                style="width: 200px; height: 130px"
                src="../../assets/image/football.jpg"
              />
            </figure>
          </div>
          <div class="media-content">
            <div class="">
              <p class="ellipsis is-ellipsis-1">
                <el-tooltip
                  class="item"
                  effect="dark"
                  :content="item.title"
                  placement="top"
                >
                  <span class="is-size-6">{{ item.title }}</span>
                </el-tooltip>
              </p>
            </div>
            <nav class="level has-text-grey is-mobile is-size-7 mt-2">
              <div class="level-left">
                <div class="level-left">
                  <router-link
                    class="level-item"
                    :to="{ path: `/member/${item.username}/home` }"
                  >
                    {{ item.alias }}
                  </router-link>

                  <span class="mr-1">
                    发布于:{{ dayjs(item.createTime).format("YYYY/MM/DD") }}
                  </span>

                  <span class="is-hidden-mobile"
                    >组队人数：:{{ item.view }}/22人</span
                  >
                </div>
              </div>
              <div v-if="item.view <= 21" class="media-right">
                <b-button
                  class="btn-animate join"
                  @click="jointhem(item.id, index)"
                  >加我一个</b-button
                >
              </div>
              <div v-else>
                <span
                  class="is-hidden-mobile join"
                  style="margin-left: 7px; font-size: 20px"
                  >已满</span
                >
              </div>
            </nav>
          </div>
          <div class="media-right" />
        </article>
      </div>

      <!--分页-->
      <pagination
        v-show="page.total > 0"
        :total="page.total"
        :page.sync="page.current"
        :limit.sync="page.size"
        @pagination="init"
      />
    </el-card>
  </div>
</template>

<script>
import { join, getListFootball } from "@/api/team";
import Pagination from "@/components/Pagination";
import { mapGetters } from "vuex";

export default {
  name: "Football",
  components: { Pagination },
  data() {
    return {
      activeName: "latest",
      articleList: [],
      topicUser: {},
      page: {
        current: 1,
        size: 10,
        total: 0,
        tab: "latest",
      },
    };
  },
  computed: {
    ...mapGetters(["token", "user"]),
  },
  created() {
    this.init(this.tab);
  },
  methods: {
    init(tab) {
      getListFootball(this.page.current, this.page.size, tab).then(
        (response) => {
          const { data } = response;
          this.page.current = data.current;
          this.page.total = data.total;
          this.page.size = data.size;
          this.articleList = data.records;
        }
      );
    },
    handleClick(tab) {
      this.page.current = 1;
      this.init(tab.name);
    },
    jointhem(id, index) {
      if (this.joinornot == 1) {
        alert("一个人只能添加一次噢");
        return false;
      } else {
        alert("预约成功，请在约定时间内到达地点噢");
        const buttons = document.getElementsByClassName("join");
        for (let i = 0; i < buttons.length; i++) {
          if (i === index) {
            buttons[i].textContent = "已添加";
            buttons[i].disabled = true;
          }
        }
        join(id);
      }
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
  box-shadow: 0px 16px 47px -15px #9a59d2;
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
  background: -webkit-linear-gradient(350deg, #560a9b, #9e158f);
  background: linear-gradient(100deg, #ff9569, #e92758);
  content: "";
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
}
.btn-animate:after {
  background: -webkit-linear-gradient(350deg, #003f77, #5aada6);
  background: linear-gradient(100deg, #29bdd9, #276ace);
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
