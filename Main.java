package eCart;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        AddProducts ap = new AddProducts();

        int choice;

        do {

            System.out.println("\n===== E-CART =====");
            System.out.println("1.Add Product");
            System.out.println("2.View Product");
            System.out.println("3.Add To Cart");
            System.out.println("4.Remove Cart");
            System.out.println("5.View Cart");
            System.out.println("6.Total Bill");
            System.out.println("7.Exit");

            System.out.print("Enter Choice: ");
            choice = sc.nextInt();

            switch(choice) {

            case 1:

                System.out.print("Enter Product ID: ");
                int pid = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter Product Name: ");
                String pname = sc.nextLine();

                System.out.print("Enter Price: ");
                double price = sc.nextDouble();

                ap.addProduct(pid, pname, price);
                break;

            case 2:
                ap.viewProducts();
                break;

            case 3:

                System.out.print("Enter Product ID: ");
                pid = sc.nextInt();

                System.out.print("Enter Quantity: ");
                int qty = sc.nextInt();

                ap.addToCart(pid, qty);
                break;

            case 4:

                System.out.print("Enter Product ID: ");
                pid = sc.nextInt();

                ap.removeCart(pid);
                break;

            case 5:
                ap.viewCart();
                break;

            case 6:
                ap.totalBill();
                break;

            case 7:
                System.out.println("Thank You");
                break;

            default:
                System.out.println("Invalid Choice");
            }

        } while(choice != 7);

        sc.close();
    }
}