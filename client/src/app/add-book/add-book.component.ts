import { Component, OnInit } from '@angular/core';
import { BooksService } from '../services/books.service';
import { TransactionsService } from '../services/transactions.service';
import { Router } from "@angular/router";
import { Book } from "../models/book.model";
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute } from "@angular/router";

@Component({
  selector: 'app-add-book',
  templateUrl: './add-book.component.html',
  styleUrls: ['./add-book.component.css']
})
export class AddBookComponent implements OnInit {

  book: Book;

  books: Book[];

  formInfo: Object = {
    id: '',
    name: '',
    author: '',
    isbnCode: '',
    publishDate: '',
    editedPublishedDate: '',
    issuedBooks: '',
    category: '',
    amount: ''
  };

  constructor(private booksService: BooksService, private router: Router, private route: ActivatedRoute) {
    if (this.route.queryParams != null) {
      this.route.queryParams.subscribe(params => {
        console.log(params);
        this.formInfo = {
          id: params["bookId"],
          name: params["bookName"],
          author: params["bookAuthor"],
          isbnCode: params["bookIsbn"],
          publishDate: params["bookPublishDate"],
          category: params["bookCategory"],
          amount: params["bookAmount"],
          booksIssued: params["booksIssued"]
        }
      })
    }
  }

  ngOnInit() {}

  addBook() {
    this.booksService.addBook(this.formInfo)
      .then((allBooks) => {
        this.books = allBooks;
        this.router.navigate(['/']);
      })
  }



}
