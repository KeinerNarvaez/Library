package com.sena.crud_basic.DTO;
import java.time.LocalDateTime;
public class bill_loanDTO {

    private int id_bill;
    private int id_user;
    private String state;
    private String code;
    private LocalDateTime date;
    private String name_customer;

    public bill_loanDTO(int id_bill, String state, String code, LocalDateTime date, int id_user, String name_customer){
        this.id_bill=id_bill;
        this.state=state;
        this.code=code;
        this.date=date;
        this.id_user=id_user;
        this.name_customer=name_customer;
    }
   
	public void set_id_bill(int id_bill) {
        this.id_bill = id_bill;
    }
    public int get_id_bill(){
        return id_bill;
    }                                                                                  
    public void set_id_user(int id_user) {
        this.id_user = id_user;
    }
    public int get_id_user(){
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
