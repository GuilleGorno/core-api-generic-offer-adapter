package com.wenance.coreapi.v2.adapter;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JsonNode;
import com.wenance.coreapi.dto.offer.OfferDTO;
import com.wenance.coreapi.model.ProductApplication;
import com.wenance.coreapi.model.Section;

@Component
@Qualifier("offerESAdapter")
public class OfferESAdapter extends OfferAdapter {
	
	private static final String EMPTY = "";

	@Override
	public OfferDTO adapt (ProductApplication pa) {
		
		OfferDTO.OfferDTOBuilder offerDTOBuilder = getOfferDTOBuilder(pa);
		
		/* Completo solamente los campos que se calculan */	
		
		JsonNode originationInfo = pa.getSection(Section.ORIGINATION);
		
		String leadSource = sanitizeLeadSource (getFieldValue(originationInfo, "lead_source"));

        String productType = Optional.of(leadSource)
        							.filter(ls -> ls.equalsIgnoreCase("ONBOARDING"))
        							.map(ls -> "CREDITO").orElse("CREDIT_LEADS_V2");

		String tag = Optional.of(pa.getBrand().toString())
							.filter(b -> b.equalsIgnoreCase("WELP_ES"))
							.map(ls -> "WENANCE_ES")
							.orElse("ABUNTIA_ES");
		
		return offerDTOBuilder
				.putData("input_leadsource", leadSource)
				.putData("input_product", productType)
				.putData("input_tag", tag)
				.build();
	}
	
	private String sanitizeLeadSource (String leadSource) {
		return Optional.ofNullable(leadSource).map(ld -> ld.replace("-default", EMPTY)).orElse("ONBOARDING");
	}	
	
}
