package com.artamm.audiofeed.service;

import com.artamm.audiofeed.Music;
import com.artamm.audiofeed.repo.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Date;

@Service
public class MusicService {

    private final MusicRepository musicRepository;

    @Autowired
    public MusicService( MusicRepository musicRepository) {
        this.musicRepository = musicRepository;
    }


    public Flux<Music> musicFlux(){
        return musicRepository.findAll();
    }

    public Mono<Music> addMusic(Music music){
        music.setAdded(new Date());
        return  musicRepository.save(music);
    }

    public Mono<Music> findMusicById(Long id){
        return musicRepository.findById(id);
    }

    public Mono<Music> findMusicByTitle(String title){
        return musicRepository.findByTitle(title);
    }

    public void deleteMusicById(Long id){
        musicRepository.deleteById(id);
    }

    public  void deleteMusic(Music music){
        musicRepository.delete(music);
    }


}
