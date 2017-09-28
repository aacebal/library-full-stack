import { Routes } from '@angular/router';

import { BooksComponent } from './books/books.component';
import { AddBookComponent } from './add-book/add-book.component';
import { BookDetailsComponent } from './book-details/book-details.component';

export const routes: Routes = [
    { path: '', component: BooksComponent },
    { path: 'books/add', component: AddBookComponent },
    { path: 'book/:id', component: BookDetailsComponent},
    { path: '**', redirectTo: '' }
];
