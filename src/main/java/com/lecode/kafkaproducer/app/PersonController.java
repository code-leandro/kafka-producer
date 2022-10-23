package com.lecode.kafkaproducer.app;

import com.lecode.kafkaproducer.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/person")
public class PersonController {

    private final PersonService service;

    @PostMapping
    public ResponseEntity<Boolean> produceMessage() {

        try {
            service.sendMessage();
            return ResponseEntity.ok(true);
        }
        catch (Exception e) {
            return ResponseEntity.ok(false);
        }
    }
}
