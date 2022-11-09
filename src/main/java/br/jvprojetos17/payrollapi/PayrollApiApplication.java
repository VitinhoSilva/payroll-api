package br.jvprojetos17.payrollapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
public class PayrollApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PayrollApiApplication.class, args);
	}

}
