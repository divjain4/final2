package com.nsoft.association.currencyexchangeconversion;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class ManageCurrencyService {
	
	
	@Autowired
    private JdbcTemplate jtm;
	
	public Currency getConversion(String countryCode) {
		String sql = "SELECT * FROM Currency WHERE countryCode = ?";

        return jtm.queryForObject(sql, new Object[]{countryCode},
                new BeanPropertyRowMapper<>(Currency.class));
	}
	
	public int updateConversion(Currency currency) {
		return jtm.update("update currency " + " set conversionValue = ?" + " where countryCode = ?",
		        new Object[] {
		        		currency.getConversionValue(), currency.getCountryCode()
		        });
	}
	
	public int addConversion(Currency currency) {
		 return jtm.update("INSERT into Currency (id, countryCode, conversionValue) " + "values(?, ?,  ?)",
			        new Object[] {
			        		currency.getId(),currency.getCountryCode(), currency.getConversionValue()
			        });
	}

	
}
