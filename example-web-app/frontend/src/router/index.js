import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home.vue";
import Projects from "../views/Projects.vue";
import Registrations from "../views/Registrations.vue";
import Registrations2 from "../views/Registrations2.vue";


Vue.use(VueRouter);

// all frontend routes of the app, i.e. bind a path to a Vue component
const routes = [
  {
    path: "/",
    name: "Home",
    component: Home
  },
  {
    path: "/projects",
    name: "Projects",
    component: Projects
  },

  {
    path: "/registrations",
    name: "Registrations",
    component: Registrations
  },

  {
    path: "/registrations2",
    name: "Registrations2",
    component: Registrations2
  }
];

const router = new VueRouter({
  routes
});

export default router;
