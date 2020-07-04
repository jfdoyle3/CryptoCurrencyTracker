import React, { Component } from "react";
import CryptocurrencyTracker from "./CryptocurrencyTracker/Components/CryptocurrencyTracker.jsx";
import "./App.css";
import "./materialize.css";

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
