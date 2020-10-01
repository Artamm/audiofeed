package com.artamm.audiofeed.repo;

import com.artamm.audiofeed.Music;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

public interface MusicRepository extends ReactiveCrudRepository<Music,Long> {
    Mono<Music> findByTitle(String title);
}
