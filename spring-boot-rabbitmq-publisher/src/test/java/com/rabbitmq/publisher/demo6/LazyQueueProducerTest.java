package com.rabbitmq.publisher.demo6;

/**
 * @author moZiA
 * @date 2025/7/15 20:08
 * @description 发送消息到惰性队列
 */

import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class LazyQueueProducerTest {

  @Autowired
  private RabbitTemplate rabbitTemplate;

  @Test
  public void testSendLazyMessage() {
    String message = "惰性队列的消息：" + System.currentTimeMillis();
    rabbitTemplate.convertAndSend("topic_X1",
                                  "lazy.queue",
                                  message.getBytes(StandardCharsets.UTF_8));
  }
}