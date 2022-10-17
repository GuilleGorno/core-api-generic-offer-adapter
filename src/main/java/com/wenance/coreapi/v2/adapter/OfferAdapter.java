package com.wenance.coreapi.v2.adapter;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.databind.JsonNode;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.PathNotFoundException;
import com.wenance.coreapi.dto.offer.OfferDTO;
import com.wenance.coreapi.model.ProductApplication;
import com.wenance.coreapi.util.JsonHandler;
import com.wenance.coreapi.v2.repository.TemplateRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class OfferAdapter {
	
	@Autowired
    protected JsonHandler jsonHandler;
	
	@Autowired 
	private TemplateRepository template;

	public abstract  OfferDTO adapt(ProductApplication pa);
	
	protected OfferDTO.OfferDTOBuilder getOfferDTOBuilder (ProductApplication pa) {
		
		Map<String, String> expr = template.findByBrandName(pa.getBrand().name());
		
		Map<String, Object> o = new HashMap<>();
				
		expr.keySet().stream().forEach(k -> o.put(k, getProductApplicationValue (pa, expr, k)));
		
		return OfferDTO.builder().data(o);
		
	}
	
	protected String getFieldValue (JsonNode section, String attribute) {
		
		return jsonHandler.strNullableValueOf (section, attribute);
	}
	
	private Object getProductApplicationValue (ProductApplication pa, Map<String, String> expr, String key) {
		
		CharSequence rootElement = "$";
		
		Object regex = expr.get(key);
		
		return regex instanceof Boolean ? regex
				: String.valueOf(regex).contains(rootElement) ? executeRegex(pa, String.valueOf(regex))
						: String.valueOf(regex);
	}
	
	private Object executeRegex (ProductApplication pa, String regex) {
		
		Object value = null;
		
		try {
			value = JsonPath.parse(jsonHandler.toJson(pa)).read(regex, Object.class);
		} catch (PathNotFoundException ex) {
			log.info("{} -> ", ex.getMessage());
		}
		
		return value;
	}
	
}

