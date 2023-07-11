package com.amigos.notifications.service;

import com.amigos.notifications.model.Notification;
import com.amigos.notifications.repositories.NotificationRepository;
import com.amigoscode.clients.notifications.NotificationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class NotificationService {

    final NotificationRepository notificationRepository;


    public void registerNotification(NotificationRequest notificationRequest){
        Notification notification = Notification.builder()
                .message(notificationRequest.getMessage())
                .sender(notificationRequest.getSender())
                .send_at(LocalDateTime.now())
                .to_customer_email(notificationRequest.getTo_customer_email()).build();


        notificationRepository.save(notification);
    }


}
