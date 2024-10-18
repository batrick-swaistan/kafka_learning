package org.batrick.kafka.controller;

import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.apache.kafka.common.protocol.types.Field;
import org.batrick.kafka.payload.Student;
import org.batrick.kafka.producer.KafkaProducer;
import org.batrick.kafka.producer.KakfaJsonProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/messages")
@RequiredArgsConstructor
public class MessageController {

    private final KafkaProducer kafkaProducer;

    private final KakfaJsonProducer kakfaJsonProducer;;

    @PostMapping("/json")
    public ResponseEntity<String> sendMessage(@RequestBody Student student){

        kakfaJsonProducer.sendMessage(student);
        return ResponseEntity.ok("Message queued successfully");

    }

    @PostMapping
    public ResponseEntity<String> sendMessage(@RequestBody String message){

        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Message queued successfully");

    }
}
