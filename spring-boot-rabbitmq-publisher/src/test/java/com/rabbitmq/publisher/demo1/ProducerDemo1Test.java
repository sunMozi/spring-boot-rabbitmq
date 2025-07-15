package com.rabbitmq.publisher.demo1;


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
    // 声明交换机名称（必须与 RabbitMQ 中已有交换机匹配）
    String exchangeName = "";
    // 指定路由键（用于匹配绑定队列）
    String routingKey = "queue_test";
    // 构造消息体（此处为简单字符串 "hello world" 的字节数组）
    byte[] bytes = "hello world".getBytes();
    // 发送消息至指定交换机，匹配路由键，将消息分发给匹配的队列
    rabbitTemplate.convertAndSend(exchangeName, routingKey, bytes);
  }


}