package lesson_10;

public class Client{
    String datein;
    String dateout;
    int table;

    public Client(String datein, String dateout, int table) {
        this.datein = datein;
        this.dateout = dateout;
        this.table = table;
    }

    //    Геттеры и сеттеры
    public String getDatein() {
        return datein;
    }
    public String getDateout() {
        return dateout;
    }
    public int getTable() {
        return table;
    }
    public void setDatein(String datein) {
        this.datein = datein;
    }
    public void setDateout(String dateout) {
        this.dateout = dateout;
    }
    public void setTable(int table) {
        this.table = table;
    }

    @Override
    public String toString() {
        return datein + " - " + dateout + "  Table: #" + table + ")  ";
    }
}
