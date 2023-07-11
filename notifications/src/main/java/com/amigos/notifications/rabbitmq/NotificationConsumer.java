package com.amigos.notifications.rabbitmq;

import com.amigos.notifications.service.NotificationService;
import com.amigoscode.clients.notifications.NotificationRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Slf4j
public class NotificationConsumer  {

    private final NotificationService notificationService;


    @RabbitListener(queues = "spring-boot")
    public void consumer(NotificationRequest notificationRequest) throws InterruptedException {
        System.out.println(notificationRequest);
        notificationService.registerNotification(notificationRequest);
    }
}
