import React, { Component } from "react";
import CryptocurrencyTracker from "./CryptocurrencyTracker/Components/CryptocurrencyTracker.jsx";
//import "./App.css";
import "../node_modules/bootstrap/dist/css/bootstrap.css";
import "../node_modules/materialize-css/dist/css/materialize.css";
//import "materialize-css/dist/css/materialize.min.css";

class App extends Component {
  render() {
    return (
      <div className="App">
        <CryptocurrencyTracker />
      </div>
    );
  }
}

export default App;
