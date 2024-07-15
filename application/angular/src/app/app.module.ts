import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { HttpClientModule } from '@angular/common/http';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
import { AppComponent } from './app.component';
import { BoardGameListComponent } from './boardgame/boardgame-list/boardgame-list.component';

@NgModule({
  declarations: [AppComponent, BoardGameListComponent],
  imports: [BrowserModule, HttpClientModule],
  providers: [provideAnimationsAsync()],
  bootstrap: [AppComponent],
})
export class AppModule {}
