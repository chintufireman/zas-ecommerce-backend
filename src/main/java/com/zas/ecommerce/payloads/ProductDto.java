package com.zas.ecommerce.payloads;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProductDto {
	private Integer productId;
	private String productName;
	private String price;
	private String description;
	private Integer categoryId;
}
