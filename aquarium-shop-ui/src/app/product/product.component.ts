import { HttpClient} from '@angular/common/http';
import { Component, Injectable, OnInit } from '@angular/core';
import { PRODUCTS } from './mock-products';
import { Product } from './product';

@Injectable()
@Component({
  selector: 'app-product',
  templateUrl: './product.component.html'
})
export class ProductComponent implements OnInit {

  httpClient: HttpClient;
  products = PRODUCTS;

  constructor(httpClient: HttpClient) {
      this.httpClient = httpClient;
  }

  fetchProducts() {
    this.httpClient.get<Product[]>('http://localhost:8080/products')
    .subscribe(
      (response: Product[]) => {
        this.products = response;
      }
    );
  }

  ngOnInit() {
    this.fetchProducts();
  }

}
