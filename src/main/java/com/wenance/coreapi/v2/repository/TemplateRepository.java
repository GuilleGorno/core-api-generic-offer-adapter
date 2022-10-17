package com.wenance.coreapi.v2.repository;

import java.util.Map;

import org.springframework.stereotype.Repository;

import com.wenance.coreapi.util.JsonUtils;

@Repository
public class TemplateRepository {
	
	public Map<String, String> findByBrandName (String BrandName) {
		return JsonUtils.getInstance().deserializeJsonFile(BrandName + "_fa_template" , Map.class);
	}
}
