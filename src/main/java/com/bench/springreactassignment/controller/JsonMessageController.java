package com.bench.springreactassignment.controller;

import com.bench.springreactassignment.producer.KafkaProducer;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/kafka")
@AllArgsConstructor
public class JsonMessageController {

    private KafkaProducer kafkaProducer;


    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody String user){
        kafkaProducer.sendMessage(user);
        return ResponseEntity.ok("Json message sent to kafka topic");
    }

    @GetMapping("/get")
    public ResponseEntity<String> get(@RequestBody String user){
        return ResponseEntity.ok("Json message sent to kafka topic");
    }
}