package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

/**
 * 
 * @author 1500182
 *
 */

@Configuration
public class WebConfig {
	/*
	 * Java configuration to add message source
	 */
	@Bean
	public ReloadableResourceBundleMessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource= new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("classpath:messages/base_en");
		messageSource.setDefaultEncoding("UTF-8");
		
		return messageSource;
	}
}
