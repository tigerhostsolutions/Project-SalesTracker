package org.tigerhost.model;

import java.util.InputMismatchException;

public class MainMenu extends Menu {
    protected CustomerMenu cm = new CustomerMenu();
    protected ProductMenu pm = new ProductMenu();
    protected SalesRepMenu srm = new SalesRepMenu();
    public void mainMenu() {
        do{
            try {
                System.out.println(getAppName());
                printMainMenu();
                switch (menuSelector) {
                    case 0 -> {
                        printExitApplicationMessage();
                        System.exit(0);
                    }
                    case 1 -> {
                        menuName = "Customer";
                        printSubMenuOptions(menuName);
                        cm.customerMenu(subMenuSelector);
                    }
                    case 2 -> {
                        menuName = "Product";
                        printSubMenuOptions(menuName);
                        pm.productMenu(subMenuSelector);
                    }
                    case 3 -> {
                        menuName = "Sales Rep";
                        printSubMenuOptions(menuName);
                        srm.salesRepMenu(subMenuSelector);
                    }
                    default -> printInvalidInputErrorMessage();
                }// end switch
            } catch (InputMismatchException e) {
               printInvalidInputErrorMessage();
            }//end try-catch
        } while (menuSelector != 0);// end do-while
    }// end mainMenu()
}//end MainMenu Class
