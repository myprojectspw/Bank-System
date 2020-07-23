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
  selector: 'app-transfer-account',
  templateUrl: './transfer-account.component.html',
  styleUrls: ['./transfer-account.component.css']
})
export class TransferAccountComponent implements OnInit {
  @Input() showMePartiallyTransfer: boolean;
  @Output() onDatePickedTransfer: EventEmitter<any> = new EventEmitter<any>();
  constructor(private http: HttpClient) { }
  newMessage={id: 0, to: 0, money: 0, transfer: true};
  messages = Array<Employee>();
  ngOnInit() {
  }

  pickDateTransfer(date: Employee): void {
    this.onDatePickedTransfer.emit(this.newMessage);
  }
}
