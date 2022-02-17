package hector.developer.publisher.model;

import lombok.Data;

@Data
public class Topic {
    private String topic;
    private String url;

    public Topic() {
    }
}
