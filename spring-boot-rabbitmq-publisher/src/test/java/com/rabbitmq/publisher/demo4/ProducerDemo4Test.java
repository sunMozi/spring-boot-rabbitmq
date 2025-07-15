package com.rabbitmq.publisher.demo4;


import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author moZiA
 * @date 2025/7/15 17:09
 * @description 路由模式
 */
@SpringBootTest
public class ProducerDemo4Test {

  @Autowired
  private RabbitTemplate rabbitTemplate;


  @Test
  public void testSendMessage() {
    String message = "Hello World";
    rabbitTemplate.convertAndSend("direct_X1", "b", message.getBytes(StandardCharsets.UTF_8));
  }

}