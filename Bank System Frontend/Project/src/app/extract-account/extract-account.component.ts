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
  selector: 'app-extract-account',
  templateUrl: './extract-account.component.html',
  styleUrls: ['./extract-account.component.css']
})

export class ExtractAccountComponent implements OnInit {
  @Input() showMePartiallyExtract: boolean;
  @Output() onDatePickedExtract: EventEmitter<any> = new EventEmitter<any>();
  constructor(private http: HttpClient) { }
  newMessage={id: 0, money: 0, extract: true};
  messages = Array<Employee>();
  ngOnInit() {
  }

  pickDateExtract(date: Employee): void {
    this.onDatePickedExtract.emit(this.newMessage);
  }
}
