import React, { Component } from "react";
import LoginComponent from "./Components/LoginComponent.jsx";
import SideNavComponent from "./Components/SideNavComponent.jsx";
import "./App.css";
import "./materialize.css";

class App extends Component {
  render() {
    return (
      <div className="App">
        <LoginComponent />
        <SideNavComponent />
      </div>
    );
  }
}

export default App;
