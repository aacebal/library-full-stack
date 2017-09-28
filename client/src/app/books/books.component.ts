import { Component, OnInit } from '@angular/core';
import { BooksService } from '../services/books.service';
import { TransactionsService } from '../services/transactions.service';
import { Router } from "@angular/router";
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
      console.log(book);
      this.router.navigate(['/books/add'], book);
      this.book = book;
    })
  }

}
