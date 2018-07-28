

package flashcards.util;

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
    public static final File SAVE_FILE = new File("program.txt");
            
    public static void writeToFile(File file, SaveState saveState) {
        
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            
            try (FileOutputStream f = new FileOutputStream(file); 
                 ObjectOutputStream o = new ObjectOutputStream(f)) {
                
                o.writeObject(saveState);
                
                o.close();
                f.close();
                
            }
            
        } catch(IOException e) {
            System.out.println("IOException! " + e);
        } 
        
    }
        
    public static SaveState initializeGenre(File file) {
        
        if (!file.exists()) {
            return new SaveState();
        }
        
      
        try (FileInputStream fi = new FileInputStream(file);
             ObjectInputStream oi = new ObjectInputStream(fi)){
            
            SaveState saveState = (SaveState) oi.readObject();
            
            oi.close();
            fi.close();
            
            return saveState;
            
        } catch (NumberFormatException | IOException | ClassNotFoundException e) {
            System.out.println("Exception occured!\n " + e);
        }
        
        return new SaveState();
    }
    
    public static boolean deleteFile(File file) {        
        return file.delete();        
    }
    
    

}
