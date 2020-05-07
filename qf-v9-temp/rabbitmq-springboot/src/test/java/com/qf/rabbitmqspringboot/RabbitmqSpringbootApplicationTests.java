package com.qf.rabbitmqspringboot;


import com.qf.rabbitmqspringboot.publish.Recv;
import com.qf.rabbitmqspringboot.publish.Sender;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RabbitmqSpringbootApplicationTests {



	@Autowired
	private com.qf.rabbitmqspringboot.publish.Sender sender;

	@Autowired
	private Recv recv;

	@Test
	void contextLoads() {
		sender.send("整合成功");
	}



}
