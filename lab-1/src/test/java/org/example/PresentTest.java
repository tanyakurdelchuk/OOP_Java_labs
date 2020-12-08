package org.example;

import org.example.Present;
import org.example.candies.Candy;
import org.example.candies.CandyComparator;
import org.example.candies.Color;
import org.example.candies.chocolate.Chocolate;
import org.example.candies.lollipop.Lollipop;
import org.example.candies.marmalade.Marmalade;
import org.example.candies.marshmallow.Marshmallow;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static junit.framework.TestCase.assertFalse;

public class PresentTest {
    private Present present;
    private List<Candy> candies = new ArrayList<>(Arrays.asList(
            new Chocolate(Color.BLACK, 10.0f, 300.0),
            new Lollipop(Color.RED, 80.0f, 20.0),
            new Marshmallow(Color.WHITE, 55.0f, 80.0),
            new Marmalade(Color.PINK, 40.0f, 150.0)
            ));

    public void createPresent(){
        this.present = new Present("HappyChild", candies);
    }

    @Test
    public void shouldCreatePresentWithoutCandies(){
        this.present = new Present();
        assertEquals("", present.getName());
        assertTrue(present.getListOfCandies().isEmpty());
    }

    @Test
    public void shouldCreatePresentWithCandies(){
        createPresent();
        assertEquals(candies, present.getListOfCandies());
    }

    @Test
    public void shouldRenamePresent(){
        createPresent();
        present.setName("Deliciiious");
        assertEquals("Deliciiious", present.getName());
    }


    @Test
    public void shouldCAddMarshmallowToPresent(){
        createPresent();
        Candy marshmallow = new Marmalade(Color.RED, 60.0f, 290.0);
        present.addCandy(marshmallow);
        assertTrue(present.getListOfCandies().contains(marshmallow));
        assertEquals(present.getListOfCandies().size(), 5);
    }

    @Test
    public void shouldRemoveChocolateFromPresent(){
        createPresent();
        present.removeCandy("Chocolate");
        assertFalse(present.getListOfCandies().contains(new Chocolate(Color.BLACK, 10.0f, 300.0)));
    }

    @Test
    public void shouldSortCandiesFromLowToHigh(){
        createPresent();
        present.sortCandies(new CandyComparator());
        assertEquals(present.getListOfCandies(), Arrays.asList(
                new Chocolate(Color.BLACK, 10.0f, 300.0),
                new Marmalade(Color.PINK, 40.0f, 150.0),
                new Marshmallow(Color.WHITE, 55.0f, 80.0),
                new Lollipop(Color.RED, 80.0f, 20.0)
        ));
    }

    @Test
    public void shouldFindCandiesInInterval(){
        createPresent();
        List<Candy> result = present.findCandiesInSugarAmountInterval(30,60);
        assertEquals(result, Arrays.asList(
                new Marshmallow(Color.WHITE, 55.0f, 80.0),
                new Marmalade(Color.PINK, 40.0f, 150.0)));
    }

}