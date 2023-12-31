package com.api.CanteenConnect.Dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ErrorResponse {
	
	
		private String message;
		private LocalDateTime timestamp;

		public ErrorResponse(String message) {
			super();
			this.message = message;
		}
}
