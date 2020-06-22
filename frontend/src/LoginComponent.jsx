import React, { Component } from "react";

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
        <div className="row">
          <div className="input-field col s10">
            <i className="material-icons prefix">email</i>
            <input
              path="email"
              id="lbl_email"
              type="email"
              cssclassName="error"
            />
            <label for="lbl_email">Email</label>
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
