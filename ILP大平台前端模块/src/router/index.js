import { createRouter, createWebHistory } from 'vue-router';

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'root',
      redirect:'/Login'
    },
    {
      path: '/main',
      name: 'main',
      component: () => import('../components/MainView.vue'),
      children:[
        {
          path: 'GuideFuture',
          name: 'GuideFuture',
          component: () => import('../components/modules/GuideFuture.vue'),
          meta: {
            title: '我的未来我规划 - 基于AI与大数据分析的智能未来规划系统'
          },
          children:[
            {
              path: 'JobAndSalary',
              name: 'JobAndSalary',
              component: () => import('../components/modules/JobAndSalary.vue'),
            },
            {
              path: 'SkillDiff',
              name: 'SkillDiff',
              component: () => import('../components/modules/SkillDiff.vue'),
            },
          ]
        },
        {
          path: 'PersonalPage',
          name: 'PersonalPage',
          meta: {
            title: 'ILP大平台个人主页'
          },
          component: () => import('../components/modules/PersonalPage.vue'),
        },
        {
          path: 'PsyChat',
          name: 'PsyChat',
          meta: {
            title: '倾听你的心里话 - ILP心理疏导之家'
          },
          component: () => import('../components/modules/PsyChat.vue'),
        },
        {
          path: 'Forum',
          name: 'Forum',
          meta: {
            title: 'ILP学生组织纳新与校园大论坛'
          },
          component: () => import('../components/modules/Forum.vue'),
        },
        {
          path: 'Resources',
          name: 'Resources',
          meta: {
            title: 'ILP大平台资源中心'
          },
          component: () => import('../components/modules/Resources.vue'),
        },
        {
          path: 'ForumInner',
          name: 'ForumInner',
          meta: {
            title: 'ILP学生组织纳新与校园大论坛'
          },
          component: () => import('../components/modules/ForumInner.vue'),
        },
        {
          path: 'AimList',
          name: 'AimList',
          meta: {
            title: '我的大平台目标清单'
          },
          component: () => import('../components/modules/AimList.vue'),
        },
        {
          path: 'StartStudy',
          name: 'StartStudy',
          meta: {
            title: '即将开始自习'
          },
          component: () => import('../components/modules/StartStudy.vue'),
        },
        {
          path: 'HomePage',
          name: 'PersonPage',
          meta: {
            title: 'ILP学生组织纳新与校园大论坛'
          },
          component: () => import('../components/modules/HomePage.vue'),
        },

      ]
    },
    {
      path:'/Login',
      name:'Login',
      meta: {
        title: '我的青春不迷茫 ILP大平台 - 用户登录'
      },
      component: () => import('../components/modules/Login.vue'),
    },
    {
      path:'/LoginMobile',
      name:'LoginMobile',
      meta: {
        title: '我的青春不迷茫 ILP大平台 - 用户登录'
      },
      component: () => import('../components/modules/LoginMobile.vue'),
    },

    {
      path:'/SalaryShow',
      name:'SalaryShow',
      meta: {
        title: '我的青春不迷茫 ILP大平台 - 月薪分析'
      },
      component: () => import('../components/modules/SalaryShow.vue'),
    },
    {
      path:'/Register',
      name:'Register',
      meta: {
        title: '我的青春不迷茫 ILP大平台 - 用户注册'
      },
      component: () => import('../components/modules/Register.vue'),
    },
    {
      path:'/StudyRoom',
      name:'StudyRoom',
      meta: {
        title: '正在自习中...'
      },
      component: () => import('../components/modules/StudyRoom.vue'),
    },

    {
      path:'/:catchAll(.*)',
      name:'NotFound',
      meta: {
        title: '404 ~ '
      },
      component: ()=>import('../components/modules/NotFound.vue'),
    }
  ]
})

router.beforeEach((to, from, next) => {
  if (to.meta.title) {
    document.title = to.meta.title
  }
  next()
})

export default router
