<template>
  <div>
    <h1>Projects</h1>
    <div>
      <b-alert v-bind:show="projects.length === 0" variant="warning">
        No project available on the server...
      </b-alert>

      <div class="projectBox" v-for="project in projects" v-bind:key="project.id">
        <h3>{{ project.projektname }}</h3>
        <p>Id: {{ project.id}} </p>
        <b-img
            v-bind:alt="project.name"
            class="projectLogo"
            rounded="circle"
        />
        <div>
          <b-button
              size="sm"
              variant="outline-danger"
              v-on:click="deleteProject(project.id)"
          >
            <b-icon-trash></b-icon-trash> Delete
          </b-button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
// import configuration with API url; @ refers to the src directory
import config from "@/config";
// import library for HTTP requests
import axios from "axios";

export default {
  name: "Home",
  data() {
    return {
      projects: [],
      deleteMessage: ""
    };
  },
  methods: {
    // send GET request to API to fetch all projects
    fetchAllProjects: function () {
      axios.get(`${config.apiBaseUrl}/projects`).then((response) => {
        // log response data to the browser console
        console.log(response.data);
        // assign response to data variable
        this.projects = response.data;
      });
    },
    deleteProject: function (id) {
      // send DELETE request to API to delete a specific project by ID
      axios.delete(`${config.apiBaseUrl}/projects/${id}`).then(() => {
        // update view by removing deleted cat
        this.projects = this.projects.filter((project) => project.id !== id);
        // show success message using BootstrapVue toast component
        this.showToastMessage(
            `Successfully deleted project with ID ${id}!`,
            "success"
        );
      });
    },
    showToastMessage(msg, variant) {
      this.$bvToast.toast(msg, {
        title: "Alert!",
        variant: variant,
        solid: true,
        toaster: "b-toaster-top-center",
        autoHideDelay: 4000,
        appendToast: true
      });
    }
  },
  // executed after the component has been started
  created: function () {
    this.fetchAllProjects();
  }
};
</script>

<style>
.projectBox {
  padding: 10px;
  margin: 3px;
  border: 1px solid #42b983;
  float: left;
  min-width: 150px;
  text-align: center;
}

.projectLogo {
  height: 100px;
}

.projectBox button {
  margin: 5px;
}

</style>