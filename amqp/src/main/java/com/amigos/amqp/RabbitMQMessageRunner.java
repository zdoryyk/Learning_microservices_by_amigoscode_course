package com.amigos.amqp;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQMessageRunner {

    private final RabbitTemplate rabbitTemplate;
    private final Receiver receiver;

    public RabbitMQMessageRunner(Receiver receiver, RabbitTemplate rabbitTemplate) {
        this.receiver = receiver;
        this.rabbitTemplate = rabbitTemplate;
    }



    public void run(Object object) throws Exception {
        System.out.println("Sending message...");
        rabbitTemplate.convertAndSend(MessagingRabbitmqConfig.topicExchangeName,
                "foo.bar.baz",
               object);
    }

}