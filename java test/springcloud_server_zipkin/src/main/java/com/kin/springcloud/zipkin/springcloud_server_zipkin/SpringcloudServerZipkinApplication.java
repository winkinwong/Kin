package com.kin.springcloud.zipkin.springcloud_server_zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin.server.EnableZipkinServer;


@SpringBootApplication
@EnableZipkinServer
public class SpringcloudServerZipkinApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudServerZipkinApplication.class, args);
	}

}
