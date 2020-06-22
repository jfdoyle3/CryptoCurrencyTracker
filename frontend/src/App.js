import React, { Component } from "react";
import LoginComponent from "./LoginComponent.jsx";
import "./App.css";
import "./materialize.css";

class App extends Component {
  render() {
    return (
      <div className="App">
        <LoginComponent />
      </div>
    );
  }
}

export default App;
