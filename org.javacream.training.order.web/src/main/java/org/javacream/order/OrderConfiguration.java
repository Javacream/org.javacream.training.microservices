package org.javacream.order;

import java.time.Duration;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.timelimiter.TimeLimiterConfig;

@SpringBootApplication
@ComponentScan("org.javacream")
public class OrderConfiguration {

	@Bean
	@Qualifier("store")
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	@Bean
	@Qualifier("booksService")
	public RestTemplate restTemplateForBooksService(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	@Bean @Qualifier("booksService")
	public Customizer<Resilience4JCircuitBreakerFactory> booksServiceCustomizer() {
		Consumer<Resilience4JConfigBuilder> configBuilder = builder -> {
			builder
				.timeLimiterConfig(TimeLimiterConfig.custom()
	                            .timeoutDuration(Duration.ofSeconds(2)).build())
				.circuitBreakerConfig(
	                            CircuitBreakerConfig.ofDefaults());
		};
		return factory -> factory.configure(configBuilder , "booksServiceCircuitBreaker");
	}
	@Bean @Qualifier("store")
	public Customizer<Resilience4JCircuitBreakerFactory> storeCustomizer() {
		Consumer<Resilience4JConfigBuilder> configBuilder = builder -> {
			builder
				.timeLimiterConfig(TimeLimiterConfig.custom()
	                            .timeoutDuration(Duration.ofSeconds(2)).build())
				.circuitBreakerConfig(
	                            CircuitBreakerConfig.ofDefaults());
		};
		return factory -> factory.configure(configBuilder , "storeCircuitBreaker");
	}

}
