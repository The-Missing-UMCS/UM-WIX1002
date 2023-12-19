package Lab7.L7Q6;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import Lab7.Generator;

public class L7Q6C {
    final static String DB_URL = "jdbc:sqlite:" + Generator.ROOT + "database.db";

    public static void main(String[] args) {
        createDatabase();
        loadProductToDatabase();
        loadOrderToDatabase();
        getTotalPrice();
    }

    public static void getTotalPrice() {
        try (Connection connection = DriverManager.getConnection(DB_URL)) {
            String sql = "SELECT P.Product_ID as \"Product ID\", " +
                    "       P.Product_Name as \"Product Name\", " +
                    "       O.Order_Quantity as Quantity, " +
                    "       P.Product_Price as \"Unit Price\", " +
                    "       P.Product_Price * O.Order_Quantity as Total " +
                    "FROM PRODUCTS AS P " +
                    "JOIN ORDERS AS O " +
                    "ON P.Product_ID = O.Order_ID";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
                    ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    int productID = resultSet.getInt("Product ID");
                    String productName = resultSet.getString("Product Name");
                    int quantity = resultSet.getInt("Quantity");
                    double unitPrice = resultSet.getDouble("Unit Price");
                    double total = resultSet.getDouble("Total");

                    // Do something with the retrieved data
                    System.out.printf("Product ID: %d, Product Name: %s, Quantity: %d, Unit Price: %.2f, Total: %.2f%n",
                            productID, productName, quantity, unitPrice, total);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void loadProductToDatabase() {
        try (Scanner scanner = new Scanner(new FileInputStream(Generator.PRODUCT_FILE))) {
            while (scanner.hasNextLine()) {
                String[] info = scanner.nextLine().split(",");
                insertProduct(info[0], info[1], Double.parseDouble(info[2]));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void loadOrderToDatabase() {
        try (Scanner scanner = new Scanner(new FileInputStream(Generator.PRODUCT_FILE))) {
            while (scanner.hasNextLine()) {
                String[] info = scanner.nextLine().split(",");
                insertProduct(info[0], info[1], Integer.parseInt(info[2]));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void createDatabase() {
        final String CREATE_TABLE_PRODUCT = "CREATE TABLE IF NOT EXISTS PRODUCTS (" +
                "Product_ID TEXT PRIMARY KEY," +
                "Product_Name TEXT NOT NULL," +
                "Product_Price Float NOT NULL)";

        final String CREATE_TABLE_ORDER = "CREATE TABLE IF NOT EXISTS ORDERS (" +
                "Order_ID TEXT PRIMARY KEY," +
                "Order_Name TEXT NOT NULL," +
                "Order_Quantity Integer NOT NULL)";

        try (Connection connection = DriverManager.getConnection(DB_URL);
                Statement statement = connection.createStatement()) {

            // Create a table
            statement.execute(CREATE_TABLE_PRODUCT);
            statement.execute(CREATE_TABLE_ORDER);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void insertProduct(String productID, String productName, double productPrice) {
        try (Connection connection = DriverManager.getConnection(DB_URL)) {
            // Using a prepared statement to insert data
            String insertDataSQL = "INSERT INTO PRODUCTS (Product_ID, Product_Name, Product_Price) VALUES (?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertDataSQL)) {
                preparedStatement.setString(1, productID);
                preparedStatement.setString(2, productName);
                preparedStatement.setDouble(3, productPrice);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertOrder(String orderID, String orderName, int orderQuantity) {
        try (Connection connection = DriverManager.getConnection(DB_URL)) {
            // Using a prepared statement to insert data
            String insertDataSQL = "INSERT INTO ORDERS (Order_ID, Order_Name, Order_Quantity) VALUES (?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertDataSQL)) {
                preparedStatement.setString(1, orderID);
                preparedStatement.setString(2, orderName);
                preparedStatement.setInt(3, orderQuantity);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
