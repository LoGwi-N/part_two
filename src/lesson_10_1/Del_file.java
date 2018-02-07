package lesson_10_1;


import java.io.*;
import java.nio.charset.StandardCharsets;

public class Del_file {
    public static void main(String[] args) throws FileNotFoundException{
//      Дан файл in.txt: «Hello, how are you?»
//      Удалить файл, если файл содержит указанную строку,
//      либо выдать соответсвующее сообщение
        String filePath = "src/in2.txt";

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(filePath), StandardCharsets.UTF_8))){
            String line;

            while ((line = reader.readLine()) != null) {
                if(line.equals("Alex: I am fine!")){
                    reader.close();
                    new File(filePath).delete();
                    System.out.println(" Зашел в equals");
                    break;
                }
                System.out.println(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
