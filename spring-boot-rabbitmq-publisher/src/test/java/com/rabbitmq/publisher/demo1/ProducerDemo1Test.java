package com.rabbitmq.publisher.demo1;


import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author moZiA
 * @date 2025/7/15 14:56
 * @description
 */
@SpringBootTest
public class ProducerDemo1Test {


  @Autowired
  private RabbitTemplate rabbitTemplate;

  @Test
  public void testSendMessage() {
    final String exchangeName = ""; // 默认交换机，routingKey 必须是队列名称
    final String routingKey = "queue_test";
    final String message = "我是一个消息";

   for (int i = 0; i < 10; i++){
     rabbitTemplate.convertAndSend(exchangeName,
                                   routingKey,
                                   message.getBytes(StandardCharsets.UTF_8));
   }


  }
}