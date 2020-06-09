package com.wcc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wcc.dao") // 这种方式更灵活
public class MybatisPlusSpringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybatisPlusSpringbootApplication.class, args);
	}

}
