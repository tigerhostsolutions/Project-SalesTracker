package org.tigerhost.model;

public class AdminPanel {
    final String appName = "Sales Tracker Application";

    public String getAppName() {
        return appName;
    }

    public void printExitApplicationMessage() {
        System.out.println("Thank you for using the " + getAppName());
    }//end exitMessage()

    public void printInvalidInputErrorMessage() {
        System.out.println("Input not valid. Please try again.");
    }//end inputError()

}//end Admin Panel
