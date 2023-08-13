package org.tigerhost.model;

import java.util.InputMismatchException;

public class SalesRepMenu extends Menu {

    public void salesRepMenu(int menuSelector) {
        switch (menuSelector) {
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
                    System.out.println("Add Sales Rep to database");
                    System.out.println("Enter the 4-Digit Sales Rep Id#: ");
                    int sales_rep_id = keyboard.nextInt();
                    keyboard.nextLine();
                    System.out.println("Enter Sales Rep's First Name: ");
                    String sales_rep_first_name = keyboard.nextLine();
                    System.out.println("Enter Sales Rep's Last Name: ");
                    String sales_rep_last_name = keyboard.nextLine();
                    System.out.println("Enter Sales Rep's Phone Number: ");
                    String sales_rep_phone_number = keyboard.nextLine();
                    System.out.println("Enter Sales Rep's Email: ");
                    String sales_rep_email = keyboard.nextLine();
                    SalesRep newSalesRep = new SalesRep(sales_rep_id, sales_rep_first_name, sales_rep_last_name,
                            sales_rep_phone_number, sales_rep_email);
                    salesRepDoa.add(newSalesRep);
                } catch (InputMismatchException e) {
                    printInvalidInputErrorMessage();
                }//end try-catch
            }
            case 2 -> {
                try {
                    log.warn("User is attempting to delete sales rep");
                    System.out.println("Remove sales rep from database");
                    getSalesRep();
                    System.out.println("Enter the sales rep id to be deleted: ");
                    int sales_rep_id = keyboard.nextInt();
                    keyboard.nextLine();
                    salesRepDoa.delete(sales_rep_id);
                } catch (InputMismatchException e) {
                    printInvalidInputErrorMessage();
                }//end try-catch
            }
            case 3 -> {
                try {
                    System.out.println("Preparing to display all sales reps...\n");
                    getSalesRep();
                    System.out.println("\n---- End of sales rep list ----");// line break
                } catch (InputMismatchException e) {
                    printInvalidInputErrorMessage();
                }//end try-catch
            }
            default -> printInvalidInputErrorMessage();
        }// end switch
    }// end salesRepMenu()
}//end SalesRepMenu Class
