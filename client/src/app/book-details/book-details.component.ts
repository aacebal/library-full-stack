import { Component, OnInit } from '@angular/core';
import { BooksService } from '../services/books.service';
import { TransactionsService } from '../services/transactions.service';
import { Router, NavigationExtras } from "@angular/router";
import { Book } from "../models/book.model";
import { ActivatedRoute } from "@angular/router";

@Component({
  selector: 'app-book-details',
  templateUrl: './book-details.component.html',
  styleUrls: ['./book-details.component.css']
})
export class BookDetailsComponent implements OnInit {

  book: Book;

  constructor(private booksService: BooksService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit() {
    this.route.params
      .subscribe((params) => {
        this.booksService.getBook(params.id)
        .then((book) => {
          this.book = book;
        })
      })
  }

}
