package com.example.demo.configuration;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.security.JwtFilter;

@Configuration
public class FilterConfig {

	@Bean
	public FilterRegistrationBean<JwtFilter> jwtFilter(){
		
		FilterRegistrationBean<JwtFilter> bean = new FilterRegistrationBean<>();
		
		bean.setFilter(new JwtFilter());
		
		bean.addUrlPatterns("/users/*");
		bean.addUrlPatterns("/goals/*");
		bean.addUrlPatterns("/contribute/*");
		bean.addUrlPatterns("/dashboard/*");
		bean.addUrlPatterns("/analytics/*");
		
		System.out.println("hehe");
		return bean;
	}
}
