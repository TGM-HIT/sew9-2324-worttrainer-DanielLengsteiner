package at.ac.tgm.dlengsteiner.persistance;

import at.ac.tgm.dlengsteiner.model.Worttrainer;

/**
 * Saves a Session of w Worttrainer-Object with its current WordImagePair
 * @author Daniel Lengsteiner
 * @version 2023-12-06
 */
public class WorttrainerSession {
    private final Worttrainer trainer;
    private final int currentPairIndex;

    public WorttrainerSession(Worttrainer trainer, int currentPairIndex){
        this.trainer = trainer;
        this.currentPairIndex = currentPairIndex;
    }

    public Worttrainer getTrainer() {
        return trainer;
    }

    public int getCurrentPairIndex() {
        return currentPairIndex;
    }
}
