/*
 * Sangeetha Pattara
 * 991575884
 * SYST10199 - Web Programming
 */
package project;

import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;
import project.CardGoFish.Suits;
import project.CardGoFish.Values;

/**
 *
 * @author Sangeetha Theresa Pattara, April 2020
 */
public class BookOfCardsTest {
    
    public BookOfCardsTest() {
    }
    


    /**
     * Test of addBookCount method, of class BookOfCards.
     */
    @Test
    public void testAddBookCountGood() {
        System.out.println("addBookCount");
        BookOfCards instance = new BookOfCards();
        instance.addBookCount();
        int expResult = 1;
        int result = instance.countBook();
        assertEquals(expResult, result);
        
    }
    
    /**
     * Test of countBook method, of class BookOfCards.
     */
    @Test
    public void testCountBookGood() {
        System.out.println("countBook");
        BookOfCards instance = new BookOfCards();
        int expResult = 0;
        int result = instance.countBook();
        assertEquals(expResult, result);
        
    }

    
    
    /**
     * Test of checkIfBookInHand method, of class BookOfCards.
     */
    @Test
    public void testCheckIfBookInHandGood() {
        System.out.println("checkIfBookInHand");

        CardGoFish c1 = new CardGoFish(Suits.HEARTS, Values.TWO);
        CardGoFish c2 = new CardGoFish(Suits.DIAMONDS, Values.TWO);
        CardGoFish c3 = new CardGoFish(Suits.SPADES, Values.TWO);
        CardGoFish c4 = new CardGoFish(Suits.CLUBS, Values.TWO);
        CardGoFish c5 = new CardGoFish(Suits.CLUBS, Values.KING);
        CardGoFish c6 = new CardGoFish(Suits.CLUBS, Values.SIX);
        CardGoFish c7 = new CardGoFish(Suits.CLUBS, Values.EIGHT);

        ArrayList<Card> currentHand = new ArrayList<Card>();
        currentHand.add(c1);
        currentHand.add(c2);
        currentHand.add(c3);
        currentHand.add(c4);
        currentHand.add(c5);
        currentHand.add(c6);
        currentHand.add(c7);

        boolean expResult = true;
        boolean result = BookOfCards.checkIfBookInHand(currentHand);
        assertEquals(expResult, result);
    }
    
     @Test
    public void testCheckIfBookInHandBad() {
        System.out.println("checkIfBookInHand");

        CardGoFish c1 = new CardGoFish(Suits.HEARTS, Values.TWO);
        CardGoFish c2 = new CardGoFish(Suits.DIAMONDS, Values.TWO);
        CardGoFish c3 = new CardGoFish(Suits.SPADES, Values.THREE);
        CardGoFish c4 = new CardGoFish(Suits.CLUBS, Values.TWO);
        CardGoFish c5 = new CardGoFish(Suits.CLUBS, Values.KING);
        CardGoFish c6 = new CardGoFish(Suits.CLUBS, Values.SIX);
        CardGoFish c7 = new CardGoFish(Suits.CLUBS, Values.EIGHT);

        ArrayList<Card> currentHand = new ArrayList<Card>();
        currentHand.add(c1);
        currentHand.add(c2);
        currentHand.add(c3);
        currentHand.add(c4);
        currentHand.add(c5);
        currentHand.add(c6);
        currentHand.add(c7);

        boolean expResult = false;
        boolean result = BookOfCards.checkIfBookInHand(currentHand);
        assertEquals(expResult, result);
    }

       
}
