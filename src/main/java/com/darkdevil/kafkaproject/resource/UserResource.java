package com.darkdevil.kafkaproject.resource;

import com.darkdevil.kafkaproject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kafka")
public class UserResource {

//    @Autowired
//    KafkaTemplate<String, String> kafkaTemplate1;

    @Autowired
    KafkaTemplate<String, User> kafkaTemplate;


    private static final String TOPIC = "Kafka_Example";

//    http://localhost:8080/kafka/publish/hello
//    @GetMapping("/publish/{message}")
//    public String post(@PathVariable("message") final String message){
//        kafkaTemplate1.send(TOPIC, message);
//        return "Publish Successfully";
//    }

    @GetMapping("/publish/user/{name}")
    public String postUser(@PathVariable("name") final String name){
        User user = new User();
        user.setName(name);
        user.setComment("Comment");

        kafkaTemplate.send(TOPIC, user);
        return "Publish Successfully";
    }

}
