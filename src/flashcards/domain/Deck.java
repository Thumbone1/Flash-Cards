

package flashcards.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thumbone1
 */
public class Deck implements Serializable {
    private List<Cardable> cards;
    private String name;

    public Deck() {
        this.cards = new ArrayList<>();
    }
    
    public void add(Cardable cardable) {
        this.cards.add(cardable);
    }
    
    public List<Cardable> getCards() {
        return cards;
    }
    
    public String showFront(Cardable cardable) {
        return cardable.getFront();
    }
    
    public String showBack(Cardable cardable) {
        return cardable.getBack();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    

}
