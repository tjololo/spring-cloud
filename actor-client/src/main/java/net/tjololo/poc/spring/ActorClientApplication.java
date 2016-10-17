package net.tjololo.poc.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.hateoas.config.EnableHypermediaSupport;

@SpringBootApplication
@EnableHystrix
@EnableEurekaClient
@EnableFeignClients
@EnableHypermediaSupport(type = EnableHypermediaSupport.HypermediaType.HAL)
public class ActorClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActorClientApplication.class, args);
	}
}
