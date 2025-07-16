package com.rabbitmq.consumer.listener;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author moZiA
 * @date 2025/7/15 15:16
 * @description
 */
@Slf4j
@Component
public class ProducerDemo1Listener {

  private final ObjectMapper objectMapper = new ObjectMapper();

  @RabbitListener(queues = "queue_test")
  public void onMessage(Message message) throws JsonProcessingException {

    String json = new String(message.getBody());
    UserDTO user = objectMapper.readValue(json, UserDTO.class);
    log.info("监听到的消息对象：{}", user);

  }

  @Data
  public static class UserDTO {

    private Long id;
    private String username;
    private String email;
  }
}