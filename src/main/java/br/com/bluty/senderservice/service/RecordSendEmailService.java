package br.com.bluty.senderservice.service;

import br.com.bluty.senderservice.entity.RecordSendEmailEntity;

import java.util.List;
import java.util.UUID;

public interface RecordSendEmailService {

    RecordSendEmailEntity create(RecordSendEmailEntity entity);
    RecordSendEmailEntity read(UUID id);
    RecordSendEmailEntity update(RecordSendEmailEntity entity);
    RecordSendEmailEntity delete(UUID id);
    List<RecordSendEmailEntity> list();

}
