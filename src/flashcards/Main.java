/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flashcards;

import flashcards.domain.Cardable;
import flashcards.domain.Deck;
import flashcards.domain.LanguageCard;
import flashcards.ui.FlashcardsTextUI;
import flashcards.util.TextReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author judgeandsiri
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        /*
        what the f is going on with norwegian characters?
        */
        
        //Deck deck = new Deck();
        //TextReader reader = new TextReader();
        
        Locale la = new Locale("no", "NO");
        
        
        String str = "åøæ";
        Scanner sc = new Scanner(str);
        //sc.useLocale(la);
        
        System.out.println("type norwegian chars ");
        //String s = sc.nextLine();
        //System.out.println("string: " + str);
        
        
        //System.out.println(s);
        System.out.println(str);
        System.out.println(sc.next());
        
        
       //FlashcardsTextUI ui = new FlashcardsTextUI();

       //ui.start();
       
        
        
          
            
        

       
       
       
    }
    
}
