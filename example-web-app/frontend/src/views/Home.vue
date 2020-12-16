


<template>
  <div class="home">
    <h5> This ist the official Project-StudentregistrationApp for students an student staff.</h5>
    <h5>Use this app, to build groups you work with in different types of projects.</h5>
    <br>
    <h7>!!! Please read the README.md data before using this App !!!</h7>
  </div>
</template>

<script>
// import component to use it as HTML element
import HelloWorld from "@/components/HelloWorld.vue";

export default {
  name: "Home",
  components: {
    HelloWorld
  },
  data() {
    return {
      // this variable is assigned to the input text element
      name: ""
    };
  },
  methods: {
    // this function is assigned to the button
    submit: function() {
      alert(`Hello ${this.name}! Nice to meet you!`);
      this.name = "";
    }
  }
};
</script>

<style>
.home{
  text-align: center;
  float: none;
}
.home label {
  margin-right: 10px;
}
</style>
