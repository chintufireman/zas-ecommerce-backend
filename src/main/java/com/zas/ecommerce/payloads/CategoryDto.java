package com.zas.ecommerce.payloads;


import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CategoryDto {
	private Integer categoryId;
	private String categoryName;
}
