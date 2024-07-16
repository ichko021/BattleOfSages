package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class GameLogic {

    private ArrayList<Sage> listOfCharacters;
    Scanner scanner = new Scanner(System.in);


    public GameLogic() {
        this.listOfCharacters = new ArrayList<>();
    }

    public void gameSequence() {

        createCharacters();
        initiateGame();

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

        while(true) {
            for(Sage sage: listOfCharacters) {
                if(sage.getHealth() == 0) {
                    System.out.println("Game is over.");
                    break;
                }

                int randomNum = generateRandomNum();

                questions.printOutRandomQuestion(randomNum);

                int answer = Integer.valueOf(scanner.nextLine());

                int points = questions.answerQuestion(answer, randomNum, listOfCharacters.get(0).getName());

                if(points == -1) {
                    sage.setHealth(points);
                }
            }
        }


    }

    public int generateRandomNum() {

        return (int) (Math.random() * 10);

    }
}


