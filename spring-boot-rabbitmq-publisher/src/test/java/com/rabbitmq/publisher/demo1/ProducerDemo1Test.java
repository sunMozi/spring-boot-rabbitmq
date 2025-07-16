package com.rabbitmq.publisher.demo1;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.charset.StandardCharsets;
import lombok.Data;
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

  private final ObjectMapper objectMapper = new ObjectMapper();

  @Test
  public void testSendMessage() throws JsonProcessingException {
    final String exchangeName = ""; // 默认交换机，routingKey 必须是队列名称
    final String routingKey = "queue_test";

    UserDTO user = new UserDTO();
    user.setId(100L);
    user.setUsername("user_" + 100L);
    user.setEmail("user" + 100L + "@example.com");

    String jsonMessage = objectMapper.writeValueAsString(user);

    rabbitTemplate.convertAndSend(exchangeName,
                                  routingKey,
                                  jsonMessage.getBytes(StandardCharsets.UTF_8));


  }

  @Data
  public static class UserDTO {

    private Long id;
    private String username;
    private String email;
  }
}