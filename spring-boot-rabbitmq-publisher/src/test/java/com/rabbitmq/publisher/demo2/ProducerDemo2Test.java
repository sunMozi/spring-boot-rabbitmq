package com.rabbitmq.publisher.demo2;


import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author moZiA
 * @date 2025/7/15 17:09
 * @description 工作队列模式
 */
@SpringBootTest
public class ProducerDemo2Test {

  @Autowired
  private RabbitTemplate rabbitTemplate;


  @Test
  public void testSendMessage() {
    String message = "我是工作队列消息";

    for (int i = 0; i < 10; i++) {
      rabbitTemplate.convertAndSend("", "queue_test2", message.getBytes(StandardCharsets.UTF_8));
    }

  }

}