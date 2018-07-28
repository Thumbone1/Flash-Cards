

package flashcards.util;

import flashcards.domain.Genre;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Thumbone1
 */
public class SaveState implements Serializable {
    private List<Genre> genres;
    
    public SaveState() {
        this.genres = new ArrayList<>();
    }
    
    public void addGenre(Genre genre) {
        genres.add(genre);
    }
    
    public void removeGenre(Genre genre) {
        genres.remove(genre);
    }

}
