import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {SubscriberService} from '../../services/subscribe/subscriber.service';
import {Observable} from 'rxjs';
import {Subscriber} from '../../services/subscribe/subscriber';
import {ActivatedRoute, Router} from '@angular/router';

@Component({
  selector: 'app-subscriber-form',
  templateUrl: './subscriber-form.component.html',
  styleUrls: ['./subscriber-form.component.css']
})
export class SubscriberFormComponent implements OnInit {

  subscriber;

  constructor(    private route: ActivatedRoute,
                  private router: Router, private subscriberService: SubscriberService) {
    this.subscriber = new Subscriber();
  }


  // subscriberForm = new FormGroup({
  //   email: new FormControl('', [Validators.required, Validators.email])
  // });


  save(): void {
    this.subscriberService.saveSubscriber(this.subscriber).subscribe(data => console.log(data), error => console.log(error));
    this.gotoUserList();
  }


  ngOnInit(): void {
  }

  clickMethod(name: string): void {
    if (confirm('Are you sure to delete ' + name)) {
      console.log('Implement delete functionality here');
    }
  }

  gotoUserList() {
    this.router.navigate(['/']);
  }
}
