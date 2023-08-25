package org.tigerhost.model;

import java.util.InputMismatchException;

public class ProductMenu extends Menu {

    public void productMenu(int menuSelector) {
        switch (menuSelector) {
            case 0 -> {
                printExitApplicationMessage();
                System.exit(0);
            }
            case 1 -> {
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
                } catch (InputMismatchException e) {
                    printInvalidInputErrorMessage();
                }//end try-catch
            }
            case 2 -> {
                try {
                    log.warn("User is attempting to delete product");
                    System.out.println("Remove product from database");
                    getProducts();
                    System.out.println("Enter the product number to be deleted: ");
                    int product_number = keyboard.nextInt();
                    keyboard.nextLine();
                    productDoa.delete(product_number);
                } catch (InputMismatchException e) {
                    printInvalidInputErrorMessage();
                }//end try-catch
            }
            case 3 -> {
                try {
                    System.out.println("Preparing to display all products...\n");
                    getProducts();
                    System.out.println("\n---- End of products list ----");// line break
                } catch (InputMismatchException e) {
                    printInvalidInputErrorMessage();
                }//end try-catch
            }
            default -> printInvalidInputErrorMessage();
        }// end switch
    }// end productMenu()
}//end ProductMenu Class
