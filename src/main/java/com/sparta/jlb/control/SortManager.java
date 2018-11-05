package com.sparta.jlb.control;

import com.sparta.jlb.display.Display;
import com.sparta.jlb.display.DisplayToConsole;
import com.sparta.jlb.sorters.Sorter;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class SortManager{

    int[] arrayToSort ={1, 7, 3, 18, 12};
    Display displayResult = new DisplayToConsole();

    private final String LOG_PROPERTIES_FILE = "resources/log4j.properties";
    Logger log = Logger.getLogger(SortManager.class.getName());

    private void initialiseLogging(){
        PropertyConfigurator.configure(LOG_PROPERTIES_FILE);
    }

    public void runSorter(){
        PropertyConfigurator.configure(LOG_PROPERTIES_FILE);
        initialiseLogging();

        Sorter sorter = null;
        try {
            sorter = SortFactory.getInstanceOf();
            int[] sortedArray = sorter.sortArray(arrayToSort);
            displayUnsortedArray();
            displaySortedArray(sortedArray, sorter.toString());
        } catch (FactoryException e) {
            displayExceptionMessage(e.getMessage());
            log.debug("Unable to process user request");
        }
    }

    private void displayUnsortedArray(){

        displayResult.displayUnsortedArray(arrayToSort);
    }

    private void displaySortedArray(int[] sortedArray, String typeOfSort){

        displayResult.displaySortedArray(sortedArray, typeOfSort);
    }

    private void displayExceptionMessage(String message){

        displayResult.displayExceptionMessage(message);
    }
}
