package lesson11.cats;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cat {

    private String name;
    private String type;
    private String color;
    private String colorEye;
    private double weight;
    static List<Cat> listcat = new ArrayList<>();

    public Cat(String name, String type, double weight, String color, String colorEye) {
        this.name = name;
        this.type = type;
        this.color = color;
        this.colorEye = colorEye;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return name + " " + type + " " + weight + " " + color + " " + colorEye;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getColor() {
        return color;
    }

    public String getColorEye() {
        return colorEye;
    }

    public double getWeight() {
        return weight;
    }

    public  static void loadFromFileToArray(String FILENAME) throws IOException {
        try {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(FILENAME), StandardCharsets.UTF_8));
            String line;

            while ((line = reader.readLine()) != null) {
                String regexp_text = "[А-Яа-яA-Za-z0-9]+";
                String regexp_double = "[0-9.]+";

                Pattern ptext = Pattern.compile(regexp_text);
                Pattern pdouble = Pattern.compile(regexp_double);

                Matcher mtext = ptext.matcher(line);
                Matcher mdouble = pdouble.matcher(line);

                int end = 0;
                String name = null;
                String type = null;
                String color = null;
                String colorEye = null;
                double weight = 0;

                while ( mtext.find(end) ){
                    name = line.substring(mtext.start(), mtext.end());
                    end = mtext.end();
                    break;
                }
                while ( mtext.find(end) ){
                    type = line.substring(mtext.start(), mtext.end());
                    end = mtext.end();
                    break;
                }
                while ( mdouble.find(end) ){
                    weight = Double.parseDouble(line.substring(mdouble.start(), mdouble.end()));
                    end = mdouble.end();
                    break;
                }

                while ( mtext.find(end) ){
                    color = line.substring(mtext.start(), mtext.end());
                    end = mtext.end();
                    break;
                }
                while ( mtext.find(end) ){
                    colorEye = line.substring(mtext.start(), mtext.end());
                    break;
                }
                listcat.add(new Cat(name, type , weight, color, colorEye));
            }
        } catch ( IOException e ){
            System.out.println("Ошибка: " + e);
        }
    }

    public static void showList(){
        System.out.println();
        Iterator<Cat> iter = listcat.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }

    public static void deleteCat(String type, String value){
        for (Iterator<Cat> iterator = listcat.iterator(); iterator.hasNext(); ) {
            Cat cat = iterator.next();
            switch ( type ){
                case "name":{
                    if ( cat.getName().equals(value) ) {
                        iterator.remove();
                    }
                    break;
                }
                case "type":{
                    if ( cat.getType().equals(value) ) {
                        iterator.remove();
                    }
                    break;
                }
                case "color":{
                    if ( cat.getColor().equals(value) ) {
                        iterator.remove();
                    }
                    break;
                }
                case "coloreye":{
                    if ( cat.getColorEye().equals(value) ) {
                        iterator.remove();
                    }
                    break;
                }
                case "weight":{
                    if ( cat.getWeight() == Double.parseDouble(value) ) {
                        iterator.remove();
                    }
                    break;
                }
            }
        }
    }

    public static void sortByWeight(String desc){
        desc = desc.toLowerCase();
        switch ( desc ){
            case "up":{
                Collections.sort(listcat, new CatWeightComparatorUp());
                break;
            }
            case "down":{
                Collections.sort(listcat, new CatWeightComparatorDown());
                break;
            }
        }
    }
}
