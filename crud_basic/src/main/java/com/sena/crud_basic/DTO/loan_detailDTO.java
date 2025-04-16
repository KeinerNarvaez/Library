package com.sena.crud_basic.DTO;
import java.time.LocalDateTime;

public class loan_detailDTO {
    private int id_loan_detail;
    private int id_bill;
    private String state;
    private LocalDateTime return_date;
    private int id_book;

    public loan_detailDTO(int id_loan_detail, int id_bill, String state, LocalDateTime return_date, int id_book){
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
    public void set_return_date(LocalDateTime return_date) {
        this.return_date = return_date;
    }
    public LocalDateTime get_return_date(){
        return return_date;
    }
    public void set_id_book(int id_book) {
        this.id_book = id_book;
    }
    public int get_id_book(){
        return id_book;
    }
}
