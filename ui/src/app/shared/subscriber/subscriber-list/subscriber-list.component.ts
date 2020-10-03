import { Component, OnInit } from '@angular/core';
import {Subscriber} from '../../services/subscribe/subscriber';
import {Observable} from 'rxjs';
import {SubscriberService} from '../../services/subscribe/subscriber.service';

@Component({
  selector: 'app-subscriber-list',
  templateUrl: './subscriber-list.component.html',
  styleUrls: ['./subscriber-list.component.css']
})
export class SubscriberListComponent implements OnInit {


  subscribers: Observable<Subscriber>;
  constructor(private subscriberService: SubscriberService) { }


  ngOnInit(): void {
    this.subscriberService.getSubscribersList().subscribe(data => {
      this.subscribers = data;
      console.log(data);
    });
  }

}
