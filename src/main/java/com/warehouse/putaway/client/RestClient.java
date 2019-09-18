package com.warehouse.putaway.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("empconfig-client")
public interface RestClient {
	@RequestMapping("/name")
	String getEmpName();
}	
