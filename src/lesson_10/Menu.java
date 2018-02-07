package lesson_10;

import java.util.Scanner;

import static lesson_10.Main.listProducts;
import static lesson_10.Main.orderList;

public class Menu {
    static Scanner scn = new Scanner(System.in);

    public static int userChoice() {
        int choice = scn.nextInt();
        return choice;
    }

    // Start Show orders
    public static void selectShowOrders(){
        boolean notExit = true;
        while(notExit) {
            System.out.println("1. Add order   2. Edit order   3. Delete Order  4. Save orders  5. Load orders 6. Show All Orders    0. Back");
            int ur = userChoice();
            switch(ur) {
                case 1: selectAddOrder();break;
                case 2: selectEditOrder();break;
                case 6: selectShowListOfOrders();break;
                case 0: notExit = false;break;
            }
        }
    }

    public static void selectAddOrder(){
        System.out.println("Enter Start time");
        String datein = scn.next();
        System.out.println("Enter End time");
        String dateout = scn.next();
        System.out.println("Enter number of table");
        int table = scn.nextInt();
        System.out.println("Enter name of Dish");
        String name = scn.next();
        System.out.println("Enter cost");
        double cost = scn.nextDouble();
        Order tmp_order = new Order(new Client(datein, dateout, table), new Product(name, cost));
        orderList.addOrder(tmp_order);
        boolean notExit = true;
        while(notExit) {
            System.out.println("Add more?  y/n");
            String ur = scn.next();
            ur = ur.toLowerCase();
            switch(ur) {
                case "y": {
                    System.out.println("Enter name of Dish");
                    name = scn.next();
                    System.out.println("Enter cost");
                    cost = scn.nextDouble();
                    tmp_order.addProduct(new Product(name, cost));
                    break;
                }
                case "n": notExit = false;break;
            }
        }
    }

    public static void selectEditOrder(){

    }

    public static void selectShowListOfOrders(){
        orderList.showOrders();
    }
    // End Show Orders


    // Start Show Products
    public static void selectShowProducts(){
        boolean notExit = true;
        while(notExit) {
            System.out.println("1. Add Product  2. Edit Product  3. Delete Product  4. Save Products  5. Load Products 0. Back");
            int ur = userChoice();
            switch(ur) {
                case 1: selectAddProduct();break;
                case 2: selectEditProduct();break;
                case 3: selectDeleteProduct();break;
                case 4: selectSaveProducts();break;
                case 5: selectLoadProducts();break;
                case 0: notExit = false;break;
            }
        }
    }

    public static void selectAddProduct(){
        System.out.println("Enter dish name");
        String name = scn.next();
        System.out.println("Enter it cost");
        double cost = scn.nextDouble();
        listProducts.addProduct(new Product(name, cost));
    }

    public static void selectEditProduct(){
        listProducts.showProducts();
        System.out.println("Enter ID product, which you want to change");
        int ur = userChoice();
        Product curr = listProducts.getIdProductOfList(ur);
        System.out.println(curr.toString());
        System.out.println("Enter new name");
        String name = scn.next();
        System.out.println("Enter new cost");
        double cost = scn.nextDouble();
        listProducts.editProduct(curr, name, cost);
    }

    public static void selectShowListOfProducts(){
        listProducts.showProducts();
    }

    public static void selectDeleteProduct(){
        listProducts.showProducts();
        System.out.println("Enter ID product, which you want to delete");
        int ur = userChoice();
        Product curr = listProducts.getIdProductOfList(ur);
        listProducts.listOfProducts.remove(curr);
    }

    public static void selectSaveProducts(){
        System.out.println("Enter name file");
        String name = scn.next();
        listProducts.saveProduct(name);
    }

    public static void selectLoadProducts(){
        System.out.println("Enter name file");
        String name = scn.next();
        listProducts.loadProduct(name);
    }

    // End Show Products

}
