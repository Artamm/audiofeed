package com.artamm.audiofeed.repo;

import com.artamm.audiofeed.Subscriber;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200")
public interface SubscriberRepository extends ReactiveCrudRepository<Subscriber,Long> {
}
