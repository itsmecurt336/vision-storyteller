package backend;

import java.util.Scanner;
import java.util.ArrayList;

import objects.*;
public class PromptHandler {
    private int                PassageMovements = 0;
    private Passage            CurrentlyActivePassage = null;
    private String             ActivePassageName = "";
    private int                TypeSpeed = 5;
    private ArrayList<Passage> PassageHistory = new ArrayList<>();

    private boolean InvalidSelected = false;
    /** 
    * Returns the Type Speed multiplier. Passage rendering is 8ms per character by default, but slows down to 25ms on a comma, and 75ms per period.
    * @returns typespeed, an integer.
    */
    public int getTypeSpeed() {return this.TypeSpeed;}

    /** 
    * Sets the Type Speed multiplier.
     * @param newSpeed
    */
    public void setTypeSpeed(int newSpeed) {this.TypeSpeed = newSpeed;}

    /** 
    * Switches the currently active Passage to the Passage passed onto the method.
     * @param switchTo
    */
    public void SwitchPassage(Passage switchTo) {this.CurrentlyActivePassage = switchTo; ActivePassageName = CurrentlyActivePassage.getIdentifier(); PassageMovements++; displayPassage(); PassageHistory.add(switchTo);}
    
    /** 
    * Obtains the currently active Passage and returns it.
     * @return 
    */
    public Passage getPassage() {return this.CurrentlyActivePassage;}

    /** 
    * Returns the title of the Passage.
    * @return
    */
    public String getPassageName() {return this.ActivePassageName;}

    /** 
    * Displays the contents of the Passage.
    */
    public void displayPassage() {
        Console.Clear(); Console.Write("Passage Stats | Movements: "); Console.setFGColor(255, 255, 0); Console.Write(PassageMovements); Console.addEffect("Reset");
        Console.Write(" | Dialog rate: x" ); Console.setFGColor(255, 255, 0); Console.Write(TypeSpeed + "\n\n"); Console.Write(PassageMovements); Console.addEffect("Reset");

        Console.WriteLine("] " + CurrentlyActivePassage.getIdentifier() + "\n");

        for (int i = 0; i < CurrentlyActivePassage.getContents().length(); i++) {
            Console.Write(CurrentlyActivePassage.getContents().charAt(i));

            switch(CurrentlyActivePassage.getContents().charAt(i)) {
                case '.' -> {Console.delay(75 *   TypeSpeed);}
                case ',' -> {Console.delay(25 *    TypeSpeed);}
                default  -> {Console.delay(8 *     TypeSpeed);}
            }
        }
        Console.Write("\n\n");
        ArrayList<Option> Options = CurrentlyActivePassage.getOptions();
        
        Console.setFGColor(0, 180, 255); Console.addEffect("Underline");
        for (int index = 0; index < Options.size(); index++) {
            Console.WriteLine("(" + index + ") " + Options.get(index).getDescript());
        }
        Console.addEffect("Reset");
        if (InvalidSelected) {Console.addEffect("Italize"); Console.setFGColor(255,128,0); Console.WriteLine("Invalid option selected."); Console.addEffect("Reset");}

        Console.Write("\nType a number to traverse to that passage: ");
        try (java.util.Scanner scr = new Scanner(System.in)) {
            Option select = Options.get(Integer.parseInt(scr.nextLine()));
            InvalidSelected = false;
            SwitchPassage(select.getTargetPassage());
        } catch (Exception e) {
            InvalidSelected = true;
            displayPassage();
        }

    }
}
