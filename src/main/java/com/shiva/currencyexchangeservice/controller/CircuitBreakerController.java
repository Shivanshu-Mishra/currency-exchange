package com.shiva.currencyexchangeservice.controller;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CircuitBreakerController {
    private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);

    @GetMapping("sample-api")
    // @Retry(name="sample-api",fallbackMethod = "hardCodedResponse")
    //@CircuitBreaker(name="default",fallbackMethod = "hardCodedResponse")
    @RateLimiter(name = "default")
    @Bulkhead(name="sample-api")
    public String sampleApi() {
        logger.info("Sample api  call received");
       /* ResponseEntity<String> forEntity=new RestTemplate().getForEntity("http://localhost:8080/some-dummy-url",String.class);
        return forEntity.getBody();*/
        return "Sample Api call recieved";
    }

    public String hardCodedResponse(Exception ex) {
        return "fallback-response";
    }

}
