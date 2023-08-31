package com.api.CanteenConnect.Dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Categorydto {
	private Long id;
	@NotBlank(message = "Category name is required")
    @Size(max = 20, message = "Category name can have at most 20 characters")
    private String categoryName;

    @Size(max = 50, message = "Description can have at most 50 characters")
    private String description;
}
