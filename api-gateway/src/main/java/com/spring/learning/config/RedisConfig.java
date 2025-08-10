package com.spring.learning.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializationContext;

@Configuration
public class RedisConfig {

	@Bean
	public ReactiveRedisTemplate<String, String> reactiveRedisTemplate(LettuceConnectionFactory factory){
		return new ReactiveRedisTemplate<>(factory, RedisSerializationContext.string());
	}
}
