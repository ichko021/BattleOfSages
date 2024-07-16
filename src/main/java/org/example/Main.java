package org.example;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    static GameLogic gameLogic = new GameLogic();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text

        // to see how IntelliJ IDEA suggests fixing it.
        int choice;

        System.out.println("Battle of the Sages!");

        while(true) {
            System.out.println("Select option:");

            System.out.println("1. New Game");
            System.out.println("2. Quit");

            choice = Integer.valueOf(scanner.nextLine());

            if(choice == 1) {
                //initiate new game
                gameLogic.gameSequence();
            } else if(choice == 2) {
                //quit game
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }

    }
}