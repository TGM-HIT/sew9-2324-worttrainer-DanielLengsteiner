package at.ac.tgm.dlengsteiner.persistance;

/**
 * Interface for Classes which save and read WorttrainerSession-Objects
 * @author Daniel Lengsteiner
 * @version 2023-12-06
 */
public interface SaveType {
    WorttrainerSession readSession();
    WorttrainerSession readSession(String filename);
    void saveSession(WorttrainerSession session);
    void saveSession(WorttrainerSession session, String filename);
}
