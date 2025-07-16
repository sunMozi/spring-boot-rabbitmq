package com.rabbitmq.consumer.listener;


import java.nio.charset.StandardCharsets;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author moZiA
 * @date 2025/7/15 20:07
 * @description
 */
@Slf4j
@Component
public class LazyQueueListener {

  @RabbitListener(queues = "lazy.queue", concurrency = "20")
  public void handleLazyQueue(Message message) {
    String body = new String(message.getBody(), StandardCharsets.UTF_8);

    System.out.println(
        "当前线程" + Thread.currentThread().getName() + "消费者已接收到消息：" + body);

  }


}