package ToolsQA.Algo_part_3_lab1.manager;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ToolsQA.Algo_part_3_lab1.model.Stadium;

public class StadiumManager {
    
    public static int countOfComparationsInSelectionSorting = 0;
    public static int countOfExchangesInSelectionSorting = 0;
    public static int countOfComparationsInMergeSorting = 0;
    public static int countOfExchangesInMergeSorting = 0;
     
    public static void selectionSortByDecreaseLightingPower(List<Stadium> stadiums) {
        
        int countOfStadiums = stadiums.size();
        int maxStadiumId;
        
        for(int stadiumId = 0; stadiumId < countOfStadiums - 1; stadiumId++) {
            
           maxStadiumId = stadiumId;
           
           for(int restStadiumId = stadiumId + 1; restStadiumId < countOfStadiums; restStadiumId++) {
               
               countOfComparationsInSelectionSorting++;
               
               if(stadiums.get(restStadiumId).getLightingPowerInLux() > stadiums.get(maxStadiumId).getLightingPowerInLux()) {
                   
                   maxStadiumId = restStadiumId;
                
               }
            }
           
           Collections.swap(stadiums, maxStadiumId, stadiumId);
           countOfExchangesInSelectionSorting++;
       
        }        
    }
    
    public static void mergeByIncreaseCountOfSpectators(List<Stadium> stadiums, int firstElementIndex, int middleElementeIndex, int lastElementIndex) {
        
        int countElementsInLeftPart = middleElementeIndex - firstElementIndex + 1;
        int countElementsInRightPart = lastElementIndex - middleElementeIndex;
        
        List<Stadium> listOfLeftElements = new ArrayList<Stadium>();
        List<Stadium> listOfRightElements = new ArrayList<Stadium>();
        
        for(int indexOfElementInLeftPart = 0; indexOfElementInLeftPart < countElementsInLeftPart; ++indexOfElementInLeftPart) {
            listOfLeftElements.add(indexOfElementInLeftPart, stadiums.get(firstElementIndex + indexOfElementInLeftPart));
        }
        
        for(int indexOfElementInRightPart = 0; indexOfElementInRightPart < countElementsInRightPart; ++indexOfElementInRightPart) {
            listOfRightElements.add(indexOfElementInRightPart, stadiums.get(middleElementeIndex + 1 + indexOfElementInRightPart));
        }
        
        int indexOfElementInLeftPart = 0;
        int indexOfElementInRightPart = 0;
        int indexOfElementInSortedList = firstElementIndex;
        
        while(indexOfElementInLeftPart < countElementsInLeftPart && indexOfElementInRightPart < countElementsInRightPart) {
            
            countOfComparationsInMergeSorting++;
            
            if(listOfLeftElements.get(indexOfElementInLeftPart).getCountOfSpectators() <= listOfRightElements.get(indexOfElementInRightPart).getCountOfSpectators()) {

                stadiums.set(indexOfElementInSortedList, listOfLeftElements.get(indexOfElementInLeftPart));
                indexOfElementInLeftPart++;
                countOfExchangesInMergeSorting++;
                
            } else {
                
                stadiums.set(indexOfElementInSortedList, listOfRightElements.get(indexOfElementInRightPart));
                indexOfElementInRightPart++;
                countOfExchangesInMergeSorting++;
            
            }
            
            indexOfElementInSortedList++;
            
        }
        
        while(indexOfElementInLeftPart < countElementsInLeftPart) {
            
            stadiums.set(indexOfElementInSortedList, listOfLeftElements.get(indexOfElementInLeftPart));
            indexOfElementInLeftPart++;
            indexOfElementInSortedList++;
            countOfExchangesInMergeSorting++;

        }
        
        while(indexOfElementInRightPart < countElementsInRightPart) {
            
            stadiums.set(indexOfElementInSortedList, listOfRightElements.get(indexOfElementInRightPart));
            indexOfElementInRightPart++;
            indexOfElementInSortedList++;
            countOfExchangesInMergeSorting++;

        }
    }
    
    public static void mergeSortByIncreaseCountOfSpectators(List<Stadium> stadiums, int firstElementIndex, int lastElementIndex) {
        
        if( firstElementIndex < lastElementIndex) {
            
            int middleElementeIndex = (firstElementIndex + lastElementIndex)/2;
            mergeSortByIncreaseCountOfSpectators(stadiums, firstElementIndex, middleElementeIndex);
            mergeSortByIncreaseCountOfSpectators(stadiums, middleElementeIndex + 1, lastElementIndex);
            mergeByIncreaseCountOfSpectators(stadiums, firstElementIndex, middleElementeIndex, lastElementIndex);
        }
                
    }
    
    public static List<Stadium> readStadiumsFromCSV(String fileName) { 
        List<Stadium> stadiums = new ArrayList<>(); 
        Path pathToFile = Paths.get(fileName); 
       
        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) { 
            String line = br.readLine(); 
            while (line != null) { 
               
                String[] attributes = line.split(","); 
                Stadium stadium = createStadium(attributes); 
                stadiums.add(stadium); 
                line = br.readLine(); 
            } 
        } catch (IOException ioe) { 
            ioe.printStackTrace(); 
        } 
        return stadiums; 
    }
    
    private static Stadium createStadium(String[] metadata) { 
        int countOfSpectators = Integer.parseInt(metadata[0]); 
        String name = metadata[1]; 
        int lightingPowerInLux = Integer.parseInt(metadata[2]); 
        return new Stadium(countOfSpectators, name, lightingPowerInLux);
    }
    
    public static void printListOfStadiums(List<Stadium> stadiums) {
        for(Stadium sortedStadium : stadiums) {
            System.out.println(sortedStadium.toString());
        }
    }
    
}


