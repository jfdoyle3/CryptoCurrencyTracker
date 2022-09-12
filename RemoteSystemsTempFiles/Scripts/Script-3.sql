SELECT *
FROM currency_daily_price
WHERE id IN (SELECT id FROM currency_daily_price  WHERE price_timestamp  = (SELECT MAX(price_timestamp) FROM currency_daily_price))
ORDER BY id DESC
LIMIT 1