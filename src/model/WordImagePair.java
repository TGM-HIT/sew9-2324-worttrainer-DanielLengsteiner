package model;

// Importing required classes
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Saves words and urls for images
 * @author Daniel Lengsteiner
 * @version 1.1
 */
public class WordImagePair {
    private String word;
    private String url;

    /**
     * Constructor
     * @param word the word describing the image
     * @param url url to the image
     */
    public WordImagePair(String word, String url){
        setUrl(url);
        setWord(word);
    }

    /**
     * Sets url to the image
     * @param url url to the image
     */
    public void setUrl(String url) {
        if(isValidURL(url))
            this.url=url;
    }

    /**
     * Sets word describing the image
     * @param word word describing the image
     */
    public void setWord(String word) {
        this.word = word;
    }

    /**
     * Gets word describing the image
     * @return word describing the image
     */
    public String getWord() {
        return word;
    }

    /**
     * Gets url to the image as a String
     * @return url to the image
     */
    public String  getUrl() {
        return url;
    }

    /**
     * Gets url to image as a URL
     * @return url to the image
     */
    public URL getURL() {
        try {
            return new URL(this.url);
        }catch (MalformedURLException e){
            return null;
        }
    }

    /**
     * Checks if URL is valid
     * @param url the URL which is checked
     * @return true if URL is valid
     */
    public boolean isValidURL(String url) {

        try {
            new URL(url).toURI();
        } catch (MalformedURLException | URISyntaxException e) {
            return false;
        }

        return true;
    }
}
