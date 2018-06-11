

package flashcards.domain;

/**
 *
 * @author Thumbone1
 */
public class LanguageCard implements Cardable {
    
    private String front;
    private String back;

    public LanguageCard(String front, String back) {
        this.front = front;
        this.back = back;
    }

    @Override
    public String getBack() {
        return back;
    }

    @Override
    public String getFront() {
        return front;
    }

    public void setBack(String back) {
        this.back = back;
    }

    public void setFront(String front) {
        this.front = front;
    }
    
    

}
