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
     * Sets the number of correct guesses
     * @param correct the number of correct guesses
     */
    public void setCorrect(int correct) {
        this.correct = correct;
    }

    /**
     * Sets the number of incorrect guesses
     * @param incorrect the number of incorrect guesses
     */
    public void setIncorrect(int incorrect) {
        this.incorrect = incorrect;
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
}
