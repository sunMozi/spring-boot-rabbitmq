package com.rabbitmq.publisher.demo3;


import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author moZiA
 * @date 2025/7/15 17:09
 * @description 发布订阅模式
 */
@SpringBootTest
public class ProducerDemo3Test {

  @Autowired
  private RabbitTemplate rabbitTemplate;


  @Test
  public void testSendMessage() {
    String message = "Hello World";
    rabbitTemplate.convertAndSend("fanout_X1", "", message.getBytes(StandardCharsets.UTF_8));
  }

}