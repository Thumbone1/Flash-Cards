

package flashcards.ui;

import flashcards.domain.Deck;
import flashcards.util.TextReader;

/**
 *
 * @author Thumbone1
 */
public class FlashcardsTextUI {
    private TextReader reader;
    private Deck deck;

    public FlashcardsTextUI() {
        this.reader = new TextReader();
        this.deck = new Deck();        
    }
    
    public void start() {
        welcomeMessage();
        System.out.print("command: ");
        
        
        
    }

    private void welcomeMessage() {
        System.out.println(
                "1. test yourself\n" + 
                "2. add new word\n"+ 
                "3. edit old word\n" +
                "0. exit\n");
    }
    
    

}
