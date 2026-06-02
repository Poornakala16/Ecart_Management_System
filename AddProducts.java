package eCart;

import java.util.HashMap;

public class AddProducts {

    HashMap<Integer, Product> products = new HashMap<>();
    HashMap<Integer, Integer> cart = new HashMap<>();

    public void addProduct(int id, String name, double price) {
        products.put(id, new Product(id, name, price));
        System.out.println("Product Added Successfully");
    }

    public void viewProducts() {
        if(products.isEmpty()) {
            System.out.println("No Products Available");
            return;
        }

        System.out.println("\nAvailable Products");
        for(Product p : products.values()) {
            System.out.println("ID: " + p.productId +
                    " Name: " + p.productName +
                    " Price: " + p.price);
        }
    }

    public void addToCart(int id, int qty) {
        if(products.containsKey(id)) {
            cart.put(id, cart.getOrDefault(id, 0) + qty);
            System.out.println("Added To Cart");
        } else {
            System.out.println("Product Not Found");
        }
    }

    public void removeCart(int id) {
        if(cart.containsKey(id)) {
            cart.remove(id);
            System.out.println("Removed From Cart");
        } else {
            System.out.println("Product Not In Cart");
        }
    }

    public void viewCart() {

        if(cart.isEmpty()) {
            System.out.println("Cart Empty");
            return;
        }

        System.out.println("\nCart Details");

        for(Integer id : cart.keySet()) {
            Product p = products.get(id);
            int qty = cart.get(id);

            System.out.println(
                    p.productName +
                    " Price:" + p.price +
                    " Qty:" + qty +
                    " Subtotal:" + (p.price * qty));
        }
    }

    public void totalBill() {

        double total = 0;

        for(Integer id : cart.keySet()) {
            Product p = products.get(id);
            total += p.price * cart.get(id);
        }

        System.out.println("Total Bill = " + total);
    }
}