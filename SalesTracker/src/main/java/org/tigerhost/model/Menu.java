package org.tigerhost.model;

import org.tigerhost.AdminPanel;
import org.tigerhost.dao.MenuInterface;

import java.text.MessageFormat;
import java.util.List;

public class Menu extends AdminPanel implements MenuInterface {
    protected String menuName;
    protected int menuSelector = 10;//variable mutates within scope
    protected int subMenuSelector;

    public void printMainMenu() {
        System.out.println("""
                Select an option:
                1 - Customers
                2 - Products
                3 - Sales Reps
                0 - Exit Application
                """);
        menuSelector = keyboard.nextInt();
    }//end printMainMenu()

    public void printSubMenuOptions(String menuName) {
        System.out.println(menuName + " Menu");
        System.out.println(
                MessageFormat.format("""
                        Select an option:
                        1 - Add {0}
                        2 - Remove {1}
                        3 - Show All {2}s
                        0 - Exit Application
                        """, menuName, menuName, menuName));
        subMenuSelector = keyboard.nextInt();
    }//end printSubMenuOptions()

    public void printExitApplicationMessage() {
        System.out.println("Thank you for using the " + getAppName());
    }//end exitMessage()

    public void printInvalidInputErrorMessage() {
        System.out.println("Input not valid. Please try again.");
    }//end inputError()

    public void getProducts() {
        List<Product> products = productDoa.listAll();
        for (Product p : products) {
            System.out.println(
                    "Product#: " + p.product_number() + ", Product: " + p.product_name()
                    + ", Description: " + p.product_description() + ", Category: "
                    + p.product_category() + ", Price: " + p.product_price());
        }
    }//getProducts()

    public void getCustomers() {
        List<Customer> customers = customerDoa.listAll();
        for (Customer c : customers) {
            System.out.println(
                    "Customer#: " + c.ctr_number() + ", Customer: " + c.ctr_first_name() + " "
                    + c.ctr_last_name() + ", Phone: " + c.ctr_phone_number() + ", Email: " + c.ctr_email()
                    + ", Balance: " + c.ctr_current_balance());
        }
    }//end getCustomers()

    public void getSalesRep() {
        List<SalesRep> salesReps = salesRepDoa.listAll();
        for (SalesRep sr : salesReps) {
            System.out.println(
                    "Rep Id#: " + sr.sales_rep_id() + ", " + "Rep: " + sr.sales_rep_first_name() + " "
                    + sr.sales_rep_last_name() + ", " + "Phone: " + sr.sales_rep_phone_number() + ", "
                    + "Email: " + sr.sales_rep_email());
        }
    }//end getSalesRep()
}// end Menu Class