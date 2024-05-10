package objects;

import java.util.ArrayList;

public class Passage {
    private String identifier = "";
    private String contents = "";
    public boolean isFirstPassageOfPath = false;
    private ArrayList<Option> options = new ArrayList<Option>();

    public String getContents() {return this.contents;}
    public void setContents(String newContent) {this.contents = newContent;}

    public String getIdentifier() {return this.identifier;}
    public void setIdentifier(String newIdentifier) {this.identifier = newIdentifier;}

    public ArrayList<Option> getOptions() {return options;}

    public Passage(String firstID) {
        this.identifier = firstID;
    }

    public void addOption(Passage connectingPassage, String text) {
        options.add(new Option(connectingPassage, text));
    }
}
