package com.sena.crud_basic.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

import java.time.LocalDateTime;



@Entity(name="bill_loan")
public class bill_loan {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_bill", nullable = false)
    private int id_bill;


    @ManyToOne
    @JoinColumn(name = "id_user")
    private user id_user;
    
    @Column(name="state", length = 20, nullable = false)
    private String state;

    @Column(name="code", length = 20, nullable = false)
    private String code;

    @Column(name="date", nullable = false)
    private LocalDateTime date;

    @Column(name="name_customer",length = 100, nullable = false)
    private String name_customer;

    public bill_loan(int id_bill, String state, String code, LocalDateTime date, user id_user, String name_customer){
        this.id_bill=id_bill;
        this.state=state;
        this.code=code;
        this.date=date;
        this.id_user=id_user;
        this.name_customer=name_customer;
    }
    public bill_loan(){
    }
    public void set_id_bill(int id_bill) {
        this.id_bill = id_bill;
    }
    public int get_id_bill(){
        return id_bill;
    }                                                                                                   
    public void set_id_user(user id_user) {
        this.id_user = id_user;
    }
    public user get_id_user(){
        return id_user;
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
    public void set_date(LocalDateTime date) {
        this.date = date;
    }
    public LocalDateTime get_date(){
        return date;
    }
    public void set_name_customer(String name_customer) {
        this.name_customer = name_customer;
    }
    public String get_name_customer(){
        return name_customer;
    }

}
