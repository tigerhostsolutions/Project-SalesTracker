package org.tigerhost.model;

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
                2 - Sales Reps
                0 - Exit Application
                """);
        menuSelector = keyboard.nextInt();
    }//end printMainMenu()

    public void printSubMenuOptions(String menuName) {
        System.out.println(menuName + " Menu");
        System.out.println(MessageFormat.format("""
                Select an option:
                1 - Add {0}
                2 - Update {1}
                3 - Remove {2}
                4 - Show All {3}s
                99 - Return to Previous
                0 - Exit Application
                """, menuName, menuName, menuName, menuName));
        subMenuSelector = keyboard.nextInt();
    }//end printSubMenuOptions()

    public void getCustomers() {
        List<Customer> customers = customerDoa.listAll();
        for (Customer c : customers) {
            System.out.println("Customer#: " + c.ctr_number() + ", Customer: " + c.ctr_first_name() + " " + c.ctr_last_name() + ", Phone: " + c.ctr_phone_number() + ", Email: " + c.ctr_email() + ", Balance: " + c.ctr_current_balance());
        }
    }//end getCustomers()

    public void getSalesRep() {
        List<SalesRep> salesReps = salesRepDoa.listAll();
        for (SalesRep sr : salesReps) {
            System.out.println("Rep Id#: " + sr.sales_rep_id() + ", " + "Rep: " + sr.sales_rep_first_name() + " " + sr.sales_rep_last_name() + ", " + "Phone: " + sr.sales_rep_phone_number() + ", " + "Email: " + sr.sales_rep_email());
        }
    }//end getSalesRep()
}// end Menu Class