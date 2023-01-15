package br.com.bluty.senderservice.messenger.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, scope = RabbitMessage.class)
public class RabbitMessage implements Serializable {

    private String code;
    private String service;
    private String description;
    private String payload;

}
