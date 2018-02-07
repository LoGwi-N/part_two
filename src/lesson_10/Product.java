package lesson_10;

public class Product {
    static int nextId = 0;
    int ID;

    String name;
    double cost;

    public Product(String name, double cost) {
        this.name = name;
        this.cost = cost;
        ID = nextId;
        nextId++;
    }

    //    Геттеры и сеттеры
    public String getName() {
        return name;
    }
    public double getCost() {
        return cost;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "[ID: " + ID + " Name: " + name + " Cost: " + cost + "]";
    }

    public String toStringFile() {
        return ID + ";" + name + ";" + cost;
    }
}


