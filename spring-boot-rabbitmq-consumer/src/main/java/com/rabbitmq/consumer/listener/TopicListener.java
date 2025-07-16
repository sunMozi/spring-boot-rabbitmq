package com.rabbitmq.consumer.listener;

import com.rabbitmq.consumer.config.RabbitMQTopicConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class TopicListener {

  @RabbitListener(queues = RabbitMQTopicConfig.QUEUE_NAME_1)
  public void listenAlpha(String message) {
    System.out.println("【队列1收到消息】：" + message);
  }

  @RabbitListener(queues = RabbitMQTopicConfig.QUEUE_NAME_2)
  public void listenBeta(String message) {
    System.out.println("【队列2收到消息】：" + message);
  }
}
