package com.nsoft.association.currencyexchangeconversion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nsoft.association.exception.ResourceNotFound;

@RestController
@EnableDiscoveryClient
public class CurrencyExhangeServiceController {
	
	
	@Autowired
	ManageCurrencyService mcservice;
	
	//Get Currency Factor 
	
	 private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	//http://localhost:8765/currency-exchange-service/currency-exchange/from/USD/to/INR
	 //http://localhost:8000/currency-exchange/from/USD/to/INR -Normal flow 
	
	 
	 //http://localhost:8000/CC/USD
	 @GetMapping("/CC/{countryCode}")
	    public Double getConversion(@PathVariable String countryCode) {
			Currency c = mcservice.getConversion(countryCode);
			return c.getConversionValue();
		
	    }
		
		
	 /**
	  * put this in postman 
	  * {
    "id":"1008",
  "countryCode":"SRK",
   "conversionValue":4.5
}
Link :- http://localhost:8000/addCC
	  * */
		@PostMapping(value = "/addCC", consumes = "application/json")
		public ResponseEntity<?> addConversion(@RequestBody Currency currency) {
		    return ResponseEntity.ok().body(mcservice.addConversion(currency));
		}
		
		
		/**
		  * put this in postman 
		  * {
	    "id":"1008",
	  "countryCode":"SRK",
	   "conversionValue":4.5
	}
	Link :- http://localhost:8000/updateCC
		  * */
		@PostMapping(value = "/updateCC", consumes = "application/json")
		public int updateConversion(@RequestBody Currency currency) {
		    return mcservice.updateConversion(currency);
		    
		}
		
		
		/**{
			   
			  "countryCode":"USD",
			   "amount":"1000"
			}
			http://localhost:8000/calConversion
			*/
		@RequestMapping(value = "/calConversion", method = RequestMethod.POST)
		public CCResponse calculateConversion(@RequestBody CCRequest request) {
			System.out.println(request.toString());
			Currency c = mcservice.getConversion(request.getCountryCode());
			CCResponse response = new CCResponse(request.getCountryCode(), request.getAmount(),
					(c.getConversionValue() *request.getAmount() ));
			return response;
		}
		
		
		

}
