package com.api.CanteenConnect.Dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Fooditemdto {
	private Long id;
	@NotBlank(message = "Name is required")
    @Size(max = 20, message = "Name can have at most 20 characters")
    private String name;

    @NotBlank(message = "Price is required")
    @Size(max = 20, message = "Price can have at most 20 characters")
    private String price;

    @Size(max = 50, message = "Image URL can have at most 50 characters")
    private String imageURL;

    @NotNull(message = "Category is required")
    private Long categoryId;

}
