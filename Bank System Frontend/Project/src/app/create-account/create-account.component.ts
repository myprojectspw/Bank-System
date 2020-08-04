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
  selector: 'app-create-account',
  templateUrl: './create-account.component.html',
  styleUrls: ['./create-account.component.css']
})
export class CreateAccountComponent implements OnInit {
  @Input() showMePartially: boolean;
  @Output() onDatePicked: EventEmitter<any> = new EventEmitter<any>();
  constructor(private http: HttpClient) { }
  newMessage={id: 0, name: "", surname: "", email: ""};
  messages = Array<Employee>();
  ngOnInit() {
  }

  pickDate(date: Employee): void {
    this.onDatePicked.emit(this.newMessage);
  }
}
