package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class GameLogic {

    private ArrayList<Sage> listOfCharacters;
    Scanner scanner = new Scanner(System.in);


    public GameLogic() {
        this.listOfCharacters = new ArrayList<>();
    }

    public void gameMenu() {
        int choice;
        boolean flag = true;

        System.out.println("Battle of the Sages!");

        while(flag) {
            listOfCharacters.clear();

            System.out.println("Select option:");

            System.out.println("1. New Game");
            System.out.println("2. Quit");

            choice = Integer.valueOf(scanner.nextLine());

            if(choice == 1) {
                //initiate new game
                createCharacters();
                initiateGame();
            } else if(choice == 2) {
                //quit game
                flag = false;
            } else {
                System.out.println("Invalid choice.");
            }
        }
    }

    public void createCharacters() {

        System.out.println("Number of characters to create: ");
        int num = Integer.valueOf(scanner.nextLine());

        for(int i = 0; i < num; i++) {
            System.out.println("Enter a name for character " + (i+1));
            String name = String.valueOf(scanner.nextLine());
            listOfCharacters.add(new Sage(name));
        }
    }

    public void initiateGame() {

        TriviaQuestions questions = new TriviaQuestions();
        boolean flag = true;
        int multiplier = 10;

        while(flag) {


            for (int index = 0; index < listOfCharacters.size(); index++) {
                System.out.println("Name: " + listOfCharacters.get(index).getName() + " Health: " + listOfCharacters.get(index).getHealth());

                int randomNum = generateRandomNum(multiplier);

                questions.printOutRandomQuestion(randomNum);

                int answer = Integer.valueOf(scanner.nextLine());

                boolean result = questions.answerQuestion(answer, randomNum);

                removePoints(listOfCharacters, index, result);

                multiplier = multiplier - 1;

                if (listOfCharacters.get(index).getHealth() <= 0) {

                    System.out.println("Game is over.");
                    System.out.println(listOfCharacters.get(index).getName() + "'s health has reached " + listOfCharacters.get(index).getHealth() + " points.");
                    flag = false;
                    break;
                }
            }
        }
    }

    public int generateRandomNum(int multiplier) {

        return (int) (Math.random() * multiplier);

    }

    public void removePoints(ArrayList<Sage> listOfCharacters, int characterIndex, boolean result) {

        for(int i = 0; i < listOfCharacters.size(); i++) {
            if(i != characterIndex && result == true) {
                listOfCharacters.get(i).setHealth(listOfCharacters.get(i).getHealth() - 1);
            } else if (i == characterIndex && result != true) {
                listOfCharacters.get(i).setHealth(listOfCharacters.get(i).getHealth() - 1);
            }
        }

    }

}


