import {Component, OnInit} from '@angular/core';
import {Music} from '../shared/services/music/music';
import {MusicService} from '../shared/services/music/music.service';
import {ActivatedRoute, Router} from '@angular/router';
import {Subscriber} from '../shared/services/subscribe/subscriber';

@Component({
  selector: 'app-music-form',
  templateUrl: './music-form.component.html',
  styleUrls: ['./music-form.component.css']
})
export class MusicFormComponent implements OnInit {
  music;
  fileToUpload: File = null;



  constructor(private route: ActivatedRoute,
              private router: Router, private musicService: MusicService) {
    this.music = new Music();

  }

  ngOnInit(): void {

  }

  // // setParameters() {
  // //   document.getElementById("filename").va = document.getElementById("musicFile").files[0].;
  // //
  // // }
  // setParameters($event): void {
  //     // console.log('start' + this.music.musicfile);
  //     //
  //     this.file = event.target.files[0];
  //   // const promise = this.getBase64(file);
  //   // promise.then(function(f) {
  //   //   this.music.musicfile = f;
  //   // });
  //   // document.getElementById('filename').setAttribute('value', document.getElementById('musicFile').name);
  // }
  //
  //   save(music: Music): void {
  //     console.log(this.file);
  //   this.musicService.saveMusic(this.file).subscribe(data => console.log(data), error => console.log(error));
  //   this.gotoRefresh();
  // }
  setParameters(): void {
  }

  save(music: Music): void{
    let array;
    const reader = new FileReader();
    reader.readAsDataURL(this.fileToUpload);
    reader.onload = () => {
      array = reader.result;
      music.musicfile = array;
      this.musicService.saveMusicText(music).subscribe(data => console.log(data));
    };
  }


  gotoRefresh(): void {
    this.router.navigate(['/']);
  }

  handleFileInput(files: FileList) {
    this.fileToUpload = files.item(0);
  }
}
