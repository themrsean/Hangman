/*
 * SE1011 - 031
 * Fall 2017
 * Week 9 - Hangman!
 * Name: Sean Jones
 * Created: 10/23/2017
 * Last Updated: 11/1/2017
 */
package Week10;

import java.util.Scanner;

/**
 * The game of Hangman!
 * Go to https://www.randomlists.com/random-words to generate 100 random words to use for this program
 */
public class Hangman {
    final private static int MAX_WRONG_GUESSES = 8;

    private static Scanner in = new Scanner(System.in);
    private static String[] words = null;

    public static void main(String[] args) {
        getWords();
        addWords();
        intro();
        do {
            play(chooseWord());
        } while(playAgain());
        System.out.println("Buh-bye!");
    }

    /*
     * This method displays the intro text and rules of the game
     */
    private static void intro() {
        System.out.println();
        System.out.println("Welcome to Hangman 3000!\n========================");
        System.out.println("In this game you will be given the number of letters contained in " +
        "a hidden word.");
        System.out.println("You will then be asked to guess letters contained in the word.");
        System.out.println("You will be allowed eight incorrect guesses before you lose the game.");
        System.out.println("If you guess all of the letters in the word, you win!");
    }

    /*
     * This method will set the game up to play. It will instantiate the String array with a length
     * based on user input. For this lab, use 100 words.
     */
    private static void getWords() {
        System.out.print("How many words?");
        words = new String[in.nextInt()];
        in.nextLine(); // clearing the Scanner buffer
    }

    /*
     * This method will take, one at a time, words from the user until the array is full.
     */
    private static void addWords() {
        System.out.println("Enter your list of words. Separate each word with a new line.");
		// TODO
    }

    /*
     * This helper method will choose a random word for the user to guess
     */
    private static String chooseWord() {
        return words[(int) (Math.random() * words.length) + 1];
    }

    /*
     * This method is the actual game of Hangman.
     */
    private static void play(String word) {
        char[] display = makeStars(word).toCharArray(); // the word "hidden" by asterisks
        boolean guessed;// if the user has successfully guessed the word
        String guess;
        int numWrongGuesses = 0;

        do {
            System.out.println("Current word: " + display(display));
            System.out.println("Number of guesses left: " + (MAX_WRONG_GUESSES - numWrongGuesses));
            System.out.print("Guess a letter: ");

            guess = in.nextLine();
            numWrongGuesses += verify(compare(guess, word, display)); // increments on incorrect guess
            guessed = equals(word, display);
        } while(numWrongGuesses != MAX_WRONG_GUESSES && !guessed);
        report(word, numWrongGuesses, guessed);
    }

    /*
     * This method will take a given String and create a new String of the same length
     * of all asterisks (*)
     */
    private static String makeStars(String word) {
		// TODO
    }

    /*
     * This helper method generates the String to be displayed to the user from the char[] array
     */
    private static String display(char[] display) {
		// TODO
    }

    /*
     * This helper method checks to see if the guessed letter appears in the target word.
     * It will "uncover" the correct letter(s), if guessed.
     * @return true if the letter exists, false otherwise
     */
    private static boolean compare(String guess, String word, char[] display) {
		// TODO
    }

    /*
     * This helper method is used to increment the number of wrong guesses.
     * @param boolean whether the last guess made was correct or not
     * @return 1 if the guess was incorrect, 0 if it was correct
     */
    private static int verify(boolean correct) {
        if(!correct) {
            return 1;
        }
        return 0;
    }

    /*
     * This helper method checks to see if the word has been completely guessed
     * @return true if the word has been guessed, false otherwise.
     */
    private static boolean equals(String word, char[] display) {
		// TODO
    }

    /*
     * This helper method displays the appropriate message based on the results of the game.
     */
    private static void report(String word, int numWrongGuessed, boolean guessed) {
        if(guessed){
            System.out.println("Congrats! You guessed \"" + word + "\" with " +
                    (MAX_WRONG_GUESSES - numWrongGuessed) + " guesses to go!");
        } else {
            System.out.println("You failed to guess \"" + word + "\" in " + MAX_WRONG_GUESSES + " guesses.");
            System.out.println("You really suck!");
        }
    }

    /*
     * This helper method asks the user if they would like to play again
     * @return true if y, false if n
     */
    private static boolean playAgain() {
        String answer;
        do {
            System.out.print("Play again? (y/n)");
            answer = in.nextLine();
        } while(!(answer.equals("y") || answer.equals("n")));
        return(answer.equals("y"));
    }
}
