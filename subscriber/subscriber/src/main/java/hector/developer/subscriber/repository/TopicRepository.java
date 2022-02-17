package hector.developer.subscriber.repository;

import hector.developer.subscriber.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TopicRepository extends JpaRepository<Topic,Long> {
    Optional<Topic> findByUrl(String url);
}
