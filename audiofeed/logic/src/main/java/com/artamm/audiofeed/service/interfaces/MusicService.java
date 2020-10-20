package com.artamm.audiofeed.service.interfaces;

import com.artamm.audiofeed.Music;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public interface MusicService {

    Flux<Music> musicFlux();

    Mono<Music> addMusic(Music music);

    Music getMusicData(Object object);
    Mono<Music> findMusicById(Long id);
    Mono<Void> deleteMusicById(Long id);


    void decode64Music(Music music, String url);
    String encoded64Music(Long id);


}

