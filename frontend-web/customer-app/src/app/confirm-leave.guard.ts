import { CanDeactivateFn } from '@angular/router';
import { AddCustomerComponent } from './core/customers/add-customer/add-customer.component';

export const confirmLeaveGuard: CanDeactivateFn<AddCustomerComponent> = (component, currentRoute, currentState, nextState) => {
  if(component.customerForm.dirty){
    return window.confirm("Are you sure you want to leave this page?");
  }else{
    return true;
  }
};

// This code defines a CanDeactivate function that will check if the customerForm on the AddCustomerComponent is "dirty"
// (i.e., the form has unsaved changes). If the form has been modified but not submitted,
// it will display a confirmation dialog asking the user if they're sure they want to leave the page.
// If they confirm, the navigation proceeds; otherwise, they remain on the current page.
// If the form is not dirty (meaning no changes have been made), navigation occurs without the confirmation.
