package com.github.matheushenrique18.service.impl;

import com.github.matheushenrique18.model.Student;
import com.github.matheushenrique18.service.KafkaConsumerService;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

@Slf4j
@ApplicationScoped
public class KafkaConsumerServiceImpl implements KafkaConsumerService {

    @Override
    @Incoming("students-in")
    public void receiveMessage(ConsumerRecord<?, Student> record) {
        log.info("Received message: {} | Topic: {} | Partition: {} | OffSet {}", record.value(), record.topic(), record.partition(), record.offset());
    }

    @Override
    @Incoming("students-in")
    @Outgoing("students-process-out")
    public Student processMessage(ConsumerRecord<?, Student> record) {
        log.info("Applying weight two to the student's score");
        var student = record.value();
        var newScore = student.getScore() * 2;
        student.setScore(newScore);
        log.info("New student's score: {}", student);
        return student;
    }

}
