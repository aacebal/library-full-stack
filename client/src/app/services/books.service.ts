import { Injectable } from '@angular/core';
import { Http, Headers } from '@angular/http';

import 'rxjs/add/operator/toPromise';

@Injectable()
export class BooksService {

  BASE_URL: string = "http://localhost:8080/library/v1"

  constructor(private http: Http) { }

  findAll() {
      return this.http.get(`${this.BASE_URL}/books`,
      { withCredentials: true })
    .toPromise()
    .then(res => res.json())
  }

  addBook(book) {
      return this.http.post(`${this.BASE_URL}/books/add`, book,
      { withCredentials: true })
    .toPromise()
    .then(res => res.json())
  }

  findById(id) {
      return this.http.get(`${this.BASE_URL}/book/${id}`,
      { withCredentials: true })
    .toPromise()
    .then(res => res.json())
  }

  delete(id) {
      return this.http.post(`${this.BASE_URL}/book/delete/${id}`,
      { withCredentials: true })
    .toPromise()
    .then(res => res.json())
  }

  getBook(id) {
      return this.http.get(`${this.BASE_URL}/book/${id}`,
      { withCredentials: true})
    .toPromise()
    .then(res => res.json())
  }

}
