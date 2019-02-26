package com.sinaif.hoover;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class})
@ImportResource({"classpath:config/spring-data-mysql.xml","classpath:config/spring-data-redis-single.xml","classpath:config/spring-app-mvc.xml"}) // 导入xml配置项
public class AppWebApplication {
	
	public static void main(String[] args) {
		
		SpringApplication.run(AppWebApplication.class, args);
	}

}
