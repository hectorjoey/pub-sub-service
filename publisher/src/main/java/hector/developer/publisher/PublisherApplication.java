package hector.developer.publisher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClientsProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableConfigurationProperties(LoadBalancerClientsProperties.class)
public class PublisherApplication {

    @LoadBalanced
    @Bean
    public RestTemplate getRestTemplate(){
       return new RestTemplate();
    }
	public static void main(String[] args) {
		SpringApplication.run(PublisherApplication.class, args);
	}

}
