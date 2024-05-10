package backend;

import java.util.Scanner;
import java.util.ArrayList;

import objects.*;
public class PromptHandler {
    private int     PassageMovements = 0;
    private Passage CurrentlyActivePassage = null;
    private String  ActivePassageName = "";

    private boolean InvalidSelected = false;

    public void SwitchPassage(Passage switchTo) {this.CurrentlyActivePassage = switchTo; ActivePassageName = CurrentlyActivePassage.getIdentifier(); PassageMovements++; displayPassage();}
    public Passage getPassage() {return this.CurrentlyActivePassage;}

    public String getPassageName() {return this.ActivePassageName;}

    public void displayPassage() {
        Console.Clear(); Console.Write("Passage traversals: "); Console.setFGColor(255, 255, 0); Console.Write(PassageMovements + "\n\n"); Console.addEffect("Reset");

        Console.WriteLine("] " + CurrentlyActivePassage.getIdentifier() + "\n" + CurrentlyActivePassage.getContents() + "\n");
        ArrayList<Option> Options = CurrentlyActivePassage.getOptions();
        if (InvalidSelected) {Console.addEffect("Italize"); Console.setFGColor(255,128,0); Console.WriteLine("Invalid option selected."); Console.addEffect("Reset");}
        Console.setFGColor(0, 128, 255); Console.addEffect("Underline");
        for (int index = 0; index < Options.size(); index++) {
            Console.WriteLine("(" + index + ") " + Options.get(index).getDescript());
        }
        Console.addEffect("Reset");
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
