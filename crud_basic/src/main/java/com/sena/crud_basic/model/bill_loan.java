package com.sena.crud_basic.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


import java.time.LocalDate;



@Entity(name="bill_loan")
public class bill_loan {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_bill", nullable = false)
    private int id_bill;


    @Column(name="id_customer" ,nullable = false)
    private int id_customer;
    
    @Column(name="state", length = 20, nullable = false)
    private String state;

    @Column(name="code", length = 20, nullable = false)
    private String code;

    @Column(name="date", nullable = false)
    private LocalDate date;

    public bill_loan(int id_bill, String state, String code, LocalDate date ){
        this.id_bill=id_bill;
        this.state=state;
        this.code=code;
        this.date=date;
    }
    public void set_id_bill(int id_bill) {
        this.id_bill = id_bill;
    }
    public int get_id_bill(){
        return id_bill;
    }                                                                                                               
    public void set_id_customer(int id_customer) {
        this.id_customer = id_customer;
    }
    public int get_id_customer(){
        return id_customer;
    }
    public void set_state(String state) {
        this.state = state;
    }
    public String get_state(){
        return state;
    }
    public void set_code(String code) {
        this.code = code;
    }
    public String get_code(){
        return code;
    }
    public void set_date(LocalDate date) {
        this.date = date;
    }
    public LocalDate get_date(){
        return date;
    }

}
