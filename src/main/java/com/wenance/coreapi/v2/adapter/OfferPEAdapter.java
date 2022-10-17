package com.wenance.coreapi.v2.adapter;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.wenance.coreapi.dto.offer.OfferDTO;
import com.wenance.coreapi.model.ProductApplication;

@Component
@Qualifier("offerPEAdapter")
public class OfferPEAdapter extends OfferAdapter {

	@Override
	public OfferDTO adapt(ProductApplication pa) {
		
		OfferDTO.OfferDTOBuilder offerDTOBuilder = getOfferDTOBuilder(pa);
		
		return offerDTOBuilder.build();
	}

}
