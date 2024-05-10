package objects;

import objects.Passage;

public class Option {
    private String  descript = "";
    private Passage ConnectToPassage = null;

    public String getDescript() {return this.descript;}
    public void setDescript(String newDesc) {this.descript = newDesc;}

    public Passage getTargetPassage() {return this.ConnectToPassage;}
    public void setConnectingPassage(Passage newPassage){this.ConnectToPassage = newPassage;}
    
    public Option(Passage connectingPassage, String desc) {
        setDescript(desc);
        setConnectingPassage(connectingPassage);
    }
}