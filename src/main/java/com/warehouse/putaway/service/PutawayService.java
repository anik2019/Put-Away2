package com.warehouse.putaway.service;

import java.util.List;

import com.warehouse.putaway.dto.ProductDTO;

public interface PutawayService {
	public List<ProductDTO> getProductList(String url,List<String> barcodes);
	public List<ProductDTO> insertProducts(String url,List<ProductDTO> pdtoList);
}