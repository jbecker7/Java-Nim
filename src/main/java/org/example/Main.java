package org.example;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void wait(int ms) {
        try {
            System.out.println(" ");
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        System.out.println("Welcome to Nim!");
        wait(1000);
        System.out.println("How many piles?");
        wait(1000);
        int pileNumber = Integer.parseInt(scanner.nextLine());
        int[] piles = new int[pileNumber];
        for (int i = 0; i < pileNumber; i++) {
            piles[i] = rand.nextInt(1, 7);
        }
        wait(1000);
        System.out.println("Enter Player Names");
        String playerA = scanner.nextLine();
        String playerB = scanner.nextLine();
        wait(1000);
        System.out.println("Hello, " + playerA);
        wait(1000);
        System.out.println("Hello, " + playerB);
        wait(1000);

        String activePlayer = playerA;

        while (true) {
            // Check if all piles are empty
            int check = 0;
            for (int pile : piles) {
                check += pile;
            }

            if (check < 1) {
                break; // Game ends when all piles are empty
            }

            for (int i = 0; i < pileNumber; i++) {
                System.out.println("Pile " + (i + 1) + ": " + piles[i]);
            }
            wait(1000);

            System.out.println(activePlayer + "'s Choice of Pile");
            int pileChoice = Integer.parseInt(scanner.nextLine());

            int availableItems;
            availableItems = piles[pileChoice - 1];

            while (availableItems == 0) {
                System.out.println("Invalid choice. Please select a pile with items.");
                int pileChoice2 = Integer.parseInt(scanner.nextLine());
                availableItems = piles[pileChoice2 - 1];
                pileChoice = pileChoice2; // Update pileChoice with the new valid choice
            }

            System.out.println(activePlayer + "'s Choice of How Many To Take");
            int choice = Integer.parseInt(scanner.nextLine());

            while (choice < 1 || choice > availableItems) {
                System.out.println("Invalid choice. Please select a number between 1 and " + availableItems);
                choice = Integer.parseInt(scanner.nextLine());
            }

            piles[pileChoice - 1] -= choice;

            // Switch active player for the next turn
            activePlayer = (activePlayer.equals(playerA)) ? playerB : playerA;
        }

        // The activePlayer at this point is the loser, because the game ended on their
        // turn
        System.out.println("Game Over");
        System.out.println(activePlayer + " wins!");
    }
}
