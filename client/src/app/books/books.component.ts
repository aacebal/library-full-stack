import { Component, OnInit } from '@angular/core';
import { BooksService } from '../services/books.service';
import { TransactionsService } from '../services/transactions.service';
import { Router, NavigationExtras } from "@angular/router";
import { Book } from "../models/book.model";
import { DatePipe } from '@angular/common';

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
          "bookPublishDate": book.publishDate,
          "bookCategory": book.category,
          "bookAmount": book.amount,
        }
      };
      this.router.navigate(['/books/add'], navigationExtras);
      this.book = book;
    })
  }

}
