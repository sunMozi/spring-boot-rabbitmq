package com.rabbitmq.consumer.listener;


import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author moZiA
 * @date 2025/7/15 15:16
 * @description
 */
@Component
public class ProducerDemo1Listener {


  @RabbitListener(queues = "queue_test")
  public void onMessage(Message message) {
    System.out.println("监听到的消息：" + new String(message.getBody()));
  }


}