/*
 * Sangeetha Pattara
 * 991575884
 * SYST10199 - Web Programming
 */
package project;

/**
 *
 * @author Sangeetha Pattara, April 2020
 */

//this class is a subclass of Card.java, to create a pack of 52 playing cards 
//with 4 suits and 13 face values
public class CardGoFish extends Card{
   public enum Suits{CLUBS,SPADES,DIAMONDS,HEARTS};
   public enum Values{ACE,TWO,THREE,FOUR,FIVE,SIX,SEVEN,EIGHT,NINE,
   KING,QUEEN,JACK,JOCKER};
   
    //constructor
    public CardGoFish(Suits s,Values v){       
        super.setSuit(s.toString());
        super.setValue(v.ordinal()+1);
     }
     
   
    
    public  String toString(){
        
       return Suits.values().toString();
    } 

  
    
    
}
