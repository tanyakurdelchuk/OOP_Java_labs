package org.example;


import org.example.candies.Candy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Present {
    private String name = "";
    private List<Candy> listOfCandies;
    private double totalWeight;

    public Present(String name, List<Candy> listOfCandies) {
        this.name = name;
        this.listOfCandies = listOfCandies;
        this.totalWeight = calculateTotalWeight();
    }

    public Present(String name) {
        this.name = name;
        this.listOfCandies = new ArrayList<>();
    }

    public Present() {
        this.listOfCandies = new ArrayList<>();
    }

    private double calculateTotalWeight() {
        double result = 0;
        for (Candy candy: listOfCandies){
            result += candy.getWeight();
        }
        return result;
    }

    public void addCandy(Candy candy){
            listOfCandies.add(candy);
            this.totalWeight += candy.getWeight();
    }

    public void removeCandy(String candyName){
        for (int i = 0; i < listOfCandies.size() ; i++) {
            if(listOfCandies.get(i).getName().equals(candyName)){
                totalWeight -= listOfCandies.get(i).getWeight();
                listOfCandies.remove(i);
            }
        }
    }

    public String getName() {
        return name;
    }

    public List<Candy> getListOfCandies() {
        return listOfCandies;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setListOfCandies(List<Candy> listOfCandies) {
        this.listOfCandies = listOfCandies;
    }

    public void sortCandies(Comparator<Candy> comparator){
        listOfCandies.sort(comparator);
    }

    public List<Candy> findCandiesInSugarAmountInterval(double low, double high){
        List<Candy> result = new ArrayList<>();
        for(Candy candy: listOfCandies){
            if(candy.getSugarAmount() >= low && candy.getSugarAmount() <= high){
                result.add(candy);
            }
        }
        return result;
    }


}
