/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.config;

import co.com.medplus.Medico.filter.AuthorizationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author jorgelp
 */
@Configuration
public class FilterConfig {
    
	 @Bean
	 public AuthorizationFilter authorizationFilter() {
		 AuthorizationFilter filter = new AuthorizationFilter();
		 return filter;
	 } 
}
