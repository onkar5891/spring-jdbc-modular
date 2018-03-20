package com.ok.spring.jdbc.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@PropertySource("classpath:/res/spring-app.properties")
@ComponentScan(basePackages="com.ok.spring.jdbc")
public class AppConfig {
	@Value("${datasource.url}")
	private String url;
	@Value("${datasource.user}")
	private String user;
	@Value("${datasource.password}")
	private String password;
	@Value("${datasource.driver}")
	private String driver;

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource(url, user, password);
		dataSource.setDriverClassName(driver);
		return dataSource;
	}
}

