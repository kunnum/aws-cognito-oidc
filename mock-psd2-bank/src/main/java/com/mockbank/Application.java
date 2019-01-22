package com.mockbank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 */
@SpringBootApplication
public class Application {

    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

/**
 curl http://localhost:8080/psd2/accountBalance \
 -H 'X-Endpoint-API-UserInfo: eyJwcmluY2lwYWwiOiJtZWVyYWpAZ21haWwuY29tIiwiZGV0YWlscyI6Ik1lZXJhaiBLdW5udW1wdXJhdGgiLCJyb2xlcyI6WyJUUkFOU0FDVElPTl9ISVNUT1JZIiwiQUNDT1VOVF9CQUxBTkNFIl19'

 curl http://localhost:8080/psd2/transactionHistory \
 -H 'X-Endpoint-API-UserInfo: eyJwcmluY2lwYWwiOiJtZWVyYWpAZ21haWwuY29tIiwiZGV0YWlscyI6Ik1lZXJhaiBLdW5udW1wdXJhdGgiLCJyb2xlcyI6WyJUUkFOU0FDVElPTl9ISVNUT1JZIiwiQUNDT1VOVF9CQUxBTkNFIl19'

 curl http://localhost:8080/psd2/quote \
 -H 'X-Endpoint-API-UserInfo: eyJwcmluY2lwYWwiOiJtZWVyYWpAZ21haWwuY29tIiwiZGV0YWlscyI6Ik1lZXJhaiBLdW5udW1wdXJhdGgiLCJyb2xlcyI6WyJUUkFOU0FDVElPTl9ISVNUT1JZIiwiQUNDT1VOVF9CQUxBTkNFIl19'

 curl http://localhost:8080/psd2/pay \
 -H 'X-Endpoint-API-UserInfo: eyJwcmluY2lwYWwiOiJtZWVyYWpAZ21haWwuY29tIiwiZGV0YWlscyI6Ik1lZXJhaiBLdW5udW1wdXJhdGgiLCJyb2xlcyI6WyJUUkFOU0FDVElPTl9ISVNUT1JZIiwiQUNDT1VOVF9CQUxBTkNFIl19'
 *
 */
