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

    public int getTypeSpeed() {return this.TypeSpeed;}
    public void setTypeSpeed(int newSpeed) {this.TypeSpeed = newSpeed;}

    public void SwitchPassage(Passage switchTo) {this.CurrentlyActivePassage = switchTo; ActivePassageName = CurrentlyActivePassage.getIdentifier(); PassageMovements++; displayPassage(); PassageHistory.add(switchTo);}
    public Passage getPassage() {return this.CurrentlyActivePassage;}

    public String getPassageName() {return this.ActivePassageName;}

    public void displayPassage() {
        Console.Clear(); Console.Write("Passage Stats | Movements: "); Console.setFGColor(255, 255, 0); Console.Write(PassageMovements); Console.addEffect("Reset");
        Console.Write(" | Dialog rate: x" ); Console.setFGColor(255, 255, 0); Console.Write(TypeSpeed + "\n\n"); Console.Write(PassageMovements); Console.addEffect("Reset");

        Console.WriteLine("] " + CurrentlyActivePassage.getIdentifier() + "\n");

        for (int i = 0; i < CurrentlyActivePassage.getContents().length(); i++) {
            Console.Write(CurrentlyActivePassage.getContents().charAt(i));

            switch(CurrentlyActivePassage.getContents().charAt(i)) {
                case '.' -> {Console.delay(100 *   TypeSpeed);}
                case ',' -> {Console.delay(50 *    TypeSpeed);}
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
        Scanner scr = new Scanner(System.in);
        try {
            Option select = Options.get(Integer.parseInt(scr.nextLine()));
            InvalidSelected = false;
            SwitchPassage(select.getTargetPassage());
        } catch (Exception e) {
            InvalidSelected = true;
            displayPassage();
        } finally {
            scr.close();
        }

    }
}
