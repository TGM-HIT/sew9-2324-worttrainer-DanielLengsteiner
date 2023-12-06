package at.ac.tgm.dlengsteiner.model;

import javax.swing.*;

/**
 * Application to display images which have to be correctly labeled by the user.
 * @author Daniel Lengsteiner
 * @version 1.1
 */
public class Worttrainer {
    private final WordImagePair[] wordImagePairs;
    private int correct = 0;
    private int incorrect = 0;

    /**
     * Constructor
     * @param wordImagePairs an array of WordImagePair-Objects
     */
    public Worttrainer(WordImagePair[] wordImagePairs){
        this.wordImagePairs=wordImagePairs;
    }

    /**
     * Constructor with default initialisation. Uses WordImagePairs.PAIRS as value for attribute wordImagePairs
     */
    public Worttrainer() {this.wordImagePairs=WordImagePairs.PAIRS;}

    /**
     * Reset the statistic
     */
    public void reset(){
        this.incorrect=0;
        this.correct=0;
    }

    /**
     * Adds 1 to the number of correct inputs
     */
    public void addCorrect() {
        this.correct++;
    }

    /**
     * Adds 1 to the number of incorrect inputs
     */
    public void addIncorrect(){
        this.incorrect++;
    }

    /**
     * Returns number of correct guesses
     * @return number of correct guesses
     */
    public int getCorrect() {
        return correct;
    }

    /**
     * Returns number of incorrect guesses
     * @return number of incorrect guesses
     */
    public int getIncorrect() {
        return incorrect;
    }

    /**
     * Gets the array of WordImagePair-Objects
     * @return the array of WordImagePair-Objects
     */
    public WordImagePair[] getWordImagePairs() {
        return wordImagePairs;
    }

    public static void main(String[] args) {
        Worttrainer t = new Worttrainer();
        int length = t.getWordImagePairs().length;
        String input = "";

        for (int i = 0; i<length; i++){
            WordImagePair[] pair = t.getWordImagePairs();
            while (!input.equals(pair[i].getWord())){
                input=JOptionPane.showInputDialog(null, new ImageIcon(pair[i].getURL()));
                if (!input.equals(pair[i].getWord())) t.addIncorrect();
            }
            t.addCorrect();
        }
        System.out.println("Correct: " + t.getCorrect() + "\nIncorrect: " + t.getIncorrect());
    }
}
