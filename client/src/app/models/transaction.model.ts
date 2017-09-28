import { Book } from './book.model';

export class Transaction {
  id: string;
  issueDate: Date;
  returnDate: Date;
  type: {
        Issue, Return
  };
  book: Book;
}
