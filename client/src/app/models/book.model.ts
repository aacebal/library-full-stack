import { Transaction } from './transaction.model';

export class Book {
  id: string;
  name: string;
  author: string;
  isbnCode: string;
  publishDate: Date;
  category: string;
  amount: number;
  issuedBooks: number;
  transactions: Transaction[];
}
