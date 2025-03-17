package com.github.matheushenrique18.resource;

import com.github.matheushenrique18.model.Student;
import com.github.matheushenrique18.service.KafkaProducerService;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/producer")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class KafkaProducerResource {

    @Inject
    KafkaProducerService kafkaProducerService;

    @POST
    public Response produceMessage(Student student){
        kafkaProducerService.sendMessage(student);
        return Response.accepted(student).build();
    }
}
