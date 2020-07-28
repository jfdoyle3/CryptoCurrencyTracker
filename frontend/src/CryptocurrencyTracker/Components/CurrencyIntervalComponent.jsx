import React, { Component } from "react";
import "../Styling/css/CurrencyDetail.css";

class CurrencyIntervalComponent extends Component {
  constructor(props) {
    super(props);
    this.state = {
      symbol: props.symbol,
      interval:"1",
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
      <div>
        <table className="table">
          <thead>
            <tr id="detailsHeader">
              <th>Interval</th>
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
              <td>1 day</td>
              <td>{this.state.volume}</td>
              <td>{this.state.price_change}</td>
              <td>{this.state.price_change_pct}</td>
              <td>{this.state.volume_change}</td>
              <td>{this.state.volume_change_pct}</td>
              <td>{this.state.market_cap_change}</td>
              <td>{this.state.market_cap_change_pct}</td>
            </tr>
            <tr>
              <td>30 days</td>
              <td>{this.state.volume}</td>
              <td>{this.state.price_change}</td>
              <td>{this.state.price_change_pct}</td>
              <td>{this.state.volume_change}</td>
              <td>{this.state.volume_change_pct}</td>
              <td>{this.state.market_cap_change}</td>
              <td>{this.state.market_cap_change_pct}</td>
            </tr>
            <tr>
              <td>365 days</td>
              <td>{this.state.volume}</td>
              <td>{this.state.price_change}</td>
              <td>{this.state.price_change_pct}</td>
              <td>{this.state.volume_change}</td>
              <td>{this.state.volume_change_pct}</td>
              <td>{this.state.market_cap_change}</td>
              <td>{this.state.market_cap_change_pct}</td>
            </tr>
            <tr>
              <td >Year to Date</td>
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
