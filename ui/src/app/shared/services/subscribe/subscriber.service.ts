import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SubscriberService {
  private baseUrl = 'http://localhost:8080/controller/subscribers/';

  constructor(private http: HttpClient) {}

  getSubscribersList(): Observable<any> {
    return this.http.get(this.baseUrl);
  }

  getSubscriber(id: number): Observable<Object> {
    return this.http.get(`${this.baseUrl}/subscriber/${id}`);
  }
}

