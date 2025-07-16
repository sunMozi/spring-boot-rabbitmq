package com.rabbitmq.publisher.demo5;


import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author moZiA
 * @date 2025/7/15 17:09
 * @description 通配符模式
 */
@SpringBootTest
public class ProducerDemo4Test {


  @Autowired
  private RabbitTemplate rabbitTemplate;

  public static final String TOPIC_EXCHANGE_NAME = "topic_exchange_demo";

  @Test
  public void testSendMessage() {
    String message = "Hello World";
    rabbitTemplate.convertAndSend("topic_X1", "c.a.c", message.getBytes(StandardCharsets.UTF_8));
  }

  @Test
  public void sendMessage() {
    String message = "Hello World";
    String routingKey = "user.create";

    rabbitTemplate.convertAndSend(TOPIC_EXCHANGE_NAME, routingKey, message);
    System.out.printf("发送消息: 路由键=[%s], 内容=[%s]%n", routingKey, message);
  }

}