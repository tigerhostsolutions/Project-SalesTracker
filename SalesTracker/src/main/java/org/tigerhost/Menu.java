package org.tigerhost;

import org.tigerhost.dao.MenuInterface;
import org.tigerhost.model.Customer;
import org.tigerhost.model.Product;
import org.tigerhost.model.SalesRep;

import java.util.InputMismatchException;
import java.util.List;

public class Menu implements MenuInterface {
    public void mainMenu() {
        int menuInput = 1;
        System.out.println("Sales Tracker Application");
        do {
            try {
                System.out.println("Select an option: ");
                System.out.println("1 - Products");
                System.out.println("2 - Customers");
                System.out.println("3 - Sales Reps");
                System.out.println("0 - Exit");
                menuInput = keyboard.nextInt();
                switch (menuInput) {
                    case 0 -> {
                        System.out.println("System Exit");
                        System.exit(0);
                    }
                    case 1 -> {
                        System.out.println("---------------------");
                        System.out.println("Product Menu");
                        System.out.println("Select an option:");
                        System.out.println("0 - Exit");
                        System.out.println("1 - Add Product");
                        System.out.println("2 - Remove Product");
                        System.out.println("3 - Show All Products");
                        System.out.println("----------------------\n");
                        int menuInput2 = keyboard.nextInt();
                        productMenu(menuInput2);
                    }
                    case 2 -> {
                        System.out.println("---------------------");
                        System.out.println("Customer Menu");
                        System.out.println("Select an option:");
                        System.out.println("0 - Exit");
                        System.out.println("1 - Add Customer");
                        System.out.println("2 - Remove Customer");
                        System.out.println("3 - Show All Customer");
                        System.out.println("----------------------\n");
                        int menuInput2 = keyboard.nextInt();
                        customerMenu(menuInput2);
                    }
                    case 3 -> {
                        System.out.println("---------------------");
                        System.out.println("Sales Representative Menu");
                        System.out.println("Customer Menu");
                        System.out.println("Select an option:");
                        System.out.println("0 - Exit");
                        System.out.println("1 - Add Sales Rep");
                        System.out.println("2 - Remove Sales Rep");
                        System.out.println("3 - Show All Sales Reps");
                        System.out.println("----------------------\n");
                        int menuInput2 = keyboard.nextInt();
                        salesRepMenu(menuInput2);
                    }
                    default -> {
                        System.out.println("Select a valid option. Please Try again");
                    }
                }// end switch
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input: Please input a correct selection.");
            }//end try-catch
            // end do-while
        } while (menuInput != 0);
    }// end mainMenu()

    public void customerMenu(int menuInput2) {
        switch (menuInput2) {
            case 0: {
                System.out.println("Good-bye! Thank you for using the application");
                System.exit(0);
                break;
            }
            case 1: {
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

                //Create new Customer object to add to customer list.
                Customer newCustomer = new Customer(cus_number, cus_first_name, cus_last_name, cus_phone_number, cus_email,
                        cus_current_balance, sales_rep_id);
                customerDoa.add(newCustomer);
                break;
            }
            case 2: {
                log.warn("User is attempting to delete customer");
                System.out.println("Remove Customer from database");
                getCustomers();
                System.out.println("Enter the customer number to be deleted: ");
                int cus_num = keyboard.nextInt();
                keyboard.nextLine();
                customerDoa.delete(cus_num);
                break;
            }
            case 3: {
                System.out.println("Preparing to display all customers...\n");
                getCustomers();
                System.out.println("\n---- End of customer list ----");// line break
                break;
            }
            default: {
                System.out.println("Select a valid option. Please Try again");
                break;
            }
        }// end switch
    }// end customerMenu

    public void salesRepMenu(int menuInput2) {
        switch (menuInput2) {
            case 0: {
                System.out.println("System Exit");
                System.exit(0);
                break;
            }
            case 1: {
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
                break;
            }
            case 2: {
                log.warn("User is attempting to delete sales rep");
                System.out.println("Remove sales rep from database");
                getSalesRep();
                System.out.println("Enter the sales rep id to be deleted: ");
                int sales_rep_id = keyboard.nextInt();
                keyboard.nextLine();
                salesRepDoa.delete(sales_rep_id);
                break;
            }
            case 3: {
                System.out.println("Preparing to display all sales reps...\n");
                getSalesRep();
                System.out.println("\n---- End of sales rep list ----");// line break
                break;
            }
            default: {
                System.out.println("Select a valid option. Please Try again");
                break;
            }
        }// end switch
    }// end customerMenu

    public void productMenu(int menuInput2) {
        switch (menuInput2) {
            case 0: {
                System.out.println("System Exit");
                System.exit(0);
                break;
            }
            case 1: {

                try {
                    System.out.println("Add Product to database");
                    System.out.println("Enter the 8-Digit Product Number: ");
                    int product_number = keyboard.nextInt();
                    keyboard.nextLine();
                    System.out.println("Enter Product Name: ");
                    String product_name = keyboard.nextLine();
                    System.out.println("Enter Product Description: ");
                    String product_description = keyboard.nextLine();
                    System.out.println("Enter Product Category: ");
                    String product_category = keyboard.nextLine();
                    System.out.println("Enter Product Price: ");
                    double product_price = keyboard.nextDouble();
                    Product products = new Product(product_number, product_name, product_description, product_category, product_price);
                    productDoa.add(products);
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please try again.");
                    keyboard.nextLine();
                }//end try-catch

            }//end case 1
            case 2: {
                log.warn("User is attempting to delete product");
                System.out.println("Remove product from database");
                getProducts();
                System.out.println("Enter the product number to be deleted: ");
                int product_number = keyboard.nextInt();
                keyboard.nextLine();
                productDoa.delete(product_number);
                break;
            }
            case 3: {
                System.out.println("Preparing to display all products...\n");
                getProducts();
                System.out.println("\n---- End of products list ----");// line break
                break;
            }
            default: {
                System.out.println("Select a valid option. Please Try again");
                break;
            }
        }// end switch
    }// end customerMenu

    public void getProducts() {
        List<Product> products = productDoa.listAll();
        for (Product p : products) {
            System.out.println(
                    "Product#: " + p.getProduct_number() + ", Product: " + p.getProduct_name()
                    + ", Description: " + p.getProduct_description() + ", Category: "
                    + p.getProduct_category() + ", Price: " + p.getProduct_price());
        }
    }//getProducts()

    public void getCustomers() {
        List<Customer> customers = customerDoa.listAll();
        for (Customer c : customers) {
            System.out.println(
                    "Customer#: " + c.getCtr_number() + ", Customer: " + c.getCtr_first_name() + " "
                    + c.getCtr_last_name() + ", Phone: " + c.getCtr_phone_number() + ", Email: " + c.getCtr_email()
                    + ", Balance: " + c.getCtr_current_balance());
        }
    }//end getCustomers()

    public void getSalesRep() {
        List<SalesRep> salesReps = salesRepDoa.listAll();
        for (SalesRep sr : salesReps) {
            System.out.println(
                    "Rep Id#: " + sr.getSales_rep_id() + ", " + "Rep: " + sr.getSales_rep_first_name() + " "
                    + sr.getSales_rep_last_name() + ", " + "Phone: " + sr.getSales_rep_phone_number() + ", "
                    + "Email: " + sr.getSales_rep_email());
        }
    }//end getSalesRep()
}// end Class