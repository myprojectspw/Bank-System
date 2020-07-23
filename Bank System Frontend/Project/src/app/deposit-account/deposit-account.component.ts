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
  selector: 'app-deposit-account',
  templateUrl: './deposit-account.component.html',
  styleUrls: ['./deposit-account.component.css']
})
export class DepositAccountComponent implements OnInit {
  @Input() showMePartiallyDeposit: boolean;
  @Output() onDatePickedDeposit: EventEmitter<any> = new EventEmitter<any>();
  constructor(private http: HttpClient) { }
  newMessage={id: 0, money: 0, deposit: true};
  messages = Array<Employee>();
  ngOnInit() {
  }

  pickDateDeposit(date: Employee): void {
    this.onDatePickedDeposit.emit(this.newMessage);
  }
}
