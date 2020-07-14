import React, { Component } from "react";

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
        <table className="table">
          <thead>
            <tr>
              <th>Time Interval</th>
              <th>Volume</th>
              <th>Price Change</th>
              <th>Price Change %</th>
              <th>Volume Change</th>
              <th>Volume Change %</th>
              <th>Market Cap Change</th>
              <th>Market Cap Change %</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>1 Day</td>
              <td>{this.state.volume}</td>
              <td>{this.state.price_change}</td>
              <td>{this.state.price_change_pct}</td>
              <td>{this.state.volume_change}</td>
              <td>{this.state.volume_change_pct}</td>
              <td>{this.state.market_cap_change}</td>
              <td>{this.state.market_cap_change_pct}</td>
            </tr>
            <tr>
              <td>7 Days</td>
              <td>{this.state.volume}</td>
              <td>{this.state.price_change}</td>
              <td>{this.state.price_change_pct}</td>
              <td>{this.state.volume_change}</td>
              <td>{this.state.volume_change_pct}</td>
              <td>{this.state.market_cap_change}</td>
              <td>{this.state.market_cap_change_pct}</td>
            </tr>
            <tr>
              <td>365 Days</td>
              <td>{this.state.volume}</td>
              <td>{this.state.price_change}</td>
              <td>{this.state.price_change_pct}</td>
              <td>{this.state.volume_change}</td>
              <td>{this.state.volume_change_pct}</td>
              <td>{this.state.market_cap_change}</td>
              <td>{this.state.market_cap_change_pct}</td>
            </tr>
          </tbody>
        </table>
      </div>
    );
  }
}
export default CurrencyIntervalComponent;
