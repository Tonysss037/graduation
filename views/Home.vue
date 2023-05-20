<template>
  <div>
    <div class="box">🔔 {{ billboard.content }}</div>
    <div class="columns">
      <div class="column is-one-thirds">
        <CardBar></CardBar>
      </div>
      <div class="column is-one-thirds">
        <Service></Service>
      </div>
      <div class="column is-pne-thirds">
        <recommend :topic-id="topic.id" />
      </div>
    </div>
  </div>
</template>

<script>
import { getBillboard } from "@/api/billboard";
import CardBar from "@/views/card/CardBar";
import Service from "@/views/card/Service.vue";
import PostList from "@/views/post/Index";
import Recommend from "@/views/post/Recommend.vue";

export default {
  name: "Home",
  components: { CardBar, TopicList: PostList, Service, Recommend },
  data() {
    return {
      billboard: {
        content: "",
      },
      topic: {
        content: "",
        id: "1332650453142827009",
      },
    };
  },
  created() {
    this.fetchBillboard();
  },
  methods: {
    async fetchBillboard() {
      getBillboard().then((value) => {
        const { data } = value;
        this.billboard = data;
      });
    },
  },
};
</script>
