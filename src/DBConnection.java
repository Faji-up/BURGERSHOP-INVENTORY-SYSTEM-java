/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Admin
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import java.sql.SQLException;
import java.time.LocalDateTime;
public class DBConnection {

    private static HashMap<String, String[]> burgerRecipe = new HashMap<>();

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/Inventory";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }

    public ArrayList<BurgerSale> get_burger_sales() {
        ArrayList<BurgerSale> foods = new ArrayList<>();
        Connection conn;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (ClassNotFoundException e) {

            throw new IllegalStateException("Error - ", e);
        }
        try {

            conn = getConnection();
            if (conn != null) {
                System.out.println("Connected");
            } else {
                System.out.println("FAILED");
            }
            PreparedStatement stat = conn.prepareStatement("SELECT * FROM burgers");
            ResultSet res = stat.executeQuery();
            while (res.next()) {
                String item = res.getString("item");
                int price = res.getInt("price");
                int sales = res.getInt("sales");
                foods.add(new BurgerSale(item, price, sales));
                System.out.println("Addeddddd");
            }
        } catch (SQLException e) {
            throw new IllegalStateException("Error", e);
        }
        return foods;
    }

    public ArrayList<Order> getOrders() {
        ArrayList<Order> orders = new ArrayList<>();
        Connection conn;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (ClassNotFoundException e) {

            throw new IllegalStateException("Error - ", e);
        }
        try {

            conn = getConnection();
            if (conn != null) {
                System.out.println("Connected");
            } else {
                System.out.println("FAILED");
            }
            PreparedStatement stat = conn.prepareStatement("SELECT * FROM orders");
            ResultSet res = stat.executeQuery();
            while (res.next()) {
                String foods = res.getString("foods");
                int quantity = res.getInt("total_item");
                int totalPrice = res.getInt("total_price");
                String customer = res.getString("customer");
                String receiptCode = res.getString("reciept_code");
                LocalDateTime date = res.getTimestamp("dateOrdered").toLocalDateTime();
                
                orders.add(new Order(customer, foods, receiptCode, quantity, totalPrice,date));
                System.out.println("Addeddddd");
            }
        } catch (SQLException e) {
            throw new IllegalStateException("Error", e);
        }
        return orders;
    }

    public ArrayList<Recipe> getRecipies() {
        ArrayList<Recipe> recipe = new ArrayList<>();
        Connection conn;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (ClassNotFoundException e) {

            throw new IllegalStateException("Error - ", e);
        }
        try {

            conn = getConnection();
            if (conn != null) {
                System.out.println("Connected");
            } else {
                System.out.println("FAILED");
            }
            PreparedStatement stat = conn.prepareStatement("SELECT * FROM BurgerRecipes");
            ResultSet res = stat.executeQuery();
            while (res.next()) {
                String recipeName = res.getString("recipeName");
                int price = res.getInt("price");
                int stock = res.getInt("stock");

                recipe.add(new Recipe(recipeName, price, stock));
            }
        } catch (SQLException e) {
            throw new IllegalStateException("Error", e);
        }
        return recipe;
    }

    public void updateRecipe(String burgerName, int quan) {
        add_recipies();

        String[] burgerRecipies = burgerRecipe.get(burgerName);
        //for(String name: burgerRecipe.get(burgerName)){
        //  System.out.println(name);
        //}
        ArrayList<Recipe> recipies = getRecipies();

        for (String recipe : burgerRecipies) {
            for (Recipe res : recipies) {
                if (recipe.equalsIgnoreCase(res.get_recipe_name())) {
                    System.out.println(recipe);
                    String sql = "UPDATE BurgerRecipes SET stock=? WHERE recipeName=?";
                    String recipeName = res.get_recipe_name();
                    int stock = res.get_stock();
                    if (stock > 0) {
                        stock -= quan;
                    }
                    try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
                        stmt.setInt(1, stock);
                        stmt.setString(2, recipeName);
                        int rowsUpdated = stmt.executeUpdate();
                        if (rowsUpdated > 0) {
                            System.out.println(recipeName + " updated successfully!");
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();

                    }
                    break;
                }

            }
        }

    }

    public void update_burger_sales(String BurgerName, int sales) {
        String sql = "UPDATE Burgers SET sales=? WHERE item=?";
        for (BurgerSale sale : get_burger_sales()) {
            if (sale.get_item().equalsIgnoreCase(BurgerName)) {
                try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
                    sales += sale.get_sales();
                    stmt.setInt(1, sales);
                    stmt.setString(2, BurgerName);
                    int rowsUpdated = stmt.executeUpdate();
                    if (rowsUpdated > 0) {
                        System.out.println(BurgerName + " Sales updated successfully!");
                    }
                } catch (SQLException e) {
                    e.printStackTrace();

                }
                break;
            }
        }
    }

    private void add_recipies() {
        String[][] recipies = {     {"Bread", "Cheese", "Patty", "Ketchup", "Mayonnaise", "Bread"},
                                    {"Bread","Patty", "Ketchup", "Mayonnaise", "Bread"},
                                    {"Bread", "Chicken", "Ketchup", "Mayonnaise", "Bread"},
                                    {"Bread", "Egg","Cheese", "Patty", "Ketchup", "Mayonnaise", "Bread"}};
        
        
        
        
        burgerRecipe.put("Cheese Burger", recipies[0]);
        burgerRecipe.put("Regular Burger", recipies[1]);
        burgerRecipe.put("Chicken Burger", recipies[2]);
        burgerRecipe.put("Egg Cheese Burger", recipies[3]);
    }

}
