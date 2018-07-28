

package flashcards.util;

import flashcards.domain.Deck;
import flashcards.domain.Genre;
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

    public static void writeToFile(String newFileName, Genre genre) {
        
        File file = new File(newFileName + ".txt");
        
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            
            try (FileOutputStream f = new FileOutputStream(file); 
                 ObjectOutputStream o = new ObjectOutputStream(f)) {
                
                o.writeObject(genre);
                
                o.close();
                f.close();
                
            }
            
        } catch(IOException e) {
            System.out.println("IOException! " + e);
        } 
        
    }
        
    public static Genre initializeGenre(File file) {
        
        if (!file.exists()) {
            return new Genre();
        }
        
      
        try (FileInputStream fi = new FileInputStream(file);
             ObjectInputStream oi = new ObjectInputStream(fi)){
            
            Genre genre = (Genre) oi.readObject();
            
            oi.close();
            fi.close();
            
            return genre;
            
        } catch (NumberFormatException | IOException | ClassNotFoundException e) {
            System.out.println("Exception occured!\n " + e);
        }
        
        return new Genre();
    }
    
    public static boolean deleteFile(File file) {        
        return file.delete();        
    }
    
    

}
