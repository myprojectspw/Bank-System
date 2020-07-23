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
  newMessage={name: "", surname: "", email: ""};
  showAddForm: boolean = false;
  constructor(private http: HttpClient) {}

  toggleChild(){
    this.showAddForm = !this.showAddForm;
}

  ngOnInit(): void {
    this.http.get('/api/emp', {responseType: 'text'}).subscribe(data=>{
      this.time = data as string;
    });
    this.http.get('/api/emp').subscribe((data:Array<Employee>)=>{
      this.messages = data;
    });
  }

  public doSomething(date: any):void {
    this.newMessage = date;
    this.send();
  }

  send() {
    this.http.post('/api/emp', this.newMessage).subscribe((data:Array<Employee>)=>{
      this.messages = data;
    });
  }
}
