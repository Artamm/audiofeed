import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';


import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { SubscriberListComponent } from './shared/subscriber/subscriber-list/subscriber-list.component';
import { MusicListComponent } from './music-list/music-list.component';

@NgModule({
  declarations: [
    AppComponent,
    SubscriberListComponent,
    MusicListComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]

})
export class AppModule { }
