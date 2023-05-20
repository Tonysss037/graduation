import Vue from "vue";
import VueRouter from "vue-router";

Vue.use(VueRouter);

const routes = [
  // 主页
  {
    path: "/",
    name: "Home",
    component: () => import("@/views/Home"),
  },
  // 注册
  {
    path: "/register",
    name: "register",
    component: () => import("@/views/auth/Register"),
    meta: { title: "注册" },
  },
  // 登录
  {
    name: "login",
    path: "/login",
    component: () => import("@/views/auth/Login"),
    meta: { title: "登录" },
  },
  // 信息展示
  {
    name: "post-list",
    path: "/post/list",
    component: () => import("@/views/post/Index"),
    meta: { title: "浏览帖子", requireAuth: true },
  },
  // 信息发布
  {
    name: "post-create",
    path: "/post/create",
    component: () => import("@/views/post/Create"),
    meta: { title: "信息发布", requireAuth: true },
  },
  //组队发布
  {
    name: "team-create",
    path: "/team/create",
    component: () => import("@/views/team/Create"),
    meta: { title: "组队发布", requireAuth: true },
  },
  // 编辑话题
  {
    name: 'topic-edit',
    path: '/topic/edit/:id',
    component: () => import('@/views/post/Edit'),
    meta: {
      title: '编辑',
      requireAuth: true
    }
  },
  // 编辑组队
  {
    name: 'team-edit',
    path: '/team/edit/:id',
    component: () => import('@/views/team/Edit'),
    meta: {
      title: '编辑',
      requireAuth: true
    }
  },

  // 详情
  {
    name: "post-detail",
    path: "/post/:id",
    component: () => import("@/views/post/Detail"),
    meta: { title: "详情" },
  },
  // 标签
  {
    name: 'tag',
    path: '/tag/:name',
    component: () => import('@/views/tag/Tag'),
    meta: { title: '主题列表' }
  },


  // 组队
  {
    name: 'team',
    path: '/Team',
    component: () => import('@/views/team/Index'),
    meta: { title: '寻找组队' }
  },
  {
    name: 'Football',
    path: '/Football',
    component: () => import('@/views/team/Football'),
    meta: { title: '足球组队' }
  },
  {
    name: 'Basketball',
    path: '/Basketball',
    component: () => import('@/views/team/Basketball'),
    meta: { title: '篮球组队' }
  },
  {
    name: 'Volleyball',
    path: '/Volleyball',
    component: () => import('@/views/team/Volleyball'),
    meta: { title: '排球组队' }
  },
  {
    name: 'Badminton',
    path: '/Badminton',
    component: () => import('@/views/team/Badminton'),
    meta: { title: '羽毛球组队' }
  },
  {
    name: 'Pingpong',
    path: '/Pingpong',
    component: () => import('@/views/team/PingPong'),
    meta: { title: '乒乓球组队' }
  },
  {
    name: 'Tennis',
    path: '/Tennis',
    component: () => import('@/views/team/Tennis'),
    meta: { title: '网球组队' }
  },
  {
    name: 'Others',
    path: '/Others',
    component: () => import('@/views/team/Other'),
    meta: { title: '其他组队' }
  },

  //智能推荐
  {
    name: 'recommend',
    path: '/Recommend',
    component: () => import('@/views/recommend/Index'),
    meta: { title: '智能推荐' }
  },

  //社团活动
  {
    name: 'club',
    path: '/Club',
    component: () => import('@/views/club/Index'),
    meta: { title: '社团活动' }
  },

  //场馆预约
  {
    name: 'venue',
    path: '/Venue',
    component: () => import('@/views/venue/Index'),
    meta: { title: '场馆预约' }
  },

  // 检索
  {
    name: 'search',
    path: '/search',
    component: () => import('@/views/Search'),
    meta: { title: '检索' }
  },


  // 话题中心
  {
    name: 'user',
    path: '/member/:username/post',
    component: () => import('@/views/user/Post'),
    meta: { title: '话题中心' }
  },
  // 组队中心
  {
    name: 'usert',
    path: '/member/:username/team',
    component: () => import('@/views/user/Team'),
    meta: { title: '组队中心' }
  },
  // 活动中心
  {
    name: 'userc',
    path: '/member/:username/club',
    component: () => import('@/views/user/Club'),
    meta: { title: '活动中心' }
  },
  // // 场馆中心
  // {
  //   name: 'userc',
  //   path: '/member/:username/club',
  //   component: () => import('@/views/user/Club'),
  //   meta: { title: '活动中心' }
  // },
  // 用户设置
  {
    name: 'user-setting',
    path: '/member/:username/setting',
    component: () => import('@/views/user/Setting'),
    meta: { title: '设置', requireAuth: true }
  },
  {
    path: "/404",
    name: "404",
    component: () => import("@/views/error/404"),
    meta: { title: "404-NotFound" },
  },
  {
    path: "*",
    redirect: "/404",
    hidden: true,
  },
];

const originalPush = VueRouter.prototype.push;
VueRouter.prototype.push = function push(location) {
  return originalPush.call(this, location).catch((err) => err);
};

const router = new VueRouter({
  routes,
});

export default router;
