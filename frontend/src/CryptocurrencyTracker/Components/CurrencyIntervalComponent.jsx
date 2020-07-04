import React, { Component } from "react";
import "../css/currency.css";

class CurrencyIntervalComponent extends Component {
  constructor(props) {
    super(props);
    this.state = {
      volume: "27727114306.68",
      price_change: "103.17034381",
      price_change_pct: "0.0109",
      volume_change: "-3798607023.65",
      volume_change_pct: "-0.1205",
      market_cap_change: "1904769546.84",
      market_cap_change_pct: "0.0109",
    };
  }
  render() {
    return (
      <div className="container">
        <p>Volume: {this.state.volume}</p>
        <p>Price Change: {this.state.price_change}</p>
        <p>Volume change: {this.state.volume_change}</p>
        <p>Price Change: {this.state.price_change}</p>
        <p>Market Cap Change: {this.state.market_cap_change}</p>
      </div>
    );
  }
}
export default CurrencyIntervalComponent;
