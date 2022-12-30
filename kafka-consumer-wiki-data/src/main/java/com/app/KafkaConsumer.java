package com.app;

import com.app.entity.WikimediaData;
import com.app.repository.WikiDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaConsumer.class);
    private WikiDataRepository wikiDataRepository;

    public KafkaConsumer(WikiDataRepository wikiDataRepository) {
        this.wikiDataRepository = wikiDataRepository;
    }

    @KafkaListener(topics = "Wiki_recent_changes",groupId = "myGroup")
    public void consume(String eventMessage){
        LOGGER.info(String.format("Message Received -> %s",eventMessage));
        WikimediaData wikimediaData =new WikimediaData();
        wikimediaData.setWikiEventData(eventMessage);
        wikiDataRepository.save(wikimediaData);
    }
}
