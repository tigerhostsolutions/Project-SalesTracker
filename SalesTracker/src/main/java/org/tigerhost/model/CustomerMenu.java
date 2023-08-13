package org.tigerhost.model;

import java.util.InputMismatchException;

public class CustomerMenu extends Menu {

    public void customerMenu(int subMenuSelector) {
        switch (subMenuSelector) {
            case 0 -> {
                try {
                    printExitApplicationMessage();
                    System.exit(0);
                } catch (InputMismatchException e) {
                    printInvalidInputErrorMessage();
                }//end try-catch
            }
            case 1 -> {
                try {
                    System.out.println("Add Customer to database");
                    System.out.println("Enter the 6-Digit Customer Id: ");
                    int cus_number = keyboard.nextInt();
                    keyboard.nextLine();
                    System.out.println("Enter Customer's First Name: ");
                    String cus_first_name = keyboard.nextLine();
                    System.out.println("Enter Customer's Last Name: ");
                    String cus_last_name = keyboard.nextLine();
                    System.out.println("Enter Customer's Phone Number: ");
                    String cus_phone_number = keyboard.nextLine();
                    System.out.println("Enter Customer's Email: ");
                    String cus_email = keyboard.nextLine();
                    System.out.println("Enter Customer's Current Balance: ");
                    double cus_current_balance = keyboard.nextDouble();
                    System.out.println("Enter the 4-Digit Sales Rep Id#: ");
                    getSalesRep();
                    int sales_rep_id = keyboard.nextInt();
                    Customer newCustomer = new Customer(cus_number, cus_first_name, cus_last_name, cus_phone_number, cus_email,
                            cus_current_balance, sales_rep_id);
                    customerDoa.add(newCustomer);
                } catch (InputMismatchException e) {
                    printInvalidInputErrorMessage();
                }//end try-catch
            }
            case 2 -> {
                try {
                    log.warn("User is attempting to delete customer");
                    System.out.println("Remove Customer from database");
                    getCustomers();
                    System.out.println("Enter the customer number to be deleted: ");
                    int cus_num = keyboard.nextInt();
                    keyboard.nextLine();
                    customerDoa.delete(cus_num);
                } catch (InputMismatchException e) {
                    printInvalidInputErrorMessage();
                }//end try-catch
            }
            case 3 -> {
                try {
                    System.out.println("Preparing to display all customers...\n");
                    getCustomers();
                    System.out.println("\n---- End of customer list ----");// line break
                } catch (InputMismatchException e) {
                    printInvalidInputErrorMessage();
                }//end try-catch
            }
            default -> printInvalidInputErrorMessage();
        }// end switch
    }// end customerMenu()
}//end CustomerMenu Class
