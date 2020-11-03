package com.nsoft.association.currencyexchangeconversion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CurrencyExchangeConverterApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyExchangeConverterApplication.class, args);
	}

}
