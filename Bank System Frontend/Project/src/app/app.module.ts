import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http'
import { AppComponent } from './app.component';
import { send } from 'process';
import { FormsModule } from '@angular/forms';
import { CreateAccountComponent } from './create-account/create-account.component';
import { DepositAccountComponent } from './deposit-account/deposit-account.component';
import { ExtractAccountComponent } from './extract-account/extract-account.component';

@NgModule({
  declarations: [
    AppComponent,
    CreateAccountComponent,
    DepositAccountComponent,
    ExtractAccountComponent
  ],
  imports: [
    BrowserModule, HttpClientModule, FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { 
  constructor(private http: HttpClientModule) {}
}

