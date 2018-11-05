package com.sparta.jlb.display;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class DisplayFactory {

    private static final String PATH = "resources/factory.properties";

    static Display getInstanceOf() {

        try {
            Properties properties = new Properties();
            properties.load(new FileReader(PATH));
            String sortType = properties.getProperty("displayMode");

            if (sortType.equalsIgnoreCase("Console")) {
                return new DisplayToConsole();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
