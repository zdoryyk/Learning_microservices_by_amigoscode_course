package com.amigoscode.clients.notifications;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "notification",
        url = "localhost:8082"
)
public interface NotificationClient {

    @LoadBalanced
    @PostMapping(path = "/api/v1/notification/register")
    Boolean registerNotification(
            @RequestBody NotificationRequest notificationRequest);

}
