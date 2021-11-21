package com.bdlz.jdbc;

import java.time.LocalDate;
public class Emloyee {
    public int id;
    public String name;
    public double basic_pay;
    public LocalDate start;

    /*
    Declaring Parametrised Constructor
     */
    public EmpPayRollData(int id,
                               String name,
                               double basic_pay,
                               LocalDate startDate) {
        this.id = id;
        this.name = name;
        this.basic_pay = basic_pay;
        this.start = startDate;
    }
}
