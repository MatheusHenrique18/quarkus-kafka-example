package com.github.matheushenrique18.service;

import com.github.matheushenrique18.model.Student;

public interface KafkaProducerService {

    public void sendMessage(Student student);

}
