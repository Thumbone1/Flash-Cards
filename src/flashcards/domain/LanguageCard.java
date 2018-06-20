

package flashcards.domain;

import java.io.Serializable;

/**
 *
 * @author Thumbone1
 */
public class LanguageCard implements Cardable, Serializable {
    
    private String front;
    private String back;

    public LanguageCard(String front, String back) {
        this.front = front;
        this.back = back;        
    }

    public void setBack(String back) {
        this.back = back;
    }

    public void setFront(String front) {
        this.front = front;
    }
    
    @Override
    public String getBack() {
        return back;
    }

    @Override
    public String getFront() {
        return front;
    }
    
    @Override
    public String toString() {
        return getFront() + "-\t\t" + getBack();
    }

}
