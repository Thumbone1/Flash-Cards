

package flashcards.ui;

import flashcards.domain.Cardable;
import flashcards.domain.Deck;
import flashcards.domain.Genre;
import flashcards.domain.LanguageCard;
import flashcards.util.FileAssistant;
import flashcards.util.TextReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Thumbone1
 */
public class FlashcardsTextUI {
    private TextReader reader;
    private Map<String, Genre> genres;
    private Genre currentGenre;
    private Deck currentDeck;

    public FlashcardsTextUI() {
        this.reader = new TextReader();      
        this.genres = new HashMap<>();
    }
    
    public void start() {
        chooseGenre();
        chooseDeck();
        optionMenu();
        
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
                case 4:
                    deleteCard();
                    break;
                case 5:
                    optionMenu();
                    break;
                case 6:
                    showAllCards();
                    break;
                    
            }
        }
    }

    private void optionMenu() {
        System.out.println(
                "1. test yourself\n"        + 
                "2. add new card\n"         + 
                "3. edit card\n"            +
                "4. delete card\n"          +
                "5. show options\n"         +
                "6. show all cards\n"       +
                "0. exit");
    }

    private void test() {
        
        System.out.println("enter to quit");
        while (true) {
            
            for (Cardable card : currentDeck.getCards()) {
                System.out.println(card.getFront());
                System.out.print("meaning: ");
                String response = reader.readString();
                
                if (response.equals("")) {
                    break;
                }
                
                if (card.getBack().contains(response)) {
                    System.out.println("Correct!");
                    System.out.println("\t" + card.getBack());
                } else {
                    System.out.println("Incorrect! :(");
                    System.out.println("\t" + card.getBack());
                }
                
                spacer();
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
        
        currentDeck.add(new LanguageCard(word, meaning));
        
        System.out.println(word + " added!");
        saveCurrentGenre();
    }

    private void editCard() {
        System.out.println("Not supported yet.");
    }
    
    private void spacer() {
        System.out.println("\n");
    }

    private void exit() {
        reader.close();
        System.exit(0);
    }
    
    private void saveCurrentGenre() {
        FileAssistant.writeToFile(currentGenre.getTitle(), currentGenre);
    }

    private void deleteCard() {
        System.out.println("Not supported yet");
    }

    private void showAllCards() {
        for (Cardable card : currentDeck.getCards()) {
            System.out.println(card);
        }
    }
    
    private void createGenre() {
        System.out.print("What is the name of this new genre? ");
        String genreName = reader.readString();
        
        Genre newGenre = new Genre();
        newGenre.setTitle(genreName);
        genres.put(genreName, newGenre);
        currentGenre = genres.get(genreName);
        
    }
    
    private void addDeckToGenre() {
        System.out.println("What would you like to name this new Deck?");
        String newKey = reader.readString();
        
        currentGenre.addDeck(newKey, new Deck());
        currentDeck = currentGenre.getDeck(newKey);
        
    }

    private void chooseGenre() {
        if (!genres.isEmpty()) {
            for (String key : genres.keySet()) {
                System.out.println(key);
            }
            
            System.out.println("\nWhich genre would you like to study?");
            String key = reader.readString();
            
            currentGenre = genres.get(key);
            
        } else {
            System.out.println("Please add a genre first!");
            createGenre();
        }
    }

    private void chooseDeck() {
        if (currentGenre.isEmpty()) {
            System.out.println("Genre does not have any cards in it");
            addDeckToGenre();
            
        } else {            
            for (String key : currentGenre.getDecks().keySet()) {
                System.out.println(key);
            }

            System.out.println("which deck would you like to study?");
            String key = reader.readString();

            currentDeck = currentGenre.getDeck(key); 
        }
    }
}
