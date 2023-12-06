package at.ac.tgm.dlengsteiner.persistence;

/**
 * Manages saving and reading of WorttrainerSession-Objects from files
 * @author Daniel Lengsteiner
 * @version 2023-12-06
 */
public class SessionManager {
    private final SaveType saveType;

    public SessionManager(SaveType saveType){
        this.saveType=saveType;
    }

    WorttrainerSession read(){
        return saveType.readSession();
    }

    WorttrainerSession read(String filename){
        return saveType.readSession(filename);
    }

    void save(WorttrainerSession session){
        saveType.saveSession(session);
    }

    void save(WorttrainerSession session, String filename){
        saveType.saveSession(session, filename);
    }
}
