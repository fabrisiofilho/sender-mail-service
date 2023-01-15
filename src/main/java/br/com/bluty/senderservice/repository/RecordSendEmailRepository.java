package br.com.bluty.senderservice.repository;

import br.com.bluty.senderservice.entity.RecordSendEmailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RecordSendEmailRepository extends JpaRepository<RecordSendEmailEntity, UUID> {

}
