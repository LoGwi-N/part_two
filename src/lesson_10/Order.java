package lesson_10;

import java.util.ArrayList;
import java.util.List;

import static lesson_10.Main.listProducts;

public class Order {
    static int nextId = 0;
    int ID;

    List<Product> productList = new ArrayList<Product>();
    Client client = null;

    public Order(Client client, Product product) {
        this.client = client;
        this.productList.add(product);
        listProducts.addProduct(product);
        ID = nextId;
        nextId++;
    }

    public void addProduct(Product product){
        productList.add(product);
        listProducts.addProduct(product);
    }

    public double getSum(){
        double s = 0;
        for (Product product: productList
                ) {
            s += product.getCost();
        }
        return s;
    }

    public double getAv(){
        int i = productList.size();
        double av = getSum()/i;
        return av;
    }

    @Override
    public String toString() {
        return "Order #" + ID + " " + client.toString() + " Products " + productList.toString() + " Average price: " + getAv();
    }
}
