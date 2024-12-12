package gm.mini.project.pkg1;
//importing list and array list

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

class Garment {

    public String id;
    public String name;
    public String description;
    public String size;
    public String color;
    public double price;
    public int stockQuantity;

    void updateStock(int quantity) {
        this.stockQuantity = quantity;
    }

    double calculateDiscountPrice(double discountPercentage) {
        double discount = price * (discountPercentage / 100);
        return discount;
    }
}

class Fabric {

    public String id;
    public String type;
    public String color;
    public double pricePerMeter;

    double calculateCost(double meters) {
        double newPrice = pricePerMeter * meters;
        return newPrice;
    }
}

class Supplier {

    public String id;
    public String name;
    public String contactInfo;
    //List
    List<Fabric> suppliedFabric = new ArrayList<>();

    void addFabric(Fabric fabric) {
        suppliedFabric.add(fabric);
    }

    List<Fabric> getSuppliedFabrics() {
        return suppliedFabric;
    }
}

class Order {

    public String orderId;
    public Date orderDate;
    public List<Garment> garments = new ArrayList<>();
    private double totalAmount;

    void addGarment(Garment garment) {
        garments.add(garment);
    }

    double calculateTotalAmount() {
        garments.forEach((g) -> {
            totalAmount = totalAmount + g.price;
        });
        return totalAmount;
    }

    void printOrderDetails() {
        System.out.println("--------------------------");
        System.out.println("Order Details");
        System.out.println("--------------------------");
        garments.stream().map((g) -> {
            System.out.println("Name: " + g.name);
            return g;
        }).map((g) -> {
            System.out.println("Price: " + g.price);
            return g;
        }).map((g) -> {
            System.out.println("Description: " + g.description);
            return g;
        }).forEachOrdered((_item) -> {
            System.out.println("--------------------------");
        });
    }
}

class Customer {

    public String customerId;
    public String name;
    public String email;
    public String phone;

    void placeOrder(Order order) {
        order.printOrderDetails();
        System.out.println("Order Placed");
    }

//    List<Order> viewOrders() {
//        
//    }
}

class Inventory {

    List<Garment> garments;

    void addGarment(Garment garment) {
        garments.add(garment);
    }

    void removeGarment(String id) {
        boolean remove = garments.remove(id);
    }

    Garment findGarment(String id) {
        for (Garment g : garments) {
            if(g.id == null ? id == null : g.id.equals(id))
                return g;
        }
        return null;
    }
}

public class OopLabTask3 {

    public static void main(String[] args) {
        Garment g1 = new Garment();
        g1.name = "Silk";
        g1.description = "Good Product";
        g1.price= 600;
        double x = g1.calculateDiscountPrice(10);
        System.out.println(x);

    }
}