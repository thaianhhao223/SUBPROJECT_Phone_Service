package com.sub_project.PhoneService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class PhoneServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhoneServiceApplication.class, args);
	}

	@Bean
	//@LoadBalanced
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
	@Bean
	LettuceConnectionFactory jedisConnectionFactory(){
		return new LettuceConnectionFactory();
	}

	@Bean
	RedisTemplate redisTemplate(){
		RedisTemplate redisTemplate = new RedisTemplate();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		redisTemplate.setKeySerializer(new StringRedisSerializer());

		return redisTemplate;

	}

}
