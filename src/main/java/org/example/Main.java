package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        try {
            String classFolder = "C:\\Backend\\javacourse\\TestPrj\\target\\classes";
            CustomClassLoader loader = new CustomClassLoader(classFolder);

            Class<?> clazz = loader.loadClass("org.example.Animal.Dog");
            Object obj = clazz.getDeclaredConstructor().newInstance();

            System.out.println("Class loaded: " + clazz.getName());
            Arrays.stream(clazz.getMethods()).forEach(method -> System.out.println(method.getName()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}