package com.wg.waimao;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wg.waimao.dao")
public class WaimaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(WaimaoApplication.class, args);
	}

}
