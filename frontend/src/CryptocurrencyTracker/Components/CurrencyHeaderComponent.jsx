import React, { Component } from "react";
import "../Styling/css/Currency.css";
//import "../Styling/css/wikisheet.css";
import CurrencyDataService from "../API/CurrencyDataService.js";
import AuthenticationService from "../Auth/AuthenticationService.js";
import CurrencyInfoComponent from "./CurrencyInfoComponent.jsx";
import CurrencyIntervalComponent from "./CurrencyIntervalComponent.jsx";

class CurrencyHeaderComponent extends Component {
  constructor(props) {
    super(props);
    this.state = {
      id: this.props.match.params.id,
      symbol: "",
      name: "",
      logo_url: "",
      rank: "",
    };
    // bind test button

    // bind next currency function

    // bind back currency function
  }
  componentDidMount() {
    if (this.state.id === -1) {
      return;
    }

    let username = AuthenticationService.getLoggedInUserName();
    CurrencyDataService.retrieveCryptocurrency(username, this.state.id).then(
      (response) =>
        //console.log(response)
        this.setState({
          name: response.data.name,
          symbol: response.data.symbol,
          logo_url: response.data.logoUrl,
          ranking: response.data.ranking,
        })
    );
  }

  render() {
    return (
      <div>
        <div className="row">
          <div className="col s4">
            <img id="imgHeader" src={this.state.logo_url} alt="logo" />
          </div>
          <div className="col s4">
            <h6>{this.state.name}</h6>
            <p>Symbol: {this.state.symbol}</p>
            <p>Rank: {this.state.ranking}</p>
          </div>
          <div>
            <CurrencyInfoComponent />
          </div>
        </div>
        <CurrencyIntervalComponent />
      </div>
    );
  }
}
export default CurrencyHeaderComponent;
