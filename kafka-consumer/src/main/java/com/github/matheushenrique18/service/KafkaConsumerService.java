package com.github.matheushenrique18.service;

import com.github.matheushenrique18.model.Student;
import org.apache.kafka.clients.consumer.ConsumerRecord;

public interface KafkaConsumerService {

    public void receiveMessage(ConsumerRecord<?, Student> record);

}
