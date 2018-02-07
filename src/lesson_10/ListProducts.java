package lesson_10;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ListProducts {
    List<Product> listOfProducts = new ArrayList<Product>();

    public void addProduct(Product product){
        listOfProducts.add(product);
    }

    public void showProducts(){
        for (Product prod: listOfProducts
             ) {
            System.out.println(prod.toString());
        }
    }

    public void editProduct(Product product, String name, double cost){
        product.setName(name);
        product.setCost(cost);
    }

    public void deleteProduct(Product product){
        listOfProducts.remove(product);
    }

    public void saveProduct(String name) {
        Writer writer = null;
        try {
            writer = new FileWriter(name+".csv");
            for (Product r : listOfProducts) {
                writer.write(r.toStringFile());
                writer.write(System.getProperty("line.separator"));
            }
            writer.flush();
        } catch (Exception e) {
            Logger.getLogger(ListProducts.class.getName()).log(Level.SEVERE, null, e);
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException ex) {
                }
            }
        }
    }
    public Product getIdProductOfList(int id){
        Product product = null;
        for (Product prod: listOfProducts
             ) {
            if(prod.ID == id){
                product = prod;
                break;
            }
        }
        return product;
    }

    public void loadProduct(String filename){
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(filename), StandardCharsets.UTF_8))){
            String line;
            while ((line = reader.readLine()) != null) {
//                String regexpid = "^(\\d*)";
                String regexpname = "[А-Яа-яA-Za-z]+";
                String regexpcost = "([0-9.]+)$";
//                Pattern id = Pattern.compile(regexpid);
                Pattern name = Pattern.compile(regexpname);
                Pattern cost = Pattern.compile(regexpcost);
//                Matcher matcherid = id.matcher(line);
                Matcher matchername = name.matcher(line);
                Matcher matchercost = cost.matcher(line);
                String tmpname = null;
                while (matchername.find()) {
                    tmpname = matchername.group();
                }
                double tmpcost = 0;
                while (matchercost.find()) {
                    tmpcost = Double.parseDouble(matchercost.group());
                }
                if( tmpname != null & tmpcost > 0){
                    listOfProducts.add(new Product(tmpname, tmpcost));
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка: "+e);
        }
    }
}
