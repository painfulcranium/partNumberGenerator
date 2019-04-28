import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Customer} from '../models/customer';
import {environment} from '../../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  apiRoot = environment.apiRoot;

  constructor( private http: HttpClient ) { }

  getCustomers() {
    return this.http.get<Customer[]>(this.apiRoot + '/customer');
  }

}
