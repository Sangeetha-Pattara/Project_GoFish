/*
 * Sangeetha Pattara
 * 991575884
 * SYST10199 - Web Programming
 */
package project;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Sangeetha Pattara, April 2020
 */

//this class is to craete a pack of 52 playing cards and to shuffle 
//them to start the game
public class NewGroupOfCards extends GroupOfCards{
    //The group of cards, stored in an ArrayList
    private ArrayList <Card> cardsnew = new ArrayList <Card>();
    private int size;//the size of the grouping
    
    
    public NewGroupOfCards(int givenSize)
    {
        super(givenSize);
    }
    public void shuffle(){
        super.setCards(cardsnew);
        super.shuffle();
    }
    
    /**
     * A method that will get the group of 52 cards as an ArrayList
     * @return the full pack of 52 cards     
     */
    public ArrayList <Card> generateCards(){
               
        for(CardGoFish.Suits s: CardGoFish.Suits.values()){
                 
            for(CardGoFish.Values v : CardGoFish.Values.values()){
            CardGoFish card = new CardGoFish(s,v);
                cardsnew.add(card);
            }
        }
        
        return cardsnew;
    }
    
    
}
