/*
 * Sangeetha Pattara
 * 991575884
 * SYST10199 - Web Programming
 */
package project;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *This class has the main method.
 * @author Sangeetha Pattara, April 2020
 */
public class StartGame {
private ArrayList<CardGoFish> cardPack = new ArrayList<CardGoFish>();
     
     public static void main(String[] args) {
       
        //starting a new game
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the game");
        String givenName = scanner.nextLine();
        GoFish game = new GoFish(givenName);
        System.out.println("Enter the number of players");
        int numPlayer = scanner.nextInt();
        game.setNumPlayer(numPlayer); 
        game.createHands();
        System.out.println("Computer acts as Player 1");
        NewPlayer player1 = new NewPlayer("Computer");
        System.out.println("Enter the name of Player 2 which is you");
        String name = scanner.next();
        NewPlayer player2 = new NewPlayer(name);
        ArrayList<NewPlayer> playerList = new ArrayList();
        //calling method to add the 2 players to the arrayList
        game.addPlayers(playerList);
        //calling method to start game which defines the actual game
        game.play();
        //calling method to declare the winner
        game.declareWinner();
    }    
}
