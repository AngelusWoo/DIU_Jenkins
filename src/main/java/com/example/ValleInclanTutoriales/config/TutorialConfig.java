package com.example.ValleInclanTutoriales.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TutorialConfig {
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

}
