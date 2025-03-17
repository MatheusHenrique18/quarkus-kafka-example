package com.github.matheushenrique18.model;

import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer;

public class StudentDeserializer extends ObjectMapperDeserializer<Student> {

    public StudentDeserializer() {
        super(Student.class);
    }

}
