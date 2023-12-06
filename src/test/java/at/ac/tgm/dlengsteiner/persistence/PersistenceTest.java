package at.ac.tgm.dlengsteiner.persistence;

import at.ac.tgm.dlengsteiner.model.Worttrainer;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersistenceTest {

    /**
     * Checks if the standard save and write process works
     */
    @Test
    public void saveAndWriteTest(){
        Worttrainer t = new Worttrainer();
        t.setIncorrect(4);
        t.setCorrect(6);
        WorttrainerSession session = new WorttrainerSession(t, 2);
        SessionManager manager = new SessionManager(new JSONType());
        manager.save(session);
        WorttrainerSession session1 = manager.read();
        assertNotNull(session1);
        assertEquals(session.getCurrentPairIndex(),session1.getCurrentPairIndex());
        assertEquals(t.getCorrect(),session1.getTrainer().getCorrect());
        assertEquals(t.getIncorrect(),session1.getTrainer().getIncorrect());
        assertEquals(t.getWordImagePairs()[0].getWord(),session1.getTrainer().getWordImagePairs()[0].getWord());
    }

    @Test
    public void failedReadTest() {
        Worttrainer t = new Worttrainer();
        t.setIncorrect(4);
        t.setCorrect(6);
        WorttrainerSession session = new WorttrainerSession(t, 2);
        SessionManager manager = new SessionManager(new JSONType());
        manager.save(session);
        assertNull(manager.read("./wrongFolder/wrongFile.json"));
    }
}
