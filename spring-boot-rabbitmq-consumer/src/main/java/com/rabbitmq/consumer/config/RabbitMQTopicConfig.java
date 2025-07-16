package com.rabbitmq.consumer.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author moZiA
 * @date 2025/7/15 20:07
 * @description 定义交换机、队列、绑定
 */
@Configuration
public class RabbitMQTopicConfig {

  public static final String TOPIC_EXCHANGE_NAME = "topic_exchange_demo";
  public static final String QUEUE_NAME_1 = "topic_queue_alpha";
  public static final String QUEUE_NAME_2 = "topic_queue_beta";

  @Bean
  public TopicExchange topicExchange() {
    return new TopicExchange(TOPIC_EXCHANGE_NAME, true, false);
  }

  @Bean
  public Queue queueAlpha() {
    return new Queue(QUEUE_NAME_1, true);
  }

  @Bean
  public Queue queueBeta() {
    return new Queue(QUEUE_NAME_2, true);
  }

  @Bean
  public Binding bindingAlpha() {
    return BindingBuilder.bind(queueAlpha())
                         .to(topicExchange())
                         .with("user.*"); // 匹配 user.create, user.delete 等
  }

  @Bean
  public Binding bindingBeta() {
    return BindingBuilder.bind(queueBeta())
                         .to(topicExchange())
                         .with("order.#"); // 匹配 order.abc，order.create.new 等
  }
}
