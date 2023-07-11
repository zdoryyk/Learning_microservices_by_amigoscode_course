package com.amigoscode.customer;

import com.amigos.amqp.RabbitMQMessageRunner;
import com.amigoscode.clients.fraud.FraudCheckResponse;
import com.amigoscode.clients.fraud.FraudClient;
import com.amigoscode.clients.notifications.NotificationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final FraudClient fraudClient;
    private final RabbitMQMessageRunner rabbitMQMessageRunner;

    public void registerCustomer(CustomerRegistrationRequest request) throws Exception {
        Customer customer = Customer.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();
        // todo: check if email valid
        // todo: check if email not taken
        customerRepository.saveAndFlush(customer);



        FraudCheckResponse fraudCheckResponse =
                fraudClient.isFraudster(customer.getId());

        if (fraudCheckResponse.isFraudster()) {
            throw new IllegalStateException("fraudster");
        }
        NotificationRequest notificationRequest = new NotificationRequest().builder()
                .to_customer_email(customer.getEmail())
                .sender("amigoscode")
                .message("Hi " + customer.getFirstName() + " welcome to Amigoscode...")
                .build();


        rabbitMQMessageRunner.run(
                notificationRequest
        );

        // todo: send notification

    }
}
