package lesson11;


import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import static lesson11.Flight.treeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        Flight.loadFromFile("file.txt");
        Set<Integer> keys = treeMap.keySet();

        System.out.println("\nВывод всех рейсов");
        for(Map.Entry<Integer, Flight> item : treeMap.entrySet()){
            System.out.printf("Ключ: %d  Значение: %s \n", item.getKey(), item.getValue().toString());
        }

        System.out.println("\nВывод рейса Гомель - Варшава");
        for(Map.Entry<Integer, Flight> item : treeMap.entrySet()){
            if( item.getValue().getFrom().equals("Minsk") & item.getValue().getTo().equals("Varshava") ){
                System.out.printf("Ключ: %d  Значение: %s \n", item.getKey(), item.getValue().toString());
            }
        }

        for( Iterator<Map.Entry<Integer, Flight>> item = treeMap.entrySet().iterator(); item.hasNext(); ) {
            Map.Entry<Integer, Flight> entry = item.next();
            if( entry.getValue().getFrom().equals("Gomel") || entry.getValue().getFrom().equals("Moskow") ) {
                item.remove();
            }
        }

        System.out.println("\nВывод всех рейсов после удаления рейсов из Гомеля");
        for(Map.Entry<Integer, Flight> item : treeMap.entrySet()){
            System.out.printf("Ключ: %d  Значение: %s \n", item.getKey(), item.getValue().toString());
        }
    }
}
