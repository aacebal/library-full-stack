import { Component, OnInit } from '@angular/core';
import { BooksService } from '../services/books.service';
import { TransactionsService } from '../services/transactions.service';
import { Router, NavigationExtras } from "@angular/router";
import { Book } from "../models/book.model";
import { DatePipe } from '@angular/common';
import * as moment from 'moment';

@Component({
  selector: 'app-books',
  templateUrl: './books.component.html',
  styleUrls: ['./books.component.css']
})
export class BooksComponent implements OnInit {
  book: Book;
  books: Book[];

  constructor(private booksService: BooksService, private router: Router) { }

  ngOnInit() {
    this.booksService.findAll()
    .then((allBooks) => {
      console.log(allBooks);
      this.books = allBooks;
    });
  }

  edit(id) {
    this.booksService.findById(id)
    .then((book) => {
      let navigationExtras: NavigationExtras = {
        queryParams: {
          "bookId": book.id,
          "bookName": book.name,
          "bookAuthor": book.author,
          "bookIsbn": book.isbnCode,
          "bookPublishDate": moment(book.publishDate).format('YYYY-MM-DD'),
          "bookCategory": book.category,
          "bookAmount": book.amount,
          "booksIssued": book.booksIssued
        }
      };
      this.router.navigate(['/books/add'], navigationExtras);
      this.book = book;
    })
  }

  delete(id) {
    this.booksService.delete(id)
    .then((allBooks) => {
      this.books = allBooks;
    })
  }

}
