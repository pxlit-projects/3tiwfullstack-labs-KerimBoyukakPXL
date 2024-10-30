import { Routes } from '@angular/router';
import {AddCustomerComponent} from "./core/customers/add-customer/add-customer.component";
import {CustomerListComponent} from "./core/customers/customer-list/customer-list.component";
import {CustomerDetailComponent} from "./core/customers/customer-detail/customer-detail.component";
import {confirmLeaveGuard} from "./confirm-leave.guard";

export const routes: Routes = [
  {path: 'customers', component: CustomerListComponent},
  {path: 'add', component: AddCustomerComponent},
  {path: '', redirectTo: 'customers', pathMatch: 'full'},    // default route, redirect to /customers on startup
  {path: 'customer/:id', component: CustomerDetailComponent},
  {path: 'add', component: AddCustomerComponent, canDeactivate: [confirmLeaveGuard]},


];

