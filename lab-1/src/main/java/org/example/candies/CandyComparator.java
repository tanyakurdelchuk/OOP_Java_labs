package org.example.candies;

import java.util.Comparator;

public class CandyComparator implements Comparator<Candy> {
    @Override
    public int compare(Candy o1, Candy o2) {
        return Double.compare(o1.getSugarAmount(), o2.getSugarAmount());
    }
}
