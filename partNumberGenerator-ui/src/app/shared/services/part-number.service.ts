import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Customer} from '../models/customer';
import {PartNumber} from '../models/part-number';
import {environment} from '../../../environments/environment';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type': 'application/json'
  })
};

@Injectable({
  providedIn: 'root'
})
export class PartNumberService {

  apiRoot = environment.apiRoot;

  constructor( private http: HttpClient ) { }

  getNewPartNumber( customerId ) {
    return this.http.post<PartNumber>(this.apiRoot + '/customer/' + customerId + '/partNumber', null, httpOptions );
  }

  getPartNumbersByCustomer( customerId ) {
    return this.http.get<PartNumber[]>( this.apiRoot + '/partNumber?customerID=' + customerId );
  }

}
