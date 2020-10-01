package com.artamm.audiofeed.repo;

import com.artamm.audiofeed.Subscriber;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface SubscriberRepository extends ReactiveCrudRepository<Subscriber,Long> {
}
