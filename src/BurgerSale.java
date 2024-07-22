/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */

public class BurgerSale {
     String item;
     int price;
     int sales;
    public BurgerSale(String item,int price,int sales){
        
        this.item = item;
        this.price = price;
        this.sales = sales;
    }
    public String get_item(){return this.item;}
    public int get_price(){return this.price;}
    public int get_sales(){return this.sales;}

}

