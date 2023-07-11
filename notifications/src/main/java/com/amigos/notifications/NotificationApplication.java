package com.amigos.notifications;

import com.amigos.amqp.RabbitMQMessageRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;

@EnableDiscoveryClient
@FeignClient
@SpringBootApplication(
        scanBasePackages = {
                "com.amigos.notifications",
                "com.amigos.amqp"
        }
)
public class NotificationApplication {
    public static void main(String[] args) {
        SpringApplication.run(NotificationApplication.class,args);
    }

//    @Bean
//    CommandLineRunner commandLineRunner(
//            RabbitMQMessageRunner p,
//            NotificationConfig n
//            ){
//        return args -> {
//            p.run(new Person("Ali",1999));
//        };
//    }


    record Person(String name, int age) {}
}
