package com.artamm.audiofeed.controller;

import com.artamm.audiofeed.Music;
import com.artamm.audiofeed.MusicGet;
import com.artamm.audiofeed.Subscriber;
import com.artamm.audiofeed.service.MailService;
import com.artamm.audiofeed.service.SubscriberService;
import com.artamm.audiofeed.service.interfaces.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.http.HttpStatus.NO_CONTENT;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/controller")
public class MusicController {

    private final MusicService musicService;
    private final SubscriberService subscriberService;
    private final MailService mailService;

    @Autowired
    public MusicController(MusicService musicService, SubscriberService subscriberService, MailService mailService) {
        this.musicService = musicService;
        this.subscriberService = subscriberService;
        this.mailService = mailService;
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
    public String musicFileByIdEncoded64(Long id) {
        return musicService.encoded64Music(id);
    }


    @GetMapping("/music/{id}")
    public Mono<Music> musicMono(@PathVariable Long id) {
        return musicService.findMusicById(id);
    }

    @PostMapping(value = "/music/add", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Mono<Music> addMusic(@RequestPart("musicfile") Mono<FilePart> file) {
//        subscriberService.list().subscribe(subscriber -> {
//            mailService.sendNotification("new music", subscriber.getEmail());
//        });
        Music music = new Music();
        musicService.decode64Music(music, String.valueOf(file));
        return musicService.addMusic(music);
    }

    @PostMapping("/music/addMusic")
    public Mono<Music> addMusicGet(@RequestBody MusicGet musicGet){
        Music music = new Music(musicGet);
        musicService.decode64Music(music,musicGet.getMusicfile());
        sendMessage(music.getTitle());
        return  musicService.addMusic(music);
    }



    @PostMapping("/music/addM")
    public Mono<Music>addMusicFileText(@RequestBody Object music){

        Music modified = musicService.getMusicData(music);
        return  musicService.addMusic(modified);
    }

    @DeleteMapping("music/delete/{id}")
    @ResponseStatus(NO_CONTENT)
    public Mono<Void> deleteMusicById(@PathVariable("id") Long id) {
        return musicService.deleteMusicById(id);
    }

    @PostMapping("/subscribers/add")
    public Mono<Subscriber> addSubscriber(@RequestBody Subscriber subscriber) {
        mailService.sendGreeting(subscriber);
        return subscriberService.addSubscriber(subscriber);
    }

    @DeleteMapping("/subscribers/delete/{id}")
    public Mono<Void> deleteSubscriberById(@PathVariable Long id) {
        return subscriberService.deleteSubscriberById(id);
    }

    @DeleteMapping("/subscribers/delete/")
    public Mono<Void> deleteSubscriber(@RequestBody Subscriber subscriber) {
        return subscriberService.deleteSubscriber(subscriber);
    }

    @Async
    public void sendMessage(String musicName){
        subscriberService.list().subscribe(subscriber -> {
            mailService.sendNotification(musicName, subscriber.getEmail());
        });
    }

}
