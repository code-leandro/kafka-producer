package com.lecode.kafkaproducer.service;

import com.lecode.kafkaproducer.dto.PersonDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PersonService {

    public static final String TOPIC_PERSON = "meu-topico";
    private final KafkaTemplate<String, PersonDTO> kafkaTemplate;

    public void sendMessage() {
        PersonDTO person = PersonDTO.builder()
                .name("Leandro")
                .age(30)
                .build();
        log.info("[Sending message] for kafka");
        log.info("[Message] {}", person);
        kafkaTemplate.send(TOPIC_PERSON, person);
        log.info("[Sent]");
    }

}
