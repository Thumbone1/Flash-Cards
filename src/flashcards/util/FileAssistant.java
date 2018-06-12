

package flashcards.util;

import flashcards.domain.Deck;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Thumbone1
 */
public class FileAssistant {
    public static final File DECK_FILE = new File("deck.txt");

    public static void writeToFile(File file, Deck deck) {
        
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            
            try (FileOutputStream f = new FileOutputStream(file); 
                 ObjectOutputStream o = new ObjectOutputStream(f)) {
                
                o.writeObject(deck);
                
                o.close();
                f.close();
                
            }
            
        } catch(IOException e) {
            System.out.println("IOException! " + e);
        } 
        
    }
        
    public static Deck initializeDeck(File file) {
        
        if (!file.exists()) {
            return new Deck();
        }
        
      
        try (FileInputStream fi = new FileInputStream(file);
             ObjectInputStream oi = new ObjectInputStream(fi)){
            
            Deck deck = (Deck) oi.readObject();
            
            oi.close();
            fi.close();
            
            return deck;
            
        } catch (NumberFormatException | IOException | ClassNotFoundException e) {
            System.out.println("Exception occured!\n " + e);
        }
        
        return new Deck();
    }
    
    public static boolean deleteFile(File file) {        
        return file.delete();        
    }
    
    

}
