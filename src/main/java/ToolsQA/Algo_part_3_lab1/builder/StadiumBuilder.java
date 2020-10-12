package ToolsQA.Algo_part_3_lab1.builder;


import java.util.List;

import ToolsQA.Algo_part_3_lab1.model.Stadium;
import ToolsQA.Algo_part_3_lab1.manager.StadiumManager;


public class StadiumBuilder {

    public static void main(String[] args) {
        List<Stadium> stadiums = StadiumManager.readStadiumsFromCSV("stadiumsList.csv");
        
        System.out.println("******Selection sort decrease lighting power******");
        long startForSelection = System.nanoTime();    
        StadiumManager.selectionSortByDecreaseLightingPower(stadiums);
        long elapsedTimeForSelection = System.nanoTime() - startForSelection;
        System.out.println("spended time = " + elapsedTimeForSelection);
        System.out.println("countOfComparationsInSelectionSorting = " + StadiumManager.countOfComparationsInSelectionSorting);
        System.out.println("countOfExchangesInSelectionSorting = " + StadiumManager.countOfExchangesInSelectionSorting);
        StadiumManager.printListOfStadiums(stadiums);
        System.out.println();
        
        System.out.println("******Merge sort increase count of spectators******");
        long startForMerge = System.nanoTime();    
        StadiumManager.mergeSortByIncreaseCountOfSpectators(stadiums, 0, stadiums.size() - 1);
        long elapsedTimeForMerge = System.nanoTime() - startForMerge;
        System.out.println("spended time = " + elapsedTimeForMerge);
        System.out.println("countOfComparationsInMergeSorting = " + StadiumManager.countOfComparationsInMergeSorting);
        System.out.println("countOfExchangesInMergeSorting = " + StadiumManager.countOfExchangesInMergeSorting);
        StadiumManager.printListOfStadiums(stadiums);
        
        

    }

}
