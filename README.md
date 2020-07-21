# CryptocurrencyTracker
Cryptocurrency Tacker Full Stack project





Test API reply in powershell

TOKEN=$(curl -s -X POST -H 'Origin: http://localhost:4200' -H 'Accept: application/json' -H 'Content-Type: application/json' --data '{"username":"user","password":"p","rememberMe":false}' http//localhost:8080/authenticate | jq -r '.id_token')

curl -H 'Origin: http://localhost:4200' -H "Authorization: Bearer  ${token}" http://localhost:8080/users/user/cryptocurrencies/topfive



curl -H 'Origin: http://localhost:4200' -H "Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ1c2VyIiwiZXhwIjoxNTk1NzYwNzk5LCJpYXQiOjE1OTUxNTU5OTl9.UglCfYFqMqFvNeTYjDzqLnJvfFsflBtyr0KD0o6ErCg9fRjUKI3jfYLByLRpA5FTC_xD2QoPN2QpOus1g2MsNQ" http://localhost:8080/users/user/cryptocurrenciesInterval/id/BTC/7d

