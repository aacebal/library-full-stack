import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { routes } from './app.routing';
import { RouterModule } from "@angular/router";
import { HttpModule } from '@angular/http';
import { FormsModule } from '@angular/forms';

import { BooksService } from './services/books.service';
import { TransactionsService } from './services/transactions.service';

import { AppComponent } from './app.component';
import { BooksComponent } from './books/books.component';
import { AddBookComponent } from './add-book/add-book.component';

@NgModule({
  declarations: [
    AppComponent,
    BooksComponent,
    AddBookComponent
  ],
  imports: [
    BrowserModule,
    HttpModule,
    FormsModule,
    RouterModule.forRoot(routes)
  ],
  providers: [BooksService, TransactionsService],
  bootstrap: [AppComponent]
})
export class AppModule { }
