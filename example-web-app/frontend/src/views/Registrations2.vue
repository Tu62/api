//TEMPLATE FOR NEW REGISTRATIONS

<template>
  <div>
    <div class ="BigCenter">
    <h1>New Registrations</h1>
    <h3>Please fill out!</h3>
    </div>
    <br>
    <div>

      <div class="registrations2Box">
        <h4>1. Member</h4>
        Name:<br>
        <input type="text" v-model="name1" /><br>
        Prename:<br>
        <input type="text" v-model="prename1" /><br>
        Email:<br>
        <input type="text" v-model="email1" /><br>
        Iliasname:<br>
        <input type="text" v-model="iliasname1" /><br>

      </div>
      <div class="registrations2Box">
        <h4>2. Member</h4>
        Name:<br>
        <input type="text" v-model="name2" /><br>
        Prename:<br>
        <input type="text" v-model="prename2" /><br>
        Email:<br>
        <input type="text" v-model="email2" /><br>
        Iliasname:<br>
        <input type="text" v-model="iliasname2" /><br>
      </div>
      <div class="registrations2Box">
        <h4>3. Member</h4>
        Name:<br>
        <input type="text" v-model="name3" /><br>
        Prename:<br>
        <input type="text" v-model="prename3" /><br>
        Email:<br>
        <input type="text" v-model="email3" /><br>
        Iliasname:<br>
        <input type="text" v-model="iliasname3" /><br>
      </div>
    </div>
    <div class="registrations2Box">
      <h4>Prefered group<br>projects</h4>
      First prefered project:<br>
      <input type="text" v-model="pref" /><br>
      Second prefered project:<br>
      <input type="text" v-model="pref2" /><br>
      Third prefered project:<br>
      <input type="text" v-model="pref3" /><br><br>
      <b-button variant="primary" size="sm" v-on:click="submit">Submit</b-button>
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
      students:[],
      name1:null,
      name2:null,
      name3:null,
      pref1:null,

      prename1:null,
      prename2:null,
      prename3:null,
      pref2:null,

      email1:null,
      email2:null,
      email3:null,
      pref3:null,

      iliasname1:null,
      iliasname2:null,
      iliasname3:null,

      deleteMessage: ""
    };
  },
  methods: {
    // send POST request to API to show registration
    show: function () {
      const registration ={"id": null, "bevorzugteProjekte":null, "studenten": this.studenten}
      axios.post(`${config.apiBaseUrl}/registrations2`, registration).then((response) => {
        // log response data to the browser console
        console.log(registration);
        // assign response to data variable
        console.log(response.data)
      });
    },
    // send POST request to API to create student


    // send POST request to API to create project

    // send POST request to API to create registration
    register: function () {
      const registration ={"id": null, "bevorzugteProjekte":null, "studenten": this.studenten}
      axios.post(`${config.apiBaseUrl}/registrations2`, registration).then((response) => {
        // log response data to the browser console
        console.log(registration);
        // assign response to data variable
        console.log(response.data)
      });
    },
    deleteRegistration: function (id) {
      // send DELETE request to API to delete a specific registrations by ID
      axios.delete(`${config.apiBaseUrl}/registrations/${id}`).then(() => {
        // update view by removing deleted registration
        this.registrations = this.registrations.filter((registration) => registration.id !== id);
        // show success message using BootstrapVue toast component
        this.showToastMessage(v
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
    this.fetchAllProjects();
  }
};
</script>

<style>
.registrations2Box {
  padding: 10px;
  margin: 40px;
  border: 1px solid #42b983;
  float: left;
  min-width: 150px;
  text-align: center;
}

.registrations2Logo {
  height: 100px;
}

.registrations2Box button {
  margin: 5px;
}

.regBox{
  text-align: center;
  float: left;
}
.BigCenter{
  float: none;
  text-align: center;
}

</style>