package br.com.bluty.senderservice.sender;

import br.com.bluty.senderservice.exception.SendEmailException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class SendMailServiceImpl implements SendMailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private FreeMarkerService freeMarkerService;

    @Override
    public void send(Email email) {
        try{
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "UTF-8");

            helper.setFrom("blutybr@gmail.com");
            helper.setTo(email.getDestinatarios());
            helper.setSubject(email.getAssunto());
            helper.setText(email.getCorpo(), true);

            javaMailSender.send(mimeMessage);
        }catch(Exception e){
            throw new SendEmailException("Não foi possivel enviar e-mail", e);
        }

    }

}
