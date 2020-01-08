package com.customprocess.api;

import com.alibaba.druid.pool.DruidDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

//exclude = SecurityAutoConfiguration.class
@SpringBootApplication()
@EnableTransactionManagement   //开启事务管理
@MapperScan("com.customprocess.api.mapper")
@ComponentScan("com.customprocess.api")
public class CustomprocessApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomprocessApplication.class, args);
	}

	@Bean(destroyMethod = "close", initMethod = "init")
	@ConfigurationProperties(prefix = "spring.datasource")
	public DataSource druidDataSource() {
		DruidDataSource druidDataSource = new DruidDataSource();
		return druidDataSource;
	}
}
