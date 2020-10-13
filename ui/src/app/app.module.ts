import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';


import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { SubscriberListComponent } from './shared/subscriber/subscriber-list/subscriber-list.component';
import { MusicListComponent } from './music-list/music-list.component';
import { SubscriberFormComponent } from './shared/subscriber/subscriber-form/subscriber-form.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { SearchFormComponent } from './search-form/search-form.component';
import { MusicFormComponent } from './music-form/music-form.component';
import {DragDropModule} from '@angular/cdk/drag-drop';

@NgModule({
  declarations: [
    AppComponent,
    SubscriberListComponent,
    MusicListComponent,
    SubscriberFormComponent,
    SearchFormComponent,
    MusicFormComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule,
    AppRoutingModule,
    DragDropModule
  ],
  providers: [],
  bootstrap: [AppComponent]

})
export class AppModule { }
