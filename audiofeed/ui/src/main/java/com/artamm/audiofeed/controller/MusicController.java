package com.artamm.audiofeed.controller;

import com.artamm.audiofeed.Music;
import com.artamm.audiofeed.Subscriber;
import com.artamm.audiofeed.service.MusicService;
import com.artamm.audiofeed.service.SubscriberService;
import com.google.common.io.Files;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.http.HttpStatus.NO_CONTENT;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/controller")
public class MusicController {

    private final MusicService musicService;
    private  final SubscriberService subscriberService;

    @Autowired
    public MusicController(MusicService musicService, SubscriberService subscriberService) {
        this.musicService = musicService;
        this.subscriberService = subscriberService;
        musicService.saveMusicRamm();

    }

    @GetMapping("/music")
    public Flux<Music> list() {
        return musicService.musicFlux();
    }

    @GetMapping("/subscribers")
    public Flux<Subscriber> subscriberFlux() {
        return subscriberService.list();
    }
    @GetMapping("/subscribers/subscriber/{id}")
    public Mono<Subscriber> subscriberMono(@PathVariable Long id) {
        return subscriberService.subscriberById(id);
    }


    @GetMapping("/music/file/{id}")
    public String musicFileByIdEncoded64(Long id){
        return musicService.encoded64Music(id);
    }


    @GetMapping("/music/{id}")
    public Mono<Music> musicMono(@PathVariable Long id){
        return musicService.findMusicById(id);
    }

    @PostMapping(value = "/music/add", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Mono<Music> addMusic(@RequestBody Music music, @RequestPart("musicFile") Mono<FilePart> file) {
        return musicService.addMusic(music);
    }


    @DeleteMapping("music/delete/{id}")
    @ResponseStatus(NO_CONTENT)
    public Mono<Void>  deleteMusicById(@PathVariable("id") Long id){
       return musicService.deleteMusicById(id);
    }

    @PostMapping("/subscribers/add")
    public Mono<Subscriber> addSubscriber(@RequestBody Subscriber subscriber) {
        return subscriberService.addSubscriber(subscriber);
    }
    @DeleteMapping("/subscribers/delete/{id}")
    public Mono<Void> deleteSubscriberById(@PathVariable  Long id) {
        return subscriberService.deleteSubscriberById(id);
    }
    @DeleteMapping("/subscribers/delete/")
    public Mono<Void> deleteSubscriber(@RequestBody Subscriber subscriber) {
        return subscriberService.deleteSubscriber(subscriber);
    }






}
