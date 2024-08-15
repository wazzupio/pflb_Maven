package ru.pflb.school5.javaOOP;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        BufferedReader reader;
            while (true){
                try {
                    for (String str : args) {
                        reader = new BufferedReader(new FileReader(str));
                        String line = reader.readLine();
                        System.out.println("Читаю файл: " + str);
                        while (line != null) {
                            Thread.sleep(2000);
                            System.out.println(line);
                            // read next line
                            line = reader.readLine();
                        }
                        System.out.println("Файл " + str + " прочитан.");
                        reader.close();
                    }
                } catch (IOException e) {
                    System.out.println("Ошибочка" + e);
                }
            }
    }
}