package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TriviaQuestions {

    private Map<String, Integer> triviaQuestionsMap;
    private ArrayList<Integer> answeredQuestions;

    public TriviaQuestions() {
        this.triviaQuestionsMap = new HashMap<>();
        this.triviaQuestionsMap.put("The Louvre was built in ____", 1190);
        this.triviaQuestionsMap.put("The Great Wall of China is approximately ____ miles long", 13171);
        this.triviaQuestionsMap.put("The Eiffel Tower was completed in ____", 1889);
        this.triviaQuestionsMap.put("The ancient city of Pompeii was buried by an eruption of Mount Vesuvius in ____", 79);
        this.triviaQuestionsMap.put("The construction of the Panama Canal was completed in ____", 1914);
        this.triviaQuestionsMap.put("The Berlin Wall fell in ____", 1989);
        this.triviaQuestionsMap.put("The Titanic sank in the year ____", 1912);
        this.triviaQuestionsMap.put("The first human to travel into space, Yuri Gagarin, made his journey in ____", 1961);
        this.triviaQuestionsMap.put("The United States declared its independence in ____", 1776);
        this.triviaQuestionsMap.put("The Roman Colosseum was completed in ____", 80);
    }

    public void printOutRandomQuestion(int num) {
        int count = 0;

        for(Map.Entry<String, Integer> entry : this.triviaQuestionsMap.entrySet()) {
            if(count == num) {
                System.out.println(entry.getKey());
                break;
            } else {
                count++;
            }
        }
    }

    public boolean answerQuestion(int answer, int num) {
        int count = 0;

        for(Map.Entry<String, Integer> entry : this.triviaQuestionsMap.entrySet()) {
            if(count == num) {
                if(answer == entry.getValue()) {
                    System.out.println("Correct answer");
                    this.triviaQuestionsMap.remove(entry.getKey());
                    return true;
                } else {
                    System.out.println("Wrong answer");
                    this.triviaQuestionsMap.remove(entry.getKey());
                    return false;
                }
            } else {
                count++;
            }
        }
        return false;
    }
}
