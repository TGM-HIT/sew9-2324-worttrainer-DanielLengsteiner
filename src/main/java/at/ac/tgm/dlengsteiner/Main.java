package at.ac.tgm.dlengsteiner;

import at.ac.tgm.dlengsteiner.model.WordImagePair;
import at.ac.tgm.dlengsteiner.model.Worttrainer;
import at.ac.tgm.dlengsteiner.persistance.JSONType;
import at.ac.tgm.dlengsteiner.persistance.WorttrainerSession;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Worttrainer t = new Worttrainer();
        int length = t.getWordImagePairs().length;
        String input = "";

        for (int i = 0; i<length; i++){
            WordImagePair[] pair = t.getWordImagePairs();
            while (!input.equals(pair[i].getWord())){
                input= JOptionPane.showInputDialog(null, new ImageIcon(pair[i].getURL()));
                if (!input.equals(pair[i].getWord())) t.addIncorrect();
            }
            t.addCorrect();
        }
        //System.out.println("Correct: " + t.getCorrect() + "\nIncorrect: " + t.getIncorrect());

        JSONType type = new JSONType();
        type.saveSession(new WorttrainerSession(t, 1));
    }
}