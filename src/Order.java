/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.time.LocalDateTime;
/**
 *
 * @author Admin
 */
public class Order {
    String customer;
    String foods;
    String receiptCode;
    int quantity;
    LocalDateTime date;
    int totalPrice;
    public Order(String customer,
    String foods,
    String receiptCode,
    int quantity,
    
    int totalPrice,
    LocalDateTime date){
        this.customer = customer;
        this.foods = foods;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.receiptCode = receiptCode;
        this.date = date;
    }
    
    public String get_customer(){return this.customer;}
    public String get_foods(){return this.foods;}
    public int get_total_price(){return this.totalPrice;}
    public int get_quantity(){return this.quantity;}
    public String get_receipt_code(){return this.receiptCode;}
    public LocalDateTime get_date(){return this.date; }
    
}
