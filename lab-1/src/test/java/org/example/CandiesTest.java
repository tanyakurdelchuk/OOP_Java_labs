package org.example;

import org.example.candies.Candy;
import org.example.candies.Color;
import org.example.candies.chocolate.Chocolate;
import org.example.candies.exceptions.NegativeSugarAmountException;
import org.example.candies.lollipop.Lollipop;
import org.example.candies.marmalade.Marmalade;
import org.example.candies.marshmallow.Marshmallow;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;


public class CandiesTest {
    @Test
    public void shouldCreateChocolate(){
        Candy chocolate = new Chocolate(Color.BLACK, 10.0f, 300.0);
        assertEquals(chocolate.getWeight(), 300.0);
        assertEquals(chocolate.getName(), "Chocolate");
    }

    @Test
    public void shouldCreateLollipop(){
        Candy lollipop = new Lollipop(Color.RED, 80.0f, 20.0);
        assertEquals(lollipop.getWeight(), 20.0);
        assertEquals(lollipop.getName(), "Lollipop");
    }

    @Test
    public void shouldCreateMarshmallow(){
        Candy marshmallow = new Marshmallow(Color.WHITE, 55.0f, 80.0);
        assertEquals(marshmallow.getWeight(), 80.0);
        assertEquals(marshmallow.getName(), "Marshmallow");
    }

    @Test
    public void shouldCreateaMarmalade(){
        Candy marmalade = new Marmalade(Color.PINK, 40.0f, 150.0);
        assertEquals(marmalade.getWeight(), 150.0);
        assertEquals(marmalade.getName(), "Marmalade");
    }


    @Test
    public void shouldRenameMarmalade(){
        Candy marmalade = new Marmalade(Color.PINK, 40.0f, 150.0);
        marmalade.setName("Tasty");
        assertEquals(marmalade.getName(), "Tasty");
    }

    @Test
    public void shouldSetNewWeight() {
        Candy chocolate = new Chocolate(Color.BLACK, 10.0f, 300.0);
        chocolate.setWeight(150.0);
        assertEquals(chocolate.getWeight(), 150.0);
    }

}
