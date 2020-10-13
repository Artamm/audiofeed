import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Music} from './music';
import {Subscriber} from '../subscribe/subscriber';

@Injectable({
  providedIn: 'root'
})
export class MusicService {

  private baseUrl = 'http://localhost:8080/controller/music/';

  headers: HttpHeaders;
  constructor(private http: HttpClient) {
  }


  getMusicList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }


  getMusicById(musicId: number): Observable<any> {
    return this.http.get(`${this.baseUrl}` + musicId);
  }

  getMusicFileById(musicId: number): Observable<any> {
    return this.http.get(`${this.baseUrl}` + 'file/' + musicId);
  }

  saveMusic(music: Music): Observable<any> {
    return this.http.post<Music>(`${this.baseUrl}` + 'add', music, {headers: this.headers, reportProgress: true});
  }

  deleteMusic(id: number): Observable<any> {
    return this.http.delete<Music>(`${this.baseUrl}` + `delete/${id}`);
  }
}
