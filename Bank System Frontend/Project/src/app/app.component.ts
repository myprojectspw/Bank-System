import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { send } from 'process';


interface Employee {
  id: number;
  name: string;
  surname: string;
  email: string;
  money: number;
}

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  time = 'xyz';
  messages = Array<Employee>();
  headElements = ['ID', 'Name', 'Surname', 'Email', 'Konto'];
  newMessage={id: 0, name: "", surname: "", email: ""};
  showAddForm: boolean = false;
  showDepositForm: boolean = false;
  showExtractForm: boolean = false;
  showDeleteForm: boolean = false;
  showTransferForm: boolean = false;
  showEditForm: boolean = false;
  constructor(private http: HttpClient) {}

  toggleChild(){
    this.showAddForm = !this.showAddForm;
    this.showDepositForm = false;
    this.showExtractForm = false;
    this.showDeleteForm = false;
    this.showTransferForm = false;
    this.showEditForm = false;
  }
  toggleDeposit(){
    this.showDepositForm = !this.showDepositForm;
    this.showAddForm = false;
    this.showExtractForm = false;
    this.showDeleteForm = false;
    this.showTransferForm = false;
    this.showEditForm = false;
  }
  toggleExtract(){
    this.showExtractForm = !this.showExtractForm;
    this.showAddForm = false;
    this.showDepositForm = false;
    this.showDeleteForm = false;
    this.showTransferForm = false;
    this.showEditForm = false;
  }
  toggleDelete(){
    this.showDeleteForm = !this.showDeleteForm;
    this.showExtractForm = false;
    this.showAddForm = false;
    this.showDepositForm = false;
    this.showTransferForm = false;
    this.showEditForm = false;
  }
  toggleTransfer(){
    this.showTransferForm = !this.showTransferForm;
    this.showDeleteForm = false;
    this.showExtractForm = false;
    this.showAddForm = false;
    this.showDepositForm = false;
    this.showEditForm = false;
  }
  toggleEdit(){
    this.showEditForm = !this.showEditForm;
    this.showTransferForm = false;
    this.showDeleteForm = false;
    this.showExtractForm = false;
    this.showAddForm = false;
    this.showDepositForm = false;
  }

  ngOnInit(): void {
    this.http.get('/api/emp', {responseType: 'text'}).subscribe(data=>{
      this.time = data as string;
    });
    this.http.get('/api/emp').subscribe((data:Array<Employee>)=>{
      this.messages = data;
    });
  }

  send() {
    this.http.post('/api/emp', this.newMessage).subscribe((data:Array<Employee>)=>{
      this.messages = data;
    });
  }

  update() {
    this.http.put('/api/emp/' + this.newMessage.id, this.newMessage).subscribe((data:Array<Employee>)=>{
      this.messages = data;
    });
  }

  delete() {
    this.http.delete('/api/emp/' + this.newMessage.id).subscribe((data:Array<Employee>)=>{
      this.messages = data;
    });

  }

  createAccount(date: any):void {
    this.newMessage = date;
    this.send();
  }

  depositAccount(date: any):void {
    this.newMessage = date;
    this.update();
  }

  extractAccount(date: any):void {
    this.newMessage = date;
    this.update();
  }

  deleteAccount(date: any):void {
    this.newMessage = date;
    this.delete();
  }

  transferAccount(date: any):void {
    this.newMessage = date;
    this.update();
  }

  editAccount(date: any):void {
    this.newMessage = date;
    this.update();
  }

  
}
