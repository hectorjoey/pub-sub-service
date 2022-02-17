package hector.developer.subscriber.service;

import hector.developer.subscriber.dto.TopicDTO;
import hector.developer.subscriber.exception.RecordAlreadyPresentException;
import hector.developer.subscriber.model.Topic;
import hector.developer.subscriber.repository.TopicRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicService {
    private final TopicRepository topicRepository;

    public TopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }


    public TopicDTO addSubscription(TopicDTO body, String topic) throws RecordAlreadyPresentException {
        Optional<Topic> findTopicByURL = topicRepository.findByUrl(body.getUrl());
        if (findTopicByURL.isPresent()) {
            throw new RecordAlreadyPresentException("The Url:" + body.getUrl() + " already Exist");
        }

        body.setTopic(topic);
        body.setUrl(body.getUrl());
        return body;
    }

    public List<Topic> findAll() {
        return topicRepository.findAll();
    }

    public TopicRepository getTopicRepository() {
        return topicRepository;
    }

}
