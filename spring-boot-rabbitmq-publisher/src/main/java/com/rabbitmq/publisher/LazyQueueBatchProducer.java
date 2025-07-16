package com.rabbitmq.publisher;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class LazyQueueBatchProducer implements CommandLineRunner {

  @Autowired
  private RabbitTemplate rabbitTemplate;

  private static final int TOTAL_MESSAGES = 3_000_000;
  private static final int THREAD_COUNT = 20;

  @Override
  public void run(String... args) {
//    System.out.println("准备发送 " + TOTAL_MESSAGES + " 条消息到惰性队列...");
//
//    ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);
//
//    for (int t = 0; t < THREAD_COUNT; t++) {
//      int threadIndex = t;
//      executor.submit(() -> {
//        int messagesPerThread = TOTAL_MESSAGES / THREAD_COUNT;
//        for (int i = 0; i < messagesPerThread; i++) {
//          long index = threadIndex * messagesPerThread + i;
//          String message = "惰性队列消息 - 编号：" + index;
//          rabbitTemplate.convertAndSend("lazy.queue", message.getBytes(StandardCharsets.UTF_8));
//
//          if (index % 10000 == 0) {
//            System.out.printf("[线程 %d] 已发送：%d 条%n", threadIndex, index);
//          }
//        }
//      });
//    }
//
//    executor.shutdown();
  }
}