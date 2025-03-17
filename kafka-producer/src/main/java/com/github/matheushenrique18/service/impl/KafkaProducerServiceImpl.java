package com.github.matheushenrique18.service.impl;

import com.github.matheushenrique18.model.Student;
import com.github.matheushenrique18.service.KafkaProducerService;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

@Slf4j
public class KafkaProducerServiceImpl implements KafkaProducerService {

    @Inject
    @Channel("students-out")
    Emitter<Student> emitter;

    @Override
    public void sendMessage(Student student) {
        emitter.send(student);
        log.info("Message sent to kafka: {}", student);
    }
}
