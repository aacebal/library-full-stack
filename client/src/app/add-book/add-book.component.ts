import { Component, OnInit } from '@angular/core';
import { BooksService } from '../services/books.service';
import { TransactionsService } from '../services/transactions.service';
import { Router } from "@angular/router";
import { Book } from "../models/book.model";
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-add-book',
  templateUrl: './add-book.component.html',
  styleUrls: ['./add-book.component.css']
})
export class AddBookComponent implements OnInit {

  book: Book;

  books: Book[];

  formInfo: Object = {
    name: '',
    author: '',
    isbnCode: '',
    publishDate: '',
    category: '',
    amount: ''
  };

  constructor(private booksService: BooksService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit() {}

  addBook() {
    console.log(this.formInfo);
    this.booksService.addBook(this.formInfo)
      .then((allBooks) => {
        this.books = allBooks;
        this.router.navigate(['/']);
      })
  }



}
