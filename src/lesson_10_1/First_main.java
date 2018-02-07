package lesson_10_1;

import java.io.*;

public class First_main {
    public static void main(String[] args) throws FileNotFoundException {
//      Чтение файла
        String filename = "src/in.txt";
        try (FileInputStream fin = new FileInputStream(filename)) {
            System.out.println("Размер файла: " + fin.available() + " байт(а)");

            byte[] buffer = new byte[fin.available()];
            fin.read(buffer, 0, fin.available());

            System.out.println("Содержимое файла:");
            for (int i = 0; i < buffer.length; i++){
                System.out.print((char) buffer[i]);
            }
         } catch (FileNotFoundException e){
            e.printStackTrace();
         }catch (IOException e){
            e.printStackTrace();
         }
     // Добавим строку в конец в файл
        PrintWriter out = new PrintWriter(new FileOutputStream(new File(filename), true));
        try {
            out.append("\nAlex: I am fine!");
        } finally {
            out.close();
        }
    }
}
