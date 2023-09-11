package org.tigerhost.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.tigerhost.model.Menu;

import java.util.Scanner;

public interface MenuInterface {
    CustomerDoa customerDoa = new CustomerDoa();
    SalesRepDoa salesRepDoa = new SalesRepDoa();
    Scanner keyboard = new Scanner(System.in);
    Logger log = LogManager.getLogger(Menu.class);

    void getCustomers();
    void getSalesRep();

}//end MenuInterface
