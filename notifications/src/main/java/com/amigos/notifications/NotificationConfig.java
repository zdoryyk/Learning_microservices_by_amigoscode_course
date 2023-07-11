package com.amigos.notifications;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Queue;

@Configuration
@Getter
@Setter
@Slf4j
public class NotificationConfig {


    private String internalExchange = "internal.exchange";

    private String notificationQueue = "notification.queue";

    private String internalNotificationRoutingKey = "internal.notification.routing-key";


}
