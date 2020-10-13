package com.artamm.audiofeed.repo;

import com.artamm.audiofeed.Music;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import reactor.core.publisher.Mono;
@CrossOrigin(origins = "http://localhost:4200")
//@CrossOrigin(origins = "*", allowedHeaders = "*")
public interface MusicRepository extends ReactiveCrudRepository<Music,Long> {
    Mono<Music> findByTitle(String title);
    Music findMusicById(Long id);
}
