import {Component, OnInit} from '@angular/core';
import {MusicService} from '../shared/services/music/music.service';
import {Observable} from 'rxjs';
import {Music} from '../shared/services/music/music';
import {CdkDragDrop, moveItemInArray, transferArrayItem} from '@angular/cdk/drag-drop';
import {ActivatedRoute, Router} from '@angular/router';
import {AsyncAction} from 'rxjs/internal/scheduler/AsyncAction';

@Component({
  selector: 'app-music-list',
  templateUrl: './music-list.component.html',
  styleUrls: ['./music-list.component.css']
})
export class MusicListComponent implements OnInit {
  musicList: Observable<Music>;


  constructor(private route: ActivatedRoute,
              private router: Router, private musicService: MusicService) {
  }

  ngOnInit(): void {
    this.musicService.getMusicList().subscribe(data => {
     return  this.musicList = data;
    });
  }

  initMusic(musicfile: string, id: number): void {

    const b64toBlob = (b64Data, contentType = 'audio/mp3', sliceSize = 512) => {
      const byteCharacters = atob(b64Data);
      const byteArrays = [];

      for (let offset = 0; offset < byteCharacters.length; offset += sliceSize) {
        const slice = byteCharacters.slice(offset, offset + sliceSize);

        const byteNumbers = new Array(slice.length);
        for (let i = 0; i < slice.length; i++) {
          byteNumbers[i] = slice.charCodeAt(i);
        }

        const byteArray = new Uint8Array(byteNumbers);
        byteArrays.push(byteArray);
      }

      const blob = new Blob(byteArrays, {type: 'audio/mp3'}, );
      return blob;
    };

    const blob = b64toBlob(musicfile, 'audio/mp3');
    const blobUrl = URL.createObjectURL(blob);

    // const blob = new Blob([this.getByteArray(music)], { type: 'audio/mp3' });
    // const url = URL.createObjectURL(blob);
    const audio = document.getElementById('audio_' + id) as HTMLAudioElement;
    const source = document.getElementById('source_' + id);
    audio.src = blobUrl;
  }
  initMusic64(music: string): void{
    const byteCharacters = atob(music);
    const byteNumbers = new Array(byteCharacters.length);
    for (let i = 0; i < byteCharacters.length; i++) {
      byteNumbers[i] = byteCharacters.charCodeAt(i);
    }
    const byteArray = new Uint8Array(byteNumbers);
    const blob = new Blob([byteArray], {type: 'audio/mp3'});

  }

  drop(event: CdkDragDrop<Music[]>) {
    if (event.previousContainer === event.container) {
      moveItemInArray(event.container.data, event.previousIndex, event.currentIndex);
    } else {

      transferArrayItem(event.previousContainer.data,
        event.container.data,
        event.previousIndex,
        event.currentIndex);
    }
  }

  delete(id: number): void {
    this.musicService.deleteMusic(id).subscribe(data => console.log(data), error => console.log(error));
  }

  gotoRefresh() {
    this.router.navigate(['/']);
  }
}
