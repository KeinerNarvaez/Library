package com.sena.crud_basic.DTO;
import java.time.LocalDate;
import com.sena.crud_basic.model.user_rol;
import com.sena.crud_basic.model.book;
import com.sena.crud_basic.model.bill_loan;

public class loan_detailDTO {
    private int id_loan_detail;
    private bill_loan id_bill;
    private String state;
    private LocalDate return_date;
    private book id_book;
    private user_rol id_user_rol;
    public loan_detailDTO(int id_loan_detail, bill_loan id_bill, String state, LocalDate return_date, book id_book, user_rol id_user_rol){
        this.id_loan_detail=id_loan_detail;
        this.id_bill=id_bill;
        this.state=state;
        this.return_date=return_date;
        this.id_book=id_book;
        this.id_user_rol=id_user_rol;
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
    public void set_id_user_rol(user_rol id_user_rol) {
        this.id_user_rol = id_user_rol;
        }
    public user_rol get_id_user_rol(){
        return id_user_rol;
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
