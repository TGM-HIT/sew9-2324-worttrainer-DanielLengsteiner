package at.ac.tgm.dlengsteiner.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class WorttrainerTest {
    /**
     * Checks if any URL from the array of WordImagePair-Objects in class WordImagePairs is invalid
     */
    @Test
    public void urlValidityTest(){
        for (WordImagePair x:WordImagePairs.PAIRS) {
            assertNotNull(x.getURL());
        }
    }

    @Test
    public void worttrainerRunTest(){
        Worttrainer t = new Worttrainer();
        WordImagePair[] pairs = t.getWordImagePairs();
        int length = pairs.length;

        for (int i = 0; i<pairs.length; i++)
            assertEquals(WordImagePairs.PAIRS[i].getWord(), pairs[i].getWord());
        t.addCorrect();
        t.addCorrect();
        t.addIncorrect();
        assertEquals(2, t.getCorrect());
        assertEquals(1, t.getIncorrect());
    }
}
