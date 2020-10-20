package com.artamm.audiofeed.service;

import com.artamm.audiofeed.Music;
import com.artamm.audiofeed.repo.MusicRepository;
import com.artamm.audiofeed.service.interfaces.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;
import java.util.Base64;
import java.util.HashMap;

@Service
//@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MusicServiceImpl implements MusicService {

    private final MusicRepository musicRepository;

    @Autowired
    public MusicServiceImpl(MusicRepository musicRepository) {
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


    public Music getMusicData(Object object){
        HashMap musicMap = (HashMap) object;
        Music music = new Music(String.valueOf(musicMap.get("author")), String.valueOf(musicMap.get("title")), String.valueOf(musicMap.get("filename")));
        decode64Music(music, String.valueOf(musicMap.get("musicfile")));
        return music;
    }
    public void decode64Music(Music music, String url) {
        music.setMusicfile(Base64.getMimeDecoder().decode(url));
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

    public Mono<Void> deleteMusic(Music music) {
       return musicRepository.delete(music);
    }


}
