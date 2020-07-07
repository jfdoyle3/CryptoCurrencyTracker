import React, { Component } from "react";
import "../Styling/css/Currency.css";
//import "../Styling/css/wikisheet.css";
import CurrencyDataService from "../API/CurrencyDataService.js";
import AuthenticationService from "../Auth/AuthenticationService.js";

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
      <div className="container">
        <div className="row">
          <div className="col s6">
            <span>
              <h6>{this.state.name}</h6>
              <h6>Symbol: {this.state.symbol}</h6>
              <h6>Rank: {this.state.ranking}</h6>
            </span>
          </div>
          <div className="col s6">
            <span>
              <img id="imgHeader" src={this.state.logo_url} alt="logo" />
            </span>
          </div>
        </div>
        <div id="controls" className="row">
          <div className="col  s6">
            <button className="btn  btn-success">
              <i className="material-icons">arrow_forward</i>
            </button>
            <div className="col  s6">
              <span>
                <button className="btn btn-success">
                  <i className="material-icons">arrow_back</i>
                </button>
              </span>
            </div>
          </div>
        </div>
      </div>
    );
  }
}
export default CurrencyHeaderComponent;
