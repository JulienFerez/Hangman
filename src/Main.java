import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main (String[] args) throws Exception{

        System.out.println("Welcome to hangman");

        // Reading the file
 File dictionary = new File("/Users/10092073/Desktop/ProjetsPerso/Hangman/src/dictionary.txt");
 Scanner textScanner = new Scanner(dictionary);
        // Reading the user input
 Scanner input = new Scanner(System.in);
        // Creation of a ArrayList
        ArrayList<String> words = new ArrayList<>();
        // Adding words to the file
    while(textScanner.hasNextLine()) {
        words.add(textScanner.nextLine());
    }
        // Selection of a random word
 String hidden_text = words.get((int)(Math.random()*words.size()));
    System.out.println(hidden_text);
        // Convert the string to an array of characters
 char[] textArray = hidden_text.toCharArray();
        // ??
 char[] myAnswers = new char[textArray.length];
 for (int i = 0; i < textArray.length ; i++){
     myAnswers[i]= '?';
 }
boolean finished = false ;
 int lives = 6 ;
 while (finished == false) {
     System.out.println("*******************************************");
     System.out.println("Please, Type a letter :");
     // Return the input
     String letter = input.next();
     // checks for valid input -  If the input is not 1 and the first character is a letter
     while (letter.length() != 1 || Character.isDigit(letter.charAt(0))) {
         System.out.println("Error Input, Try Again");
         letter = input.next();
     }

     boolean found = false;
     // checks if the letter is in the word
     for (int i = 0; i < textArray.length; i++) {
         if (letter.charAt(0) == textArray[i]) {
             myAnswers[i] = textArray[i];
             found = true;
             System.out.println("Good ! ");
         }
     }
     if (!found) {
         lives--;
         System.out.println("Wrong Letter");
     }

     boolean done = true;
     for (int i = 0; i < myAnswers.length; i++) {
         if (myAnswers[i] == '?') {
             System.out.print(" _");
             done = false;
         } else {
             System.out.print(" " + myAnswers[i]);
         }
     }
         System.out.println("\n" + "Lives left" + lives);
         drawHangman(lives);
         // Checks if the game ends
         if (done) {
             System.out.println("Congrats you find the word");
             finished = true;
         }
         if (lives <= 0) {
             System.out.println("You are dead ! Study your french");
             finished = true;
         }

    // System.out.println(hidden_text);
 }

     }

    private static void drawHangman(int l) {
        if (l == 6) {
            System.out.println ("| ----------");
            System.out.println ("|");
            System.out.println ("|");
            System.out.println ("|");
            System.out.println ("|");
            System.out.println ("|");
            System.out.println ("|");
        }
        else if (l == 5) {
            System.out.println ("| ----------");
            System.out.println ("| O");
            System.out.println ("|");
            System.out.println ("|");
            System.out.println ("|");
            System.out.println ("|");
            System.out.println ("|");
        }
        else if (l == 4) {
            System.out.println ("| ----------");
            System.out.println ("| O");
            System.out.println ("| |");
            System.out.println ("|");
            System.out.println ("|");
            System.out.println ("|");
            System.out.println ("|");
        }
        else if (l == 3) {
            System.out.println ("| ----------");
            System.out.println ("|   O");
            System.out.println ("| - |");
            System.out.println ("|");
            System.out.println ("|");
            System.out.println ("|");
            System.out.println ("|");
        }
        else if (l == 2) {
            System.out.println ("| ----------");
            System.out.println ("|   O");
            System.out.println ("| - | -");
            System.out.println ("|");
            System.out.println ("|");
            System.out.println ("|");
            System.out.println ("|");
        }
        else if (l == 1) {
            System.out.println ("| ----------");
            System.out.println ("|   O");
            System.out.println ("| - | -");
            System.out.println ("|  |");
            System.out.println ("|");
            System.out.println ("|");
            System.out.println ("|");
        }
        else{
            System.out.println ("| ----------");
            System.out.println ("|   O");
            System.out.println ("| - | -");
            System.out.println ("|  | |");
            System.out.println ("|");
            System.out.println ("|");
            System.out.println ("|");
        }
    }
}



