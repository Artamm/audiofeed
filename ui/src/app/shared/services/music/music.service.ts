import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MusicService {

  private baseUrl = 'http://localhost:8080/controller/music/';
  constructor(private http: HttpClient) { }

  getMusicList(): Observable<any> {
    return this.http.get(`${this.baseUrl}`);
  }
}
