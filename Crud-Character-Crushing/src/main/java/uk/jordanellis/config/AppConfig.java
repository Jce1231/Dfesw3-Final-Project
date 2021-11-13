package uk.jordanellis.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	@Bean // tells to make this for me
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
