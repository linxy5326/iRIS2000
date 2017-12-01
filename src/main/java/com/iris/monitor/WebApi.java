package com.iris.monitor;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 创建人 叶辉 2017-11-07
 */

@SpringBootApplication
// @EnableOAuth2Sso
// mapper 接口类扫描包配置
@MapperScan(basePackages = { "com.iris.monitor.mapper" })
public class WebApi {
	public static void main(String[] args) {
		SpringApplication.run(WebApi.class, args);
	}
}
