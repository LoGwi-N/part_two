package lesson_10;

import java.io.IOException;

public class Main {

    static ListProducts listProducts = new ListProducts();
    static OrderList orderList = new OrderList();

    public static void main(String[] args) throws IOException {

        boolean notExit = true;
        // Main menu
        while(notExit) {
            System.out.println("1. Show orders  2. Show products 3. Show List Of Orders 4. Show List Of Products                0. Finish");
            int ur = Menu.userChoice();
            switch(ur) {
                case 1: Menu.selectShowOrders();break;
                case 2: Menu.selectShowProducts();break;
                case 3: Menu.selectShowListOfOrders();break;
                case 4: Menu.selectShowListOfProducts();break;
                case 0: notExit = false;break;
            } // switch
        } // while

    } // Main



}
