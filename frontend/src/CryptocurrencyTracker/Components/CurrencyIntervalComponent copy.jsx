import React, { Component } from "react";
import AuthenticationService from "../Auth/AuthenticationService.js";
import CurrencyIntervalDataService from '../API/CurrencyIntervalDataService';
import "../Styling/css/CurrencyDetail.css";

class CurrencyIntervalComponent extends Component {
  constructor(props) {
    super(props);
    this.state = {
      symbol: props.symbol,
      interval:"",
      volume: "",
      price_change: "",
      price_change_pct: "",
      volume_change: "",
      volume_change_pct: "",
      market_cap_change: "",
      market_cap_change_pct: "",
    };
  }
  componentDidMount() {
    console.log("interval-mounted");
    let username = AuthenticationService.getLoggedInUserName(); 
    CurrencyIntervalDataService.retrieveIntervals(username, this.state.symbol).then(
      (response) =>
      console.log(response)
      //  this.setState({
      //   volume: response.data,
      //   price_change: ,
      //   price_change_pct: "",
      //   volume_change: "",
      //   volume_change_pct: "",
      //   market_cap_change: "",
      //   market_cap_change_pct: "",
            
      //   })
    );
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
