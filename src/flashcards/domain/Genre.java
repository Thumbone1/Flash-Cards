

package flashcards.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Thumbone1
 */
public class Genre implements Serializable {
    
    private Map<String, Deck> decks;
    private String title;
    
    public Genre() {
        this.decks = new HashMap<>();
    }
    
    public void addDeck(String key, Deck deck) {
        String correctedKey = key.toLowerCase().trim();
        decks.put(correctedKey, deck);
    }
    
    public void removeDeck(String key) {
        String correctedKey = key.toLowerCase().trim();
        if (decks.containsKey(correctedKey)) {
            decks.remove(correctedKey);
        }
    }
    
    public Deck getDeck(String key) throws NullPointerException {
        String correctedKey = key.toLowerCase().trim();        
        return decks.get(correctedKey);
    }
    
    public Map<String, Deck> getDecks() {
        return decks;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public boolean isEmpty() {
        return decks.isEmpty();
    }

}
