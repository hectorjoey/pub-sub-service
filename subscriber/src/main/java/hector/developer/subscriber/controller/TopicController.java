package hector.developer.subscriber.controller;

import hector.developer.subscriber.dto.TopicDTO;
import hector.developer.subscriber.model.Topic;
import hector.developer.subscriber.repository.TopicRepository;
import hector.developer.subscriber.service.TopicService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
public class TopicController {

private final TopicRepository topicRepository;
    private final TopicService service;

    public TopicController(TopicService service, TopicRepository topicRepository) {
        this.service = service;
        this.topicRepository = topicRepository;
    }

    @PostMapping(value = "/subscribe/{t}")
    public TopicDTO addSubscription(@Valid @RequestBody TopicDTO body, @PathVariable("t") String topic) {
        return service.addSubscription(body, topic);
    }

    @GetMapping(value = "/allTopics")
    public List<Topic> getAllTopics(){
        return service.findAll();

    }

    @PostMapping(value = "/publish/{topic}")
    public ResponseEntity publishMessage(@PathVariable("topic") String topic, @RequestBody Topic data) {
        String url = data.getUrl();
        Optional<Topic> findUrlHavingSameTopic = service.getTopicRepository().findByUrl(url);
        List<Topic> topics = service.getTopicRepository().findAll();
        topics.forEach(x -> {
            x.getTopic().equalsIgnoreCase(topic);
        });

        return new ResponseEntity<>(topicRepository.save(data),HttpStatus.CREATED );
//        return ResponseEntity.ok(HttpStatus.CREATED );
    }
}
