import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http'
import { AppComponent } from './app.component';
import { send } from 'process';
import { FormsModule } from '@angular/forms';
import { CreateAccountComponent } from './create-account/create-account.component';
import { DepositAccountComponent } from './deposit-account/deposit-account.component';
import { ExtractAccountComponent } from './extract-account/extract-account.component';
import { DeleteAccountComponent } from './delete-account/delete-account.component';
import { TransferAccountComponent } from './transfer-account/transfer-account.component';
import { EditAccountComponent } from './edit-account/edit-account.component';

@NgModule({
  declarations: [
    AppComponent,
    CreateAccountComponent,
    DepositAccountComponent,
    ExtractAccountComponent,
    DeleteAccountComponent,
    TransferAccountComponent,
    EditAccountComponent
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

