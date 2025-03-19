package com.sena.crud_basic.DTO;
import java.time.LocalDate;
public class bill_loanDTO {

    private int id_bill;
    private int id_user_rol;
    private String state;
    private String code;
    private LocalDate date;

    public bill_loanDTO(int id_bill, String state, String code, LocalDate date, int id_user_rol){
        this.id_bill=id_bill;
        this.state=state;
        this.code=code;
        this.date=date;
        this.id_user_rol=id_user_rol;
    }
   
	public void set_id_bill(int id_bill) {
        this.id_bill = id_bill;
    }
    public int get_id_bill(){
        return id_bill;
    }                                                                                  
    public void set_id_user_rol(int id_user_rol) {
        this.id_user_rol = id_user_rol;
    }
    public int get_id_user_rol(){
        return id_user_rol;
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
