package hector.developer.publisher.controller;

import hector.developer.publisher.client.SubscriberClient;
import hector.developer.publisher.model.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PublisherController {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private SubscriberClient subscriberClient;


    @PostMapping("/publish/topic1")
    public Topic publishTopic(@RequestBody Topic body) {
        return  subscriberClient.subscribe(body);
    }

    @GetMapping("/publisher/allTopics")
    public String getAllTopics(){
        return "Accessing from SUBSCRIBER-SERVICE ==> "+subscriberClient.getAllTopics();
    }
}
