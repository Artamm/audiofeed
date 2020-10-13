package com.artamm.audiofeed.service;

import com.artamm.audiofeed.Music;
import com.artamm.audiofeed.repo.MusicRepository;
import com.google.common.io.Files;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Base64;

@Service
//@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MusicService {

    private final MusicRepository musicRepository;

    @Autowired
    public MusicService(MusicRepository musicRepository) {
        this.musicRepository = musicRepository;
    }


    public Flux<Music> musicFlux() {
        return musicRepository.findAll();
    }

    public Mono<Music> addMusic(Music music) {
//        decode64Music(music,);
        music.setAdded(LocalDate.now());
        return musicRepository.save(music);
    }

    public String encoded64Music(Long id) {
        Music music = musicRepository.findMusicById(id);
        return Base64.getEncoder().encodeToString(music.getMusicfile());

    }

    public void decode64Music(Music music, String url) {
        music.setMusicfile(Base64.getDecoder().decode(url));
    }



    public Mono<Music> findMusicById(Long id) {
        return musicRepository.findById(id);
    }

    public Mono<Music> findMusicByTitle(String title) {
        return musicRepository.findByTitle(title);
    }

    public Mono<Void> deleteMusicById(Long id) {
        return musicRepository.deleteById(id);
    }

    public void deleteMusic(Music music) {
        musicRepository.delete(music);
    }


}
