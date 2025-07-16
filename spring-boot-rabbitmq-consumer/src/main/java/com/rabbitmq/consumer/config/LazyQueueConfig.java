package com.rabbitmq.consumer.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LazyQueueConfig {

  @Bean
  public Queue lazyQueue() {
    return QueueBuilder.durable("lazy.queue").withArgument("x-queue-mode", "lazy") // Lazy 队列声明关键参数
                       .build();
  }


}
