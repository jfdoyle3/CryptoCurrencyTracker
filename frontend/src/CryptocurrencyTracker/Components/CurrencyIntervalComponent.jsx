import React, { Component } from "react";
import AuthenticationService from "../Auth/AuthenticationService.js";
import CurrencyIntervalDataService from '../API/CurrencyIntervalDataService';
import "../Styling/css/CurrencyDetail.css";

class CurrencyIntervalComponent extends Component {
  constructor(props) {
    super(props);
    this.state = {
      symbol: props.symbol,
      currencyIntervals: []
    };
  }
  componentDidMount() {
   // console.log("interval-mounted");
    let username = AuthenticationService.getLoggedInUserName(); 
    CurrencyIntervalDataService.retrieveIntervals(username, this.state.symbol).then(
      (response) =>
      this.setState({ currencyIntervals: response.data }
    //  console.log(response)
      //  this.setState({
      //   volume: response.data,
      //   price_change: ,
      //   price_change_pct: "",
      //   volume_change: "",
      //   volume_change_pct: "",
      //   market_cap_change: "",
      //   market_cap_change_pct: "",
            
      //   })
    ));
  }
  render() {
    return (
      <div>
        <table id="intervalTable" className="table">
          <thead>
            <tr id="detailsHeaderRow">
              <th>Interval</th>
              <th>Price Change</th>
              <th>Price Change %</th>
              <th>Volume</th>
              <th>Volume Change</th>
              <th>Volume Change %</th>
              <th>Market Cap Change</th>
              <th>Market Cap Change %</th>
            </tr>
          </thead>
          <tbody>
          {this.state.currencyIntervals.map((currencyIntervals) => (
                <tr key={currencyIntervals.id}>
                <td>{currencyIntervals.timeInterval}</td>
                <td>{currencyIntervals.priceChange}</td>
                <td>{currencyIntervals.priceChangePct}</td>
                <td>{currencyIntervals.volume}</td>
                <td>{currencyIntervals.volumeChange}</td>
                <td>{currencyIntervals.volumeChangePct}</td>
                <td>{currencyIntervals.marketCapChange}</td>
                <td>{currencyIntervals.marketCapChangePct}</td>
               </tr>
             ))}
          </tbody>
        </table>
      </div>
    );
  }
}
export default CurrencyIntervalComponent;
