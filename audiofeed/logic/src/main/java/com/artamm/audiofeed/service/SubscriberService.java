package com.artamm.audiofeed.service;

import com.artamm.audiofeed.Subscriber;
import com.artamm.audiofeed.repo.SubscriberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class SubscriberService {

    private final SubscriberRepository subscriberRepository;

    @Autowired
    public SubscriberService(SubscriberRepository subscriberRepository) {
        this.subscriberRepository = subscriberRepository;
    }

    public Flux<Subscriber> list(){
        return subscriberRepository.findAll();
    }

    public Mono<Subscriber> subscriberById(Long id){
        return subscriberRepository.findById(id);
    }
}
