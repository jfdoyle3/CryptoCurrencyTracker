import axios from "axios";
import { API_URL } from "../../Constants.js";

class cryptocurrenciesDataService {
  retrieveTopTen(name) {
    //console.log('executed service')
    return axios.get(`${API_URL}/users/{username}/cryptocurrencies/topfive`);
  }

  retrieveCryptocurrencyById(name, id) {
    console.log(`trying to get id: ${id}`);
    return axios.get(`${API_URL}/users/${name}/cryptocurrencies/id/${id}`);
  }

  // deletecryptocurrencies(name, id) {
  //   //console.log('executed service')
  //   return axios.delete(`${API_URL}/users/${name}/cryptocurrencies/${id}`);
  // }

  // updatecryptocurrencies(name, id, cryptocurrencies) {
  //   //console.log('executed service')
  //   return axios.put(`${API_URL}/users/${name}/cryptocurrencies/${id}`, cryptocurrencies);
  // }

  retrieveCryptocurrencyBySymbol(name, symbol) {
   // console.log('executed symbol service')
    return axios.get(`${API_URL}/users/${name}/cryptocurrency/${symbol}`);
  }
}

export default new cryptocurrenciesDataService();
