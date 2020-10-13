package com.artamm.audiofeed.service;

import com.artamm.audiofeed.Subscriber;
import com.artamm.audiofeed.repo.SubscriberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
//@CrossOrigin(origins = "*", allowedHeaders = "*")

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
    public Mono<Subscriber> addSubscriber(Subscriber subscriber){
        return subscriberRepository.save(subscriber);
    }


    public Mono<Void> deleteSubscriberById(Long id) {
        return subscriberRepository.deleteById(id);
    }

    public Mono<Void> deleteSubscriber(Subscriber subscriber) {
        return subscriberRepository.delete(subscriber);
    }
}
