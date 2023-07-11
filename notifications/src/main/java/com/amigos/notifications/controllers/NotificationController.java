package com.amigos.notifications.controllers;

import com.amigos.notifications.model.Notification;
import com.amigoscode.clients.notifications.NotificationRequest;
import com.amigos.notifications.service.NotificationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/notification")
public class NotificationController {

    final NotificationService notificationService;


    @PostMapping(path = "/register")
    public Boolean registerNotification(@RequestBody NotificationRequest notificationRequest){
        notificationService.registerNotification(notificationRequest);

        return true;
    }


}
