import {Component, OnInit} from '@angular/core';
import {MusicService} from '../shared/services/music/music.service';
import {Observable} from 'rxjs';
import {Music} from '../shared/services/music/music';

@Component({
  selector: 'app-music-list',
  templateUrl: './music-list.component.html',
  styleUrls: ['./music-list.component.css']
})
export class MusicListComponent implements OnInit {
   musicList: Observable<Music>;
  constructor(private musicService: MusicService) {
  }

  ngOnInit(): void {
    this.musicService.getMusicList().subscribe(data =>{
      this.musicList = data;
      console.log(data);
    });
  }

}
