package hector.developer.publisher.client;

import feign.Headers;

import hector.developer.publisher.model.Topic;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "SUBSCRIBER-SERVICE")
public interface SubscriberClient {

    @PostMapping(value = "/subscribe/topic1")
    @Headers("Content-Type: application/json")
    Topic subscribe(@RequestBody Topic body);

    @GetMapping(value = "/allTopics")
    List<Topic> getAllTopics();
}