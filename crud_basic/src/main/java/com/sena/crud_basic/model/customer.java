package com.sena.crud_basic.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity(name="customer")
public class customer {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_customer", nullable = false)
    private int id_customer;
    
    @Column(name="name_customer", length = 30, nullable = false)
    private String name_customer;

    @Column(name="address", length = 20, nullable = false)
    private String address;

    @Column(name="dni", nullable = false)
    private int dni;

    @Column(name="number", nullable = false)
    private int number;

    @Column(name="email",length=50, nullable = false)
    private int email;

    public customer(int id_customer, String name_customer, String address, int dni, int number, int email){
        this.id_customer=id_customer;
        this.name_customer=name_customer;
        this.address=address;
        this.dni=dni;
        this.number=number;
        this.email=email;
    }
    public void set_id_customer(int id_customer) {
        this.id_customer = id_customer;
    }
    public int get_id_customer(){
        return id_customer;
    }
    public void set_name_customer(String name_customer) {
        this.name_customer = name_customer;
    }
    public String get_name_customer(){
        return name_customer;
    }
    public void set_address(String address) {
        this.address = address;
    }
    public String get_address(){
        return address;
    }
    public void set_dni(int dni) {
        this.dni = dni;
    }
    public int get_dni(){
        return dni;
    }
    public void set_number(int number) {
        this.number = number;
    }
    public int get_number(){
        return number;
    }
    public void set_email(int email) {
        this.email = email;
    }
    public int get_email(){
        return email;
    }   
}
