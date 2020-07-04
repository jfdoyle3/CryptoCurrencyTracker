import React, { Component } from "react";
import "../css/currency.css";

class CurrencyHeaderComponent extends Component {
  constructor(props) {
    super(props);
    this.state = {
      id: "BTC",
      currency: "BTC",
      symbol: "BTC",
      name: "Bitcoin",
      logo_url:
        "https://s3.us-east-2.amazonaws.com/nomics-api/static/images/currencies/btc.svg",
      rank: "1",
      price: "9564.85130437",
      circulating_supply: "18391300",
      max_supply: "21000000",
    };

    // bind next currency function

    // bind back currency function 
  }



  render() {
    return (
      <div className="container">

        <div className="row">
          <div className="col s6">
            <span>
              <h2>{this.state.name}</h2>
              <h6>Symbol: {this.state.symbol}</h6>
              <h6>Rank: {this.state.rank}</h6>
              <h6>Price: {this.state.price}</h6>
              <h6>Circulating Supply: {this.state.circulating_supply}</h6>
              <h6>Max Supply: {this.state.max_supply}</h6>
            </span>
          </div>
          <div className="col s6">
            <span>
              <img src={this.state.logo_url} alt="logo" />
            </span>
          </div>
        </div>
        <div id="controls" className="row">
          <div className="col  s6">
        <button className="btn  btn-success"><i className="material-icons">arrow_forward</i></button>
        <div className="col  s6">
        <span>
          <button className="btn   btn-success"><i className="material-icons">arrow_back</i></button>
          </span>
        </div>
        </div>
        </div>
        <div id="controls" className="row">
 
        <div className="col  s6">
        <span>
          <button className="btn btn-success" onClick>Show</button>
          </span>
        </div>
        </div>

      </div>
    );
  }
}
export default CurrencyHeaderComponent;
