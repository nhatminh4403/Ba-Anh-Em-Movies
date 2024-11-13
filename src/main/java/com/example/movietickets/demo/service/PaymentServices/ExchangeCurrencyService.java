package com.example.movietickets.demo.service.PaymentServices;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Map;

@Service
public class ExchangeCurrencyService {

    private final String EXCHANGE_RATE_API_URL = "https://api.exchangerate-api.com/v4/latest/VND";

    public BigDecimal convertVNDToUSD(Long amountVND) {
        RestTemplate restTemplate = new RestTemplate();
        try {
            // Get exchange rate data from the API
            ExchangeRateResponse response = restTemplate.getForObject(EXCHANGE_RATE_API_URL, ExchangeRateResponse.class);

            if (response != null) {
                BigDecimal rate = response.getRates().get("USD");
                return rate.multiply(new BigDecimal(amountVND));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return BigDecimal.ZERO;
    }

    private static class ExchangeRateResponse {
        private Map<String, BigDecimal> rates;

        public Map<String, BigDecimal> getRates() {
            return rates;
        }

        public void setRates(Map<String, BigDecimal> rates) {
            this.rates = rates;
        }
    }
}
