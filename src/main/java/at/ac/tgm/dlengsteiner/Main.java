package at.ac.tgm.dlengsteiner;

import at.ac.tgm.dlengsteiner.model.WordImagePair;
import at.ac.tgm.dlengsteiner.model.Worttrainer;
import at.ac.tgm.dlengsteiner.persistence.JSONType;
import at.ac.tgm.dlengsteiner.persistence.SessionManager;
import at.ac.tgm.dlengsteiner.persistence.WorttrainerSession;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SessionManager manager = new SessionManager(new JSONType());
        Worttrainer t = new Worttrainer();
        int currentPairIndex = 0;

        String filename = JOptionPane.showInputDialog(null, "Load save file from location (no input retrieves file from standard location):");
        try {
            WorttrainerSession session;
            if (filename == null) session = new WorttrainerSession(t, currentPairIndex);
            else if (filename.isEmpty()) session = manager.read();
            else session = manager.read(filename);
            if (session != null){
                currentPairIndex = session.getCurrentPairIndex();
                t = session.getTrainer();
            }
        } catch (NullPointerException exception){System.out.println("No file specified. Starting new program...");}
        int length = t.getWordImagePairs().length;
        String input = "";
        String lastInput = "No Data";
        WordImagePair[] pairs = t.getWordImagePairs();

        for (int i = currentPairIndex; i<length; i++){
            while (!input.equals(pairs[i].getWord())){
                input = JOptionPane.showInputDialog(null,
                        new Object[]{
                                new ImageIcon(pairs[i].getURL()),
                                "Correct Inputs: " + t.getCorrect(),
                                "Incorrect Inputs: " + t.getIncorrect(),
                                "Last Input: " + lastInput
                        });
                if (input == null){
                    JOptionPane.showMessageDialog(null, "Program aborted. Goodbye!");
                    return;
                }
                if (input.isEmpty()) {
                    filename = JOptionPane.showInputDialog(null, "Save progress to location (no input saves file to standard location)");
                    if (filename.isEmpty()) manager.save(new WorttrainerSession(t, i));
                    else manager.save(new WorttrainerSession(t, i),filename);
                    return;
                }
                if (!input.equals(pairs[i].getWord())) {
                    t.addIncorrect();
                    lastInput = "Incorrect";
                }
            }
            t.addCorrect();
            lastInput = "Correct";
        }
    }
}