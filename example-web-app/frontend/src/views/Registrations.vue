//TEMPLATE FOR ALL REGISTRATIONS

<template>
  <div>
    <h1>All Registrations</h1>
    <div>
      <b-alert v-bind:show="registrations.length === 0" variant="warning">
        No Registration available on the server...
      </b-alert>

      <div class="registrationsBox" v-for="registration in registrations" v-bind:key="registration.id">
        <h3>{{ registration.id }}</h3>
        <p>Id: {{ registration.id}} </p>
        <p>Created: {{registration.created}}</p>
        <p>Students: {{registration.studenten}}</p>
        <p>Pref. projects: {{registration.bevorzugteProjekte}}</p>

        <b-img
            v-bind:alt="registration.name"
            class="registrationsLogo"
            rounded="circle"
        />


        <div>
          <b-button
              size="sm"
              variant="outline-danger"
              v-on:click="deleteRegistration(registration.id)"
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
      registrations: [],
      deleteMessage: ""
    };
  },
  methods: {
    // send GET request to API to fetch all registrations
    fetchAllRegistration: function () {
      axios.get(`${config.apiBaseUrl}/registrations`).then((response) => {
        // log response data to the browser console
        console.log(response.data);
        // assign response to data variable
        this.registrations = response.data;
      });
    },
    deleteRegistration: function (id) {
      // send DELETE request to API to delete a specific registrations by ID
      axios.delete(`${config.apiBaseUrl}/registrations/${id}`).then(() => {
        // update view by removing deleted registration
        this.registrations = this.registrations.filter((registration) => registration.id !== id);
        // show success message using BootstrapVue toast component
        this.showToastMessage(
            `Successfully deleted registration with ID ${id}!`,
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
    this.fetchAllRegistration();
  }
};
</script>

<style>
.registrationsBox {
  padding: 10px;
  margin: 3px;
  border: 1px solid #42b983;
  float: left;
  min-width: 300px;
  text-align: center;
}

.registrationsLogo {
  height: 100px;
}

.registrationsBox button {
  margin: 5px;
}

</style>