package br.com.bluty.senderservice.messenger.publisher;

import br.com.bluty.senderservice.messenger.model.RabbitMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RabbitMQPublisher {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private void send(String exchange, String routingKey, RabbitMessage rabbitMessage) {
        rabbitTemplate.convertAndSend(exchange, routingKey, rabbitMessage);
    }

}
