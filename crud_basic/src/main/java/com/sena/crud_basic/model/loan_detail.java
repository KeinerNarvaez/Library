package com.sena.crud_basic.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;

@Entity(name = "loan_detail")
public class loan_detail {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_loan_detail")
    private int id_loan_detail;
      
    @Column(name="id_bill", nullable = false)
    private int id_bill;

    @Column(name = "state", length = 20, nullable = false)
    private String state;
    
    @Column(name="return_date", nullable = false)
    private LocalDate return_date;
    
    @Column(name="id_book" ,nullable = false)
    private String id_book;

    public loan_detail(int id_loan_detail, int id_bill, String state, LocalDate return_date, String id_book){
        this.id_loan_detail=id_loan_detail;
        this.id_bill=id_bill;
        this.state=state;
        this.return_date=return_date;
        this.id_book=id_book;
    }
    public void set_id_loan_detail(int id_loan_detail) {
        this.id_loan_detail = id_loan_detail;
    }
    public int get_id_loan_detail(){
        return id_loan_detail;
    }
    public void set_id_bill(int id_bill) {
        this.id_bill = id_bill;
    }
    public int get_id_bill(){
        return id_bill;
    }
    public void set_state(String state) {
        this.state = state;
    }
    public String get_state(){
        return state;
    }
    public void set_return_date(LocalDate return_date) {
        this.return_date = return_date;
    }
    public LocalDate get_return_date(){
        return return_date;
    }
    public void set_id_book(String id_book) {
        this.id_book = id_book;
    }
    public String get_id_book(){
        return id_book;
    }
}
