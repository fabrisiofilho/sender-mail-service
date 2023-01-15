package br.com.bluty.senderservice.service.impl;

import br.com.bluty.senderservice.entity.RecordSendEmailEntity;
import br.com.bluty.senderservice.exception.NotFoundException;
import br.com.bluty.senderservice.repository.RecordSendEmailRepository;
import br.com.bluty.senderservice.service.RecordSendEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RecordSendEmailServiceImpl implements RecordSendEmailService {

    @Autowired
    private RecordSendEmailRepository recordSendEmailRepository;

    @Override
    public RecordSendEmailEntity create(RecordSendEmailEntity entity) {
        return recordSendEmailRepository.save(entity);
    }

    @Override
    public RecordSendEmailEntity read(UUID id) {
        return recordSendEmailRepository.findById(id).orElseThrow(()-> { throw new NotFoundException("Não foi possivel enncontrar o registro solicitado.");});
    }

    @Override
    public RecordSendEmailEntity update(RecordSendEmailEntity entity) {
        return recordSendEmailRepository.save(entity);
    }

    @Override
    public RecordSendEmailEntity delete(UUID id) {
        RecordSendEmailEntity recordSendEmailEntity = read(id);
        recordSendEmailRepository.deleteById(id);
        return recordSendEmailEntity;
    }

    @Override
    public List<RecordSendEmailEntity> list() {
        return recordSendEmailRepository.findAll();
    }

}
