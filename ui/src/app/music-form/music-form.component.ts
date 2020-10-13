import { Component, OnInit } from '@angular/core';
import {Music} from '../shared/services/music/music';
import {MusicService} from '../shared/services/music/music.service';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-music-form',
  templateUrl: './music-form.component.html',
  styleUrls: ['./music-form.component.css']
})
export class MusicFormComponent implements OnInit {
  music: Music;

  constructor(private route: ActivatedRoute,
              private router: Router, private musicService: MusicService) { }

  ngOnInit(): void {

  }

  // setParameters() {
  //   document.getElementById("filename").va = document.getElementById("musicFile").files[0].;
  //
  // }
  setParameters(): void {
    // document.getElementById('filename').setAttribute('value', document.getElementById('musicFile').name);
  }

  save(): void {
    this.musicService.saveMusic(this.music).subscribe(data => console.log(data), error => console.log(error));;
    this.gotoRefresh();
  }

  gotoRefresh(): void {
    this.router.navigate(['/']);
  }
}
