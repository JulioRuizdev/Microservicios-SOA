package com.julio.springcloud.msvc.empleado;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MsvcEmpleadoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsvcEmpleadoApplication.class, args);
	}

}
