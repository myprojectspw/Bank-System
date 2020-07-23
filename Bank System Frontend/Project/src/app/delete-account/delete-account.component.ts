import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { HttpClient } from '@angular/common/http';

interface Employee {
  id: number;
  name: string;
  surname: string;
  email: string;
  money: number;
}

@Component({
  selector: 'app-delete-account',
  templateUrl: './delete-account.component.html',
  styleUrls: ['./delete-account.component.css']
})
export class DeleteAccountComponent implements OnInit {
  @Input() showMePartiallyDelete: boolean;
  @Output() onDatePickedDelete: EventEmitter<any> = new EventEmitter<any>();
  constructor(private http: HttpClient) { }
  newMessage={id: 0};
  messages = Array<Employee>();
  ngOnInit() {
  }

  pickDateDelete(date: Employee): void {
    this.onDatePickedDelete.emit(this.newMessage);
  }
}
