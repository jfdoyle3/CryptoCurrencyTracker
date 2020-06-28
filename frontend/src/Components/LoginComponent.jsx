import React, { Component } from "react";
import "../css/login.css";

class LoginComponent extends Component {
  constructor(props) {
    super(props);
    this.state = {
      username: "",
      password: "",
    };
    this.handleChange = this.handleChange.bind(this);
    this.loginClicked = this.loginClicked.bind(this);
  }
  handleChange(event) {
    this.setState({
      [event.target.name]: event.target.value,
    });
  }
  loginClicked() {}

  render() {
    return (
      <div className="container">
        <div className="header">
          <h2>
            <b>Cryptocurrency Tracker</b>
          </h2>
        </div>
        <div className="row">
          <div className="input-field col s10">
            <i className="material-icons prefix">personl</i>
            <input
              path="username"
              id="lbl_username"
              type="email"
              cssclassName="error"
            />
            <label for="lbl_username">Username</label>
          </div>
        </div>
        <div className="row">
          <div className="input-field col s10">
            <i className="material-icons prefix">https</i>
            <input
              path="password"
              id="lbl_password"
              type="password"
              cssclassName="error"
            />
            <label for="lbl_password">Password</label>
          </div>
        </div>
        <div className="row">
          <div className="col s7">
            <button
              className="btn waves-effect waves-light"
              type="submit"
              name="action"
            >
              Login
            </button>
          </div>
        </div>
      </div>
    );
  }
}

export default LoginComponent;
