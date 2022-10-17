package com.wenance.coreapi.v2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.wenance.coreapi.dto.offer.OfferDTO;
import com.wenance.coreapi.model.ProductApplication;
import com.wenance.coreapi.util.JsonUtils;
import com.wenance.coreapi.v2.adapter.OfferAdapter;

@Service
public class AdapterService {

	@Autowired
	@Qualifier("offerESAdapter")
	private OfferAdapter offerESAdapter;
	
	@Autowired
	@Qualifier("offerPEAdapter")
	private OfferAdapter offerPEAdapter;
	
	public OfferDTO getOfferESInput () {
		
		ProductApplication pa = JsonUtils.getInstance().deserializeJsonFile("product-application-es.json", ProductApplication.class);
		
		return offerESAdapter.adapt(pa);
	}
	
	
}
