<template>
  <div id="app">
    <!-- this navigation will appear on every route -->

    <b-navbar toggleable="lg" type="dark" variant="primary">
      <b-navbar-brand to="/">
        <img alt="Vue logo" src="./assets/logo.png" class="logo" />
        Home
      </b-navbar-brand>

      <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

      <b-collapse id="nav-collapse" is-nav>
        <b-navbar-nav>
          <b-nav-item to="/projects">Projects</b-nav-item>
          <b-nav-item to="/registrations">All Registrations</b-nav-item>
          <b-nav-item to="/registrations2">New Registration</b-nav-item>
        </b-navbar-nav>
      </b-collapse>
    </b-navbar>

    <!-- the different view templates will appear in this HTML element based on the route -->
    <div class="main">
      <router-view></router-view>
    </div>
  </div>
</template>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  color: #2c3e50;
}

.logo {
  height: 35px;
  margin: 0 3px;
}

.main {
  padding: 10px 20px;
}
</style>
