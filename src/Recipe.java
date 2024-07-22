/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */
public class Recipe {
    String recipeName;
    int stock;
    int price;
    int totalPrice;
    public Recipe(String recipeName,int price,int stock){
        this.recipeName = recipeName;
        this.price = price;
        this.stock = stock;
        this.totalPrice = this.stock * this.price;
    }
    public String get_recipe_name(){return this.recipeName;}
    public int get_stock(){return this.stock;}
    public int get_price(){return this.price;}
    public int get_total_price(){return this.totalPrice;}
}
