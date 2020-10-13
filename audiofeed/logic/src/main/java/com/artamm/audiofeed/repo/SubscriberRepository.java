package com.artamm.audiofeed.repo;

import com.artamm.audiofeed.Subscriber;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*", allowedHeaders = "*")
public interface SubscriberRepository extends ReactiveCrudRepository<Subscriber,Long> {
}
