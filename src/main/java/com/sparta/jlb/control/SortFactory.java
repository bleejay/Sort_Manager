package com.sparta.jlb.control;

import com.sparta.jlb.sorters.BubbleSorter;
import com.sparta.jlb.sorters.MergeSorter;
import com.sparta.jlb.sorters.QuickSorter;
import com.sparta.jlb.sorters.Sorter;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class SortFactory {

    static final String PATH = "resources/factory.properties";

    public static Sorter getInstanceOf() throws FactoryException {

        try{
            Properties properties = new Properties();
            properties.load(new FileReader(PATH));
            String sortType = properties.getProperty("sorter");
            Class selectedSorter = Class.forName(sortType);
            return (Sorter)selectedSorter.getDeclaredConstructor().newInstance();
        } catch (IOException | ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new FactoryException("Unable to process user request");
        }
    }
}
