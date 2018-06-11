

package flashcards.ui;

import flashcards.domain.Cardable;
import flashcards.domain.Deck;
import flashcards.domain.LanguageCard;
import flashcards.util.FileAssistant;
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
        this.deck = FileAssistant.initializeDeck(FileAssistant.DECK_FILE);        
    }
    
    public void start() {
        welcomeMessage();
        
        while (true) {
            spacer();
            System.out.print("command: ");
            int ans = reader.readInteger();
        
            switch(ans) {
                case 0:
                    exit();
                    break;
                case 1:
                    test();
                    break;
                case 2:
                    addCard();
                    break;
                case 3:
                    editCard();
                    break;
            }
        }
        
        
    }

    private void welcomeMessage() {
        System.out.println(
                "1. test yourself\n" + 
                "2. add new word\n"+ 
                "3. edit old word\n" +
                "0. exit");
    }

    private void test() {
        System.out.println("0 to quit");
        while (true) {
            
            for (Cardable card : deck.getCards()) {
                System.out.println(card.getFront());
                System.out.print("meaning: ");
                String response = reader.readString();
                if (response.equals("0")) {
                    break;
                }
                if (response.contains(card.getBack())) {
                    System.out.println("Correct!");
                } else {
                    System.out.println("Incorrect! :(");                    
                }
            }
            System.out.println("Testing complete!");
            break;
        }
        
    }

    private void addCard() {
        System.out.print("what is the word you'd like to add? ");
        String word = reader.readString();
        System.out.print("what is the meaning of " + word + "? ");
        String meaning = reader.readString();
        deck.add(new LanguageCard(word, meaning));
        System.out.println(word + " added!");
    }

    private void editCard() {
        System.out.println("Not supported yet.");
    }
    
    private void spacer() {
        System.out.println("\n");
    }

    private void exit() {
        System.out.println("Saving flash cards...");
        FileAssistant.writeToFile(FileAssistant.DECK_FILE, deck);
        System.exit(0);
    }
}
