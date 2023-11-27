package model;

import javax.swing.*;
import java.net.URL;

/**
 * Application to display images which have to be correctly labeled by the user.
 * @author Daniel Lengsteiner
 * @version 1.1
 */
public class Worttrainer {
    private WordImagePair[] wordImagePairs;
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
     * Reset the statistic
     */
    public void reset(){
        this.incorrect=0;
        this.correct=0;
    }

    /**
     * Gets the array of WordImagePair-Objects
     * @return the array of WordImagePair-Objects
     */
    public WordImagePair[] getWordImagePairs() {
        return wordImagePairs;
    }

    public static void main(String[] args) {
        WordImagePair a = new WordImagePair("Schmetterling", "https://cdn.pixabay.com/photo/2023/10/06/20/12/thailand-8299045_960_720.jpg");
        WordImagePair b = new WordImagePair("Tiger", "https://cdn.pixabay.com/photo/2023/10/31/23/06/tiger-8356190_960_720.jpg");
        Worttrainer t = new Worttrainer(new WordImagePair[]{a,b});
        for (int i = 0; true; i++){
            JOptionPane.showInputDialog(null, new ImageIcon(t.getWordImagePairs()[i].getURL()));
        }
    }
}
