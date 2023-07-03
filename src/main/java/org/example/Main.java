package org.example;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        int One = rand.nextInt(1, 7);
        int Two = rand.nextInt(1, 7);
        int Three = rand.nextInt(1, 7);
        System.out.println("Welcome to Nim!");
        System.out.println("Enter Player Names");
        String playerA = scanner.nextLine();
        String playerB = scanner.nextLine();
        System.out.println("Hello, " + playerA);
        System.out.println("Hello, " + playerB);

        String activePlayer = playerA;

        while (One > 0 || Two > 0 || Three > 0) {
            System.out.println("One: " + One);
            System.out.println("Two: " + Two);
            System.out.println("Three: " + Three);

            System.out.println(activePlayer + "'s Choice of Pile");
            String pileChoice = scanner.nextLine();

            int availableItems;
            if (pileChoice.equals("One")) {
                availableItems = One;
            } else if (pileChoice.equals("Two")) {
                availableItems = Two;
            } else {
                availableItems = Three;
            }

            while (availableItems == 0) {
                System.out.println("Invalid choice. Please select a pile with items.");
                pileChoice = scanner.nextLine();

                if (pileChoice.equals("One")) {
                    availableItems = One;
                } else if (pileChoice.equals("Two")) {
                    availableItems = Two;
                } else {
                    availableItems = Three;
                }
            }

            System.out.println(activePlayer + "'s Choice of How Many To Take");
            int choice = Integer.parseInt(scanner.nextLine());

            while (choice < 1 || choice > availableItems) {
                System.out.println("Invalid choice. Please select a number between 1 and " + availableItems);
                choice = Integer.parseInt(scanner.nextLine());
            }

            if (pileChoice.equals("One")) {
                One -= choice;
            } else if (pileChoice.equals("Two")) {
                Two -= choice;
            } else {
                Three -= choice;
            }

            // Switch active player for the next turn
            activePlayer = (activePlayer.equals(playerA)) ? playerB : playerA;
        }

        // Determine the loser based on the final state of the piles
        String loser = activePlayer;
        System.out.println("Game Over");
        System.out.println(loser + " loses!");
    }
}
