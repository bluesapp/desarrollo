/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.medplus.Medico.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 *
 * @author jorgelp
 */
@Configuration
@PropertySource(ResourceNames.PROPERTIES)
public class DataSourceConfig {
     
        
        @Value("${datasource.medico.environment}")
	private String ambiente;
        @Value("${datasource.medico.username}")
	private String username;
	@Value("${datasource.medico.password}")
	private String password;
	@Value("${datasource.medico.url}")
	private String url;
	@Value("${datasource.medico.driver}")
	private String driver;
        
        @Value("${datasource.athenea.driver}")
	private String driverAthenea;
	@Value("${datasource.athenea.url}")
	private String urlAthenea;
	@Value("${datasource.athenea.user}")
	private String userAthenea;
	@Value("${datasource.athenea.pass}")
	private String passAthenea;
        
        
        @Primary
        @Bean(name="dsCrmMedico")
	public DataSource dataSourceCrmMedico() {

            System.out.println("Environment -> "+ambiente);
	    
            DriverManagerDataSource ds = new DriverManagerDataSource();
	    ds.setDriverClassName(driver);
	    ds.setUrl(url);
            ds.setUsername(username);
	    ds.setPassword(password);
	    return ds;
	}
        
        @Bean(name="dsAthenea")
	public DataSource dataSourceAthenea() {

		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName(driverAthenea);
		ds.setUrl(urlAthenea);
		ds.setUsername(userAthenea);
		ds.setPassword(passAthenea);
		return ds;

	}

}
