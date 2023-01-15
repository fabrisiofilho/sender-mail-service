package br.com.bluty.senderservice.messenger.receiver;

import br.com.bluty.senderservice.entity.RecordSendEmailEntity;
import br.com.bluty.senderservice.messenger.constant.Constants;
import br.com.bluty.senderservice.messenger.model.RabbitMessage;
import br.com.bluty.senderservice.sender.Email;
import br.com.bluty.senderservice.sender.SendMailService;
import br.com.bluty.senderservice.service.RecordSendEmailService;
import br.com.bluty.senderservice.util.JsonConverter;
import br.com.bluty.senderservice.util.JsonConverterImpl;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Slf4j
public class RabbitMQReceiver {

    private final SendMailService sendMailService;
    private final RecordSendEmailService recordSendEmailService;
    private final JsonConverter<Email> emailJsonConverter;

    @Autowired
    public RabbitMQReceiver(SendMailService sendMailService, RecordSendEmailService recordSendEmailService, Gson gson) {
        this.sendMailService = sendMailService;
        this.recordSendEmailService = recordSendEmailService;
        this.emailJsonConverter = new JsonConverterImpl<>(Email.class, gson);
    }

    @RabbitListener(queues = Constants.Queues.QUEUE_MESSENGER)
    public void receivedMessage(RabbitMessage rabbitMessage) {
        sendMailService.send(emailJsonConverter.jsonToObject(rabbitMessage.getPayload()));
        recordSendEmailService.create(RecordSendEmailEntity.builder()
                .description(rabbitMessage.getDescription())
                .code(rabbitMessage.getCode())
                .service(rabbitMessage.getService())
                .payload(rabbitMessage.getPayload())
                .shippingDay(LocalDateTime.now())
                .build());
        log.info("Service Messenger - Recieved Message From RabbitMQ: " + rabbitMessage);
    }

}
