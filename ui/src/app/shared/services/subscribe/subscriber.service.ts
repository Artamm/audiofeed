import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Subscriber} from './subscriber';

@Injectable({
  providedIn: 'root'
})
export class SubscriberService {
  private baseUrl = 'http://localhost:8080/controller/subscribers/';

  constructor(private http: HttpClient) {
  }

  getSubscribersList(): Observable<any> {
    return this.http.get(this.baseUrl);
  }

  // tslint:disable-next-line:ban-types
  getSubscriber(id: number): Observable<Object> {
    return this.http.get(`${this.baseUrl}/subscriber/${id}`);
  }

  saveSubscriber(subscriber: Subscriber): Observable<any> {
    return this.http.post<Subscriber>(this.baseUrl + 'add', subscriber);
  }
  deleteSubscriberById(id: number): Observable<any>{
    return this.http.delete(`${this.baseUrl}` + `delete/${id}`,{ responseType: 'text' });
  }
  deleteSubscriber(subscriber: Subscriber): Observable<any>{
    // @ts-ignore
    return this.http.delete<Subscriber>(`${this.baseUrl}` + 'delete', subscriber);
  }

}

