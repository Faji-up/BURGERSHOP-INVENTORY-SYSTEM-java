/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */
public class Burger {
    String burgerName;
    int price;
    public int quantity;
    public Burger(String burgerName,int price,int quantity){
        this.burgerName = burgerName;
        this.price = price;
        this.quantity = quantity; 
    }
    
    public String get_burger_name(){return this.burgerName;}
    public int get_price(){return this.price;}
    public int get_quantity(){return this.quantity;}
    public int get_total_price() { return this.get_price() * this.get_quantity();}
}
