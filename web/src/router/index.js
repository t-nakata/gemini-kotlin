import Vue from 'vue';
import VueRouter from 'vue-router';
import firebase from 'firebase';

Vue.use(VueRouter);

const routes = [
  {
    path: '/',
    name: 'currency',
    component: () => import(/* webpackChunkName: "currency" */ '../views/Currency.vue'),
    meta: { requiresAuth: true}
  }, {
    path: '/signup',
    name: 'signup',
    component: () => import(/* webpackChunkName: "signup" */ '../views/Signup.vue')
  }, {
    path: '/signin',
    name: 'signin',
    component: () => import(/* webpackCheckName: "signin" */ '../views/Signin.vue')
  }
];

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
});

router.beforeEach((to, from, next) => {
  const requiresAuth = to.matched.some(record => record.meta.requiresAuth)
  if (requiresAuth) {
    firebase.auth().onAuthStateChanged(function (user) {
      if (user) {
        next()
      } else {
        next({
          path: '/signin',
          query: { redirect: to.fullPath }
        })
      }
    })
  } else {
    next()
  }
});

export default router
