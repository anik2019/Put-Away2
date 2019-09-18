package com.warehouse.putaway.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties
public class BeanConfig {

	private String searchProductListUrl;
	private String insertProducts;

	public String getSearchProductListUrl() {
		return searchProductListUrl;
	}

	public void setSearchProductListUrl(String searchProductListUrl) {
		this.searchProductListUrl = searchProductListUrl;
	}

	public String getInsertProducts() {
		return insertProducts;
	}

	public void setInsertProducts(String insertProducts) {
		this.insertProducts = insertProducts;
	}
	 
}
