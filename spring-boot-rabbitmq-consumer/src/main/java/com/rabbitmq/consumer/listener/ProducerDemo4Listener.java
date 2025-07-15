package com.rabbitmq.consumer.listener;


import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author moZiA
 * @date 2025/7/15 17:12
 * @description
 */
@Component
public class ProducerDemo4Listener {

  @RabbitListener(queues = {"DQ1"})
  public void onMessage1(Message message) {
    System.out.println("onMessage1 :监听到的消息：" + new String(message.getBody()));
  }

  @RabbitListener(queues = {"DQ2"})
  public void onMessage2(Message message) {
    System.out.println("onMessage2 :监听到的消息：" + new String(message.getBody()));
  }

}