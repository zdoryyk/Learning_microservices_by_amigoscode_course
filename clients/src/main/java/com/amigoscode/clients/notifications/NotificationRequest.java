package com.amigoscode.clients.notifications;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class NotificationRequest implements Serializable {

    private String message;

    private String sender;

    private String to_customer_email;

}
