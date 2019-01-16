package com.forex.forex_microservice;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/forex")
public class ForexController {
    @Autowired
    private Environment environment;
    @Autowired
    private ExchangeValueRepository repository;

    @GetMapping("/hello")
    public String hello() {
        return "Hello from Forex Application";
    }

    /**
     * http://localhost:8000/forex/currency-exchange/from/EUR/to/INR
     * @param from
     * @param to
     * @return
     */
    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
        ExchangeValue exchangeValue = repository.findByFromAndTo(from, to);
        exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
        return exchangeValue;
    }
}
