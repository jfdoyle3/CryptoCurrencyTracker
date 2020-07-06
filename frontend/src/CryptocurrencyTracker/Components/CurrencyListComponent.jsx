import React, { Component } from "react";
import CurrencyDataService from "../API/CurrencyDataService.js";
import AuthenticationService from "../Auth/AuthenticationService.js";
import "../Styling/css/ListCurrencies.css";

class CurrencyHeaderComponent extends Component {
  constructor(props) {
    super(props);
    this.state = {
      cryptocurrencies: [],
    };
    // bind test button
    this.viewCurrencyClicked = this.viewCurrencyClicked.bind(this);
    // bind next currency function

    // bind back currency function
  }
  componentDidMount() {
    console.log("componentDidMount");
    this.refreshCurrencies();
    console.log(this.state);
  }

  viewCurrencyClicked(id) {
    this.props.history.push(`/cryptocurrenices/:id`);
  }

  refreshCurrencies() {
    let username = AuthenticationService.getLoggedInUserName();
    CurrencyDataService.retrieveAllCurrencies(username).then((response) => {
      console.log(response);
      this.setState({ cryptocurrencies: response.data });
    });
  }
  render() {
    return (
      <div>
        {this.state.message && (
          <div className="alert alert-success">{this.state.message}</div>
        )}
        <div className="container">
          <table className="table">
            <thead>
              <tr>
                <th></th>
                <th>Rank</th>
                <th>Name</th>
                <th>Symbol</th>
              </tr>
            </thead>
            <tbody>
              {this.state.cryptocurrencies.map((cryptocurrency) => (
                <tr key={cryptocurrency.id}>
                  <td>
                    <img
                      src={cryptocurrency.logoUrl}
                      alt={cryptocurrency.name}
                    />
                  </td>
                  <td>{cryptocurrency.rank}</td>
                  <td>{cryptocurrency.name}</td>
                  <td>{cryptocurrency.symbol}</td>
                  <td>
                    <button
                      className="waves-effect waves-light btn-small"
                      onClick={() =>
                        this.viewCurrencyClicked(cryptocurrency.currency)
                      }
                    >
                      View
                    </button>
                  </td>
                  <td>
                    <button
                      className="waves-effect waves-light btn-small"
                      // onClick={() => this.deleteTodoClicked(todo.id)}
                    >
                      Save
                    </button>
                  </td>
                  <td>
                    <button
                      className="waves-effect waves-light btn-small"
                      // onClick={() => this.deleteTodoClicked(todo.id)}
                    >
                      Delete
                    </button>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
          <div className="row">
            <button className="btn btn-success">Add</button>
          </div>
        </div>
      </div>
    );
  }
}
export default CurrencyHeaderComponent;
