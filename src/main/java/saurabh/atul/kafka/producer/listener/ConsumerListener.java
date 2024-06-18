package saurabh.atul.kafka.producer.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import saurabh.atul.kafka.producer.util.PlaceMapper;


@Component
public class ConsumerListener
{

    private KafkaTemplate<String,String> kafkaTemplate;

    public ConsumerListener(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @KafkaListener(topics = "personName")
    public void listenerPersonName(String name)
    {
        System.out.println("Received Person Name: " + name);
        kafkaTemplate.send("placeName", PlaceMapper.personToPlaceMapper(name));
    }

    @KafkaListener(topics = "placeName")
    public void listerPlaceName(String placeName)
    {
        System.out.println("Received Place Name: " + placeName);
    }

}
