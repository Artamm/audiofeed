import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {SubscriberFormComponent} from './shared/subscriber/subscriber-form/subscriber-form.component';

const routes: Routes = [
  { path: 'saveSubscriber', component: SubscriberFormComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
