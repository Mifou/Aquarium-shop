import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { ProductComponent } from './product/product.component';
import { MainPageComponent } from './main-page/main-page.component'
import { HttpClientModule } from '@angular/common/http';

const routes = [
  { path: 'products', component: ProductComponent }
];

@NgModule({
  declarations: [
    AppComponent,
    ProductComponent,
    MainPageComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes),
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
