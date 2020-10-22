package com.its.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 应用程序入口
 *
 * @author 杨金刚
 * @date 2020/8/9 13:45
 */

@SpringBootApplication
@EnableTransactionManagement
@EnableAsync
@ServletComponentScan("com.its.demo.filter")
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
