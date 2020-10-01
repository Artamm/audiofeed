package com.artamm.audiofeed.controller;

import com.artamm.audiofeed.Music;
import com.artamm.audiofeed.Subscriber;
import com.artamm.audiofeed.service.MusicService;
import com.artamm.audiofeed.service.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/controller")
public class MusicController {

    private final MusicService musicService;
    private  final SubscriberService subscriberService;

    @Autowired
    public MusicController(MusicService musicService, SubscriberService subscriberService) {
        this.musicService = musicService;
        this.subscriberService = subscriberService;
    }

    @GetMapping
    public Flux<Music> list() {
        return musicService.musicFlux();
    }

    @GetMapping("/subscribers")
    public Flux<Subscriber> subscriberFlux() {
        return subscriberService.list();
    }
    @GetMapping("/subscribers/{id}")
    public Mono<Subscriber> subscriberMono(@PathVariable Long id) {
        return subscriberService.subscriberById(id);
    }



    @GetMapping("{id}")
    public Mono<Music> musicMono(@PathVariable Long id){
        return musicService.findMusicById(id);
    }

    @PostMapping
    public Mono<Music> add(@RequestBody Music music) {
        return musicService.addMusic(music);
    }


}
