package at.ac.tgm.dlengsteiner.persistence;

import at.ac.tgm.dlengsteiner.model.WordImagePair;
import at.ac.tgm.dlengsteiner.model.Worttrainer;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;

/**
 * Saves and reads CSV-files of WorttrainerSession-Objects
 * @author Daniel Lengsteiner
 * @version 2023-12-06
 */
public class JSONType implements SaveType{

    private static final String standardPath =  "./worttrainerSession.json";

    /**
     * Reads WorttrainerSession-Object as JSON at the path ./.sessionData/worttrainerSession.json
     * @return the session
     */
    @Override
    public WorttrainerSession readSession() {
        return readSession(standardPath);
    }

    /**
     * Reads WorttrainerSession-Object as JSON
     * @param filename custom filepath to read from
     * @return the session
     */
    @Override
    public WorttrainerSession readSession(String filename) {
        try(InputStream is = JSONType.class.getResourceAsStream(filename)) {
            assert is != null;
            JSONObject jo = new JSONObject(new JSONTokener(is));
            int correct = jo.getInt("correct");
            int incorrect = jo.getInt("incorrect");
            int currentPairIndex = jo.getInt("currentPairIndex");

            JSONArray array = jo.getJSONArray("pairs");
            WordImagePair[] pairs = new WordImagePair[array.length()];
            for (int i = 0; i < array.length(); i++) {
                JSONObject temp = array.getJSONObject(i);
                pairs[i]=new WordImagePair(temp.getString("word"), temp.getString("url"));
            }

            Worttrainer t = new Worttrainer(pairs);
            t.setCorrect(correct);
            t.setIncorrect(incorrect);
            return new WorttrainerSession(t, currentPairIndex);

        }catch (IOException exception){
            System.err.println("Error while reading file!\n" + exception.getMessage());
        }

        return null;
    }

    /**
     * Saves WorttrainerSession-Object as JSON at the path ./.sessionData/worttrainerSession.json
     * @param session the session
     */
    @Override
    public void saveSession(WorttrainerSession session) {
        saveSession(session, standardPath);
    }

    /**
     * Saves WorttrainerSession-Object as JSON
     * @param session the session
     * @param filename custom filepath to save to
     */
    @Override
    public void saveSession(WorttrainerSession session, String filename) {
        JSONObject jo1 = new JSONObject();
        jo1.put("currentPairIndex",session.getCurrentPairIndex());
        jo1.put("correct",session.getTrainer().getCorrect());
        jo1.put("incorrect",session.getTrainer().getIncorrect());

        JSONArray ja1 = new JSONArray();
        for (WordImagePair p: session.getTrainer().getWordImagePairs()){
            JSONObject jo2 = new JSONObject();
            jo2.put("url",p.getUrl());
            jo2.put("word",p.getWord());
            ja1.put(jo2);
        }

        jo1.put("pairs",ja1);

        try {
            FileWriter file = new FileWriter(filename);
            file.write(jo1.toString());
            file.flush();
            file.close();
        } catch (IOException e) {
            System.err.println("Error while saving file!\n" + e.getMessage());
        }
    }
}
