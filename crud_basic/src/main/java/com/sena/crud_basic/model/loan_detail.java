package com.sena.crud_basic.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;



import java.time.LocalDate;

@Entity(name = "loan_detail")
public class loan_detail {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_loan_detail")
    private int id_loan_detail;
      
    @ManyToOne
    @JoinColumn(name = "id_bill")
    private bill_loan id_bill;

    @Column(name = "state", length = 20, nullable = false)
    private String state;
    
    @Column(name="return_date", nullable = false)
    private LocalDate return_date;
    
    @ManyToOne
    @JoinColumn(name = "id_book")
    private book id_book;

    

    public loan_detail(int id_loan_detail, bill_loan id_bill, String state, LocalDate return_date, book id_book){
        this.id_loan_detail=id_loan_detail;
        this.id_bill=id_bill;
        this.state=state;
        this.return_date=return_date;
        this.id_book=id_book;
    }
    public loan_detail(){
        
    }
    public void set_id_loan_detail(int id_loan_detail) {
        this.id_loan_detail = id_loan_detail;
    }
    public int get_id_loan_detail(){
        return id_loan_detail;
    }
    public void set_id_bill(bill_loan id_bill) {
        this.id_bill = id_bill;
        }
    public bill_loan get_id_bill(){
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
    public void set_id_book(book id_book) {
        this.id_book = id_book;
    }
    public book get_id_book(){
        return id_book;
    }
}
