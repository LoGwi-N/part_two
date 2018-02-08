package lesson11.cats;

import java.io.IOException;
import java.util.*;

import static lesson11.cats.Cat.*;

public class Main {
    public static void main(String[] args) throws IOException {

        loadFromFileToArray("cat.txt");

        showList(); // Показываю список после считывания из файла

        sortByWeight("down"); // Сортировка

        System.out.print("\ndown");
        showList(); // Показываю списко после сортировки

        sortByWeight("up"); // Сортировка

        System.out.print("\nup");
        showList(); // Показываю список после сортировки

        deleteCat("coloreye", "blue");   // Удаляю (тип и значение поля) {name, type, color, coloreye, weight}
        deleteCat("weight", "12.0");
        deleteCat("name", "name1");

        showList(); // Показываю списко после удаления

    }

}
