package com.warehouse.putaway.dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO implements java.io.Serializable {

	/**
	 * Serial Version ID
	 */
	private static final long serialVersionUID = 1L;
	private Integer productId;
	private String productName;
	private String description;
	private String category;
	private String destination;
	// private Set<ProductDetail> productDetails = new HashSet<ProductDetail>(0);
	private String barcode;

	private int qty;
	private String fulfilmentdate;
	private String status;
	private Date expiryDate;
	private String UOM;

	public Integer getProductId() {
		return this.productId;
	}

	public String getProductName() {
		return this.productName;
	}

	
	public String getBarcode() {
		return barcode;
	}

	public String getDescription() {
		return description;
	}

	public int getQty() {
		return qty;
	}

	public String getFulfilmentdate() {
		return fulfilmentdate;
	}

	public String getStatus() {
		return status;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public String getUOM() {
		return UOM;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public void setFulfilmentdate(String fulfilmentdate) {
		this.fulfilmentdate = fulfilmentdate;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public void setUOM(String uOM) {
		UOM = uOM;
	}



	public void setCategory(String category) {
		this.category = category;
	}



	


	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public String getCategory() {
		return category;
	}



	public String getDestination() {
		return destination;
	}



	public void setDestination(String destination) {
		this.destination = destination;
	}



	
	
	
	
}
