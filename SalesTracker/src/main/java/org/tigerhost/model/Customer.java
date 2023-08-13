package org.tigerhost.model;

public record Customer(int ctr_number, String ctr_first_name,
                       String ctr_last_name, String ctr_phone_number,
                       String ctr_email, double ctr_current_balance,
                       int sales_rep_id) {

    @Override
    public int ctr_number() {
        return ctr_number;
    }

    @Override
    public String ctr_first_name() {
        return ctr_first_name;
    }

    @Override
    public String ctr_last_name() {
        return ctr_last_name;
    }

    @Override
    public String ctr_phone_number() {
        return ctr_phone_number;
    }

    @Override
    public String ctr_email() {
        return ctr_email;
    }

    @Override
    public double ctr_current_balance() {
        return ctr_current_balance;
    }

    @Override
    public int sales_rep_id() {
        return sales_rep_id;
    }
}//end record Customer
