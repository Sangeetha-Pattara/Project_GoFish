/*
 * Sangeetha Pattara
 * 991575884
 * SYST10199 - Web Programming
 */
package project;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Sangeetha Pattara, April 2020
 */

//this is a subclass of abstract class Game.java
public class GoFish extends Game {

    private ArrayList<CardGoFish> cardPack = new ArrayList<CardGoFish>();
    private ArrayList<Card> hand1 = null;
    private ArrayList<Card> hand2 = null;
    ArrayList<Card> fullHand52 = null;
    private String currentPlayer = null;
    private boolean gameEnd = false;
    BookOfCards bookPlayer1 = new BookOfCards();
    BookOfCards bookPlayer2 = new BookOfCards();
    private int numPlayer;
    //constructor
    public GoFish(String givenName) {
        super(givenName);
    }

    
   // Here we are adding 2 players to the ArrayList
    public void addPlayers(ArrayList playerList) {

        setPlayers(playerList);

    }

    public void setNumPlayer(int numPlayer) {
        this.numPlayer = numPlayer;
    }

    //Two hands of 7 cards are created for 2 players. If we want more player, 
    //this method can be modified
    public void createHands() {
        NewGroupOfCards newGrp = new NewGroupOfCards(52);
        newGrp.shuffle();
        fullHand52 = newGrp.generateCards();

        //Generate hand1(7 cards) for Player 1
        GoFishHand handPlayer1 = new GoFishHand(7);
        hand1 = handPlayer1.generateHand(fullHand52);
       

        //To remove the hand1 (7 cards) from total pack
        fullHand52.removeAll(hand1);

        //Generate hand2(7 cards) for Player 2
        GoFishHand handPlayer2 = new GoFishHand(7);
        hand2 = handPlayer2.generateHand(fullHand52);
       

        //To remove the hand2 (7 cards) from total pack
        fullHand52.removeAll(hand2);
       

    }
    
    //defining the method play() in the abstract class Game.java
    public void play() {

        switch (numPlayer) {
            case 2:

                currentPlayer = "player1";
                printHand("Computer's", hand1);
                printHand("Your", hand2);
                //game continues till gameEnd becomes true
                while (gameEnd != true) {
                    //coding for the computer as the player
                    while (currentPlayer.equalsIgnoreCase("player1")) {
                        if (hand1.size() == 0) {
                            gameEnd = true;
                            break;
                        }
                        Card rdmSelection = GoFishHand.selectRandomCardFromHand(hand1);
                        ArrayList<Card> hand1Match = askCardFromOtherPlayer(rdmSelection, hand2);

                        if (hand1Match.size() > 0) {
                            hand2.removeAll(hand1Match);
                            hand1.addAll(hand1Match);
                            printHand("Computer's", hand1);
                            printHand("Your", hand2);

                            if (BookOfCards.checkIfBookInHand(hand1) == true) {
                                currentPlayer = "player1";
                                System.out.println("Current Player " + currentPlayer);

                                ArrayList<Card> book1 = new ArrayList<Card>();
                                book1 = BookOfCards.findBookInHand(hand1);
                              
                                                           
                                bookPlayer1.addBookCount();
                                hand1.removeAll(book1);

                                printHand("Computer's", hand1);
                                printHand("Your", hand2);

                            } else {
                                currentPlayer = "player2";
                                System.out.println("Current Player " + currentPlayer);

                                printHand("Computer's", hand1);
                                printHand("Your", hand2);
                                break;
                            }

                        } else {
                            System.out.println("Go Fish !");

                            if (fullHand52.size() == 0) {
                                gameEnd = true;
                                break;
                            }
                            Card rdmSelection2 = GoFishHand.selectRandomCardFromHand(fullHand52);
                            fullHand52.remove(rdmSelection2);
                            hand1.add(rdmSelection2);

                            printHand("Computer's", hand1);
                            printHand("Your", hand2);

                            if (BookOfCards.checkIfBookInHand(hand1) == true) {
                                currentPlayer = "player1";
                                System.out.println("Current Player " + currentPlayer);

                                ArrayList<Card> book1 = new ArrayList<Card>();
                                book1 = BookOfCards.findBookInHand(hand1);

                                bookPlayer1.addBookCount();
                                hand1.removeAll(book1);

                                printHand("Computer's", hand1);
                                printHand("Your", hand2);

                            } else {
                                currentPlayer = "player2";
                                System.out.println("Current Player " + currentPlayer);

                                break;
                            }

                        }

                    }
                    //coding for the user as the player
                    while (currentPlayer.equalsIgnoreCase("player2")) {
                        if (hand2.size() == 0) {
                            gameEnd = true;
                            break;
                        }

                        System.out.println("Ask Card Value (1 to 13) from Computer "
                                + "(You should have atleast one in your hand) ?");

                        Scanner scanner = new Scanner(System.in);
                        int val = scanner.nextInt();

                        ArrayList<Card> hand2Match = askCardFromOtherPlayer(val, hand1);

                        if (hand2Match.size() > 0) {
                            hand1.removeAll(hand2Match);
                            hand2.addAll(hand2Match);
                            System.out.println("Adding cards with value = " + val);
                            printHand("Computer's", hand1);
                            printHand("Your", hand2);

                            if (BookOfCards.checkIfBookInHand(hand2) == true) {
                                currentPlayer = "player2";
                                System.out.println("Current Player " + currentPlayer);
                                System.out.println("Book formed for " + currentPlayer);

                                ArrayList<Card> book2 = new ArrayList<Card>();
                                book2 = BookOfCards.findBookInHand(hand2);

                                bookPlayer2.addBookCount();
                                hand2.removeAll(book2);

                                printHand("Computer's", hand1);
                                printHand("Your", hand2);

                            } else {
                                currentPlayer = "player1";
                                System.out.println("Current Player " + currentPlayer);

                                break;
                            }

                        } else {

                            System.out.println("Go Fish ! Enter YES to select Random card from Pack");
                            String ans = scanner.next();

                            if (fullHand52.size() == 0) {
                                gameEnd = true;
                                break;
                            }
                            Card rdmSelection3 = GoFishHand.selectRandomCardFromHand(fullHand52);
                            fullHand52.remove(rdmSelection3);
                            hand2.add(rdmSelection3);

                            printHand("Computer's", hand1);
                            printHand("Your", hand2);

                            if (BookOfCards.checkIfBookInHand(hand2) == true) {
                                currentPlayer = "player2";
                                System.out.println("Current Player " + currentPlayer);

                                ArrayList<Card> book2 = new ArrayList<Card>();
                                book2 = BookOfCards.findBookInHand(hand2);
                                
                                bookPlayer2.addBookCount();
                                hand2.removeAll(book2);

                                printHand("Computer's", hand1);
                                printHand("Your", hand2);

                            } else {
                                currentPlayer = "player1";
                                System.out.println("Current Player " + currentPlayer);

                                break;
                            }

                        }

                    }

                    printHand("Computer's", hand1);
                    printHand("Your", hand2);
                  

                }
                break;

        }
    }

    //to display each player's hand
    private void printHand(String player, ArrayList<Card> currentHand) {

        System.out.println(player + " Hand" + " (" + currentHand.size() + ")");

        for (int i = 0; i < currentHand.size(); i++) {
            System.out.print(currentHand.get(i).getSuit() + " " + currentHand.get(i).getValue() + " | ");
        }
        System.out.println("");
    }
    
    //to get cards for the computer player from the other player or pack 
    public ArrayList<Card> askCardFromOtherPlayer(Card requestedCard,
            ArrayList<Card> opponentPlayerHand) {
        ArrayList<Card> matchingCards = new ArrayList<Card>();

        if (currentPlayer.equals("player1")) {
            System.out.println("Do you have " + requestedCard.getValue() + " ?");
            System.out.println("Enter YES or GO FISH");
            Scanner scanner = new Scanner(System.in);
            String name = scanner.next();
        }
        
        for (int i = 0; i < opponentPlayerHand.size(); i++) {
           
            if (opponentPlayerHand.get(i).getValue() == requestedCard.getValue()) {
               
                matchingCards.add(opponentPlayerHand.get(i));
            }

        }
        return matchingCards;
    }
    
    //to get cards for the user player from the other player or pack 
    public ArrayList<Card> askCardFromOtherPlayer(int val, 
            ArrayList<Card> opponentPlayerHand) {
        ArrayList<Card> matchingCards = new ArrayList<Card>();

        System.out.println("Requested card value = " + val);
        for (int i = 0; i < opponentPlayerHand.size(); i++) {
            if (opponentPlayerHand.get(i).getValue() == val) {
               
                matchingCards.add(opponentPlayerHand.get(i));
            } 

        }
        return matchingCards;
    }

   
     /*This method  from the abtract base class is defined here to
     declare and display a winning  player.*/
     
     public void declareWinner() {
        if (bookPlayer1.countBook() > bookPlayer2.countBook()) {
            System.out.println("Player 1 is the winner !");
        } else if (bookPlayer2.countBook() > bookPlayer1.countBook()) {
            System.out.println("Player 2 is the winner !");
        } else {
            System.out.println("TIE !");
        }

        System.out.println("Player 1 - " + bookPlayer1.countBook() + " books");
        System.out.println("Player 2 - " + bookPlayer2.countBook() + " books");

    }

}
