import { Injectable } from '@angular/core';
import { Http, Headers } from '@angular/http';

import 'rxjs/add/operator/toPromise';

@Injectable()
export class TransactionsService {

  BASE_URL: string = "http://localhost:8080/library/v1"

  constructor(private http: Http) { }

  getTransactions(id) {
    return this.http.get(`${this.BASE_URL}/transactions/${id}`,
    { withCredentials: true })
      .toPromise()
      .then(res => res.json())
  }
}
