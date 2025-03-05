package org.example;

import java.io.*;
import java.nio.file.*;

public class CustomClassLoader extends ClassLoader {

    private String path;

    public CustomClassLoader(String path) {
        this.path = path;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] classData = loadClassData(name);
        if (classData == null) {
            throw new ClassNotFoundException(name);
        }
        return defineClass(name, classData, 0, classData.length);
    }

    private byte[] loadClassData(String className) {
        try {
            String filePath = path + File.separator + className.replace('.', File.separatorChar) + ".class";
            Path pathToFile = Paths.get(filePath);
            return Files.readAllBytes(pathToFile);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
