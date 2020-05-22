package com.qf.rabbitmqspringboot;


import com.qf.rabbitmqspringboot.publish.Recv;
import com.qf.rabbitmqspringboot.publish.Sender;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class RabbitmqSpringbootApplicationTests {


	@Autowired
	private RedisTemplate redisTemplate;

	@Autowired
	private com.qf.rabbitmqspringboot.publish.Sender sender;

	@Autowired
	private Recv recv;

	@Test
	void contextLoads() {

		redisTemplate.opsForValue().set("v1","k1");
		System.out.println(redisTemplate.opsForValue().get("v1"));
	}



}
