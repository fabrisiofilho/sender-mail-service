package br.com.bluty.senderservice.sender;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Email {

    private String destinatarios;
    private String assunto;
    private String corpo;

}
