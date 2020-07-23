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
  selector: 'app-edit-account',
  templateUrl: './edit-account.component.html',
  styleUrls: ['./edit-account.component.css']
})
export class EditAccountComponent implements OnInit {
  @Input() showMePartiallyEdit: boolean;
  @Output() onDatePickedEdit: EventEmitter<any> = new EventEmitter<any>();
  constructor(private http: HttpClient) { }
  newMessage={id: 0, name: "", surname: "", email: ""};
  messages = Array<Employee>();
  ngOnInit() {
  }

  pickDateEdit(date: Employee): void {
    this.onDatePickedEdit.emit(this.newMessage);
  }
}
