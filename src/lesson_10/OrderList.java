package lesson_10;

import java.util.ArrayList;
import java.util.List;

public class OrderList {
    List<Order> orderList = new ArrayList<Order>();

    public void addOrder(Order order){
        orderList.add(order);
    }

    public double avOrders(){
        double s = 0;
        int i = 0;
        for (Order order: orderList
                ) {
            i++;
            s += order.getSum();
        }
        return s/i;
    }

    public void showOrders(){
        for (Order o: orderList
                ) {
            System.out.println(o.toString());
        }
    }

    public Order getIdOrderOfList(int id){
        Order order = null;
        for (Order ord: orderList
                ) {
            if(ord.ID == id){
                order = ord;
                break;
            }
        }
        return order;
    }
}
