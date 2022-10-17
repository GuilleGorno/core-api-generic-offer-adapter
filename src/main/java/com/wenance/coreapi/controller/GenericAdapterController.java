package com.wenance.coreapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.wenance.coreapi.dto.offer.OfferDTO;
import com.wenance.coreapi.v2.service.AdapterService;

@RestController
public class GenericAdapterController {

	@Autowired
	private AdapterService adapterESService;
	
	@GetMapping("/es-offer")
	public OfferDTO getESOfferDTO () throws JsonProcessingException {
		return adapterESService.getOfferESInput();
	}
	
	@GetMapping("/pe-offer")
	public OfferDTO getPEOfferDTO () throws JsonProcessingException {
		return null;
	}
	
}
