import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {Customer} from './shared/models/customer';
import {PartNumberService} from './shared/services/part-number.service';
import {PartNumber} from './shared/models/part-number';
import {CustomerService} from './shared/services/customer.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  title = 'Part Number Generator';

  partNumberForm: FormGroup;
  newPartNumber: PartNumber;
  customers: Customer[];
  customerName: string;
  partNumbers: PartNumber[];

  constructor(
    private fb: FormBuilder,
    private partNumberService: PartNumberService,
    private customerService: CustomerService
  ) {}

  ngOnInit() {
    this.partNumberForm = this.fb.group({
      customerId: ['', Validators.required]
    });
    this.getCustomerList();
  }

  getCustomerList() {

    this.customerService.getCustomers().subscribe(
      data => { this.customers = data; console.log('Customers: ', data); },
      error => console.log('Error getting customers: ', error),
      () => console.log('Done getting customers')
    );
  }

  onSubmit( action: string ) {
    this.customerName = null;
    this.newPartNumber = null;
    this.partNumbers = null;
    const customerId = this.partNumberForm.get('customerId').value;
    const customer =  this.customers.find(function (obj) { return obj.id === +customerId; });
    this.customerName = customer.name;

    if ( action === 'generate' ) {
      this.partNumberService.getNewPartNumber(this.partNumberForm.get('customerId').value).subscribe(
        response => { this.newPartNumber = response; this.partNumberForm.get('customerId').setValue(null); },
        error => console.log('Error getting part number: ', error),
        () => console.log('Done getting part number')
      );
    } else {
      this.partNumberService.getPartNumbersByCustomer(this.partNumberForm.get('customerId').value).subscribe(
        response => { this.partNumbers = response; this.partNumberForm.get('customerId').setValue(null); },
        error => console.log('Error getting part numbers for customer: ', error),
        () => console.log('Done getting part numbers for customer')
      );
    }


  }

}
