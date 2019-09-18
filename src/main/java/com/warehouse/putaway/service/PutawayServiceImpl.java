package com.warehouse.putaway.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.warehouse.putaway.dto.ProductDTO;
import com.warehouse.putaway.service.PutawayService;

@SuppressWarnings("unchecked")
@Service
public class PutawayServiceImpl implements PutawayService {
	RestTemplate restTemplate = new RestTemplate();
	URI uri = null;

	public List<ProductDTO> getProductList(String url, List<String> barcodes) {
		try {
			uri = new URI(url);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		ResponseEntity<Object> result = restTemplate.postForEntity(uri, barcodes, Object.class);
		return (List<ProductDTO>) result.getBody();
	}

	public List<ProductDTO> insertProducts(String url, List<ProductDTO> pdtoList) {
		try {
			uri = new URI(url);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		ResponseEntity<Object> result = restTemplate.postForEntity(uri, pdtoList, Object.class);
		
		return (List<ProductDTO>) result.getBody();
	}
}
