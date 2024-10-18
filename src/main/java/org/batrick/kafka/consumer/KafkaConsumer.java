package org.batrick.kafka.consumer;


import lombok.extern.slf4j.Slf4j;
import org.batrick.kafka.payload.Student;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumer {

//    @KafkaListener(topics = "batrick-swaistan", groupId = "myGroup")
//    public void consumerMsg(String message){
//        log.info("Consuming the message from batrick-swaistn topic =========>{}",message);
//
//    }

    @KafkaListener(topics = "batrick-swaistan", groupId = "myGroup")
    public void consumerJsonMsg(Student student){
        log.info("Consuming the message from batrick-swaistn topic =========>{}", student.toString());

    }
}
