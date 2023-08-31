package com.api.CanteenConnect;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CanteenConnectApplication {

	public static void main(String[] args) {
		SpringApplication.run(CanteenConnectApplication.class, args);
	}
	@Bean 
	public ModelMapper myModelMapper() {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		return mapper;

}}
