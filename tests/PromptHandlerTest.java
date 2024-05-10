package tests;

import backend.*;
import objects.*;
public class PromptHandlerTest {
    public static void main(String[] args) {
        PromptHandler prom = new PromptHandler();

        Passage pass1 = new Passage("Passage A"); pass1.setContents("This is a test of the Passage system. \nYou're currently on Passage A.");
        Passage pass2 = new Passage("Passage B"); pass2.setContents("This thing is very scuffed, I know.\nYou're currently on Passage B.");
        Passage pass3 = new Passage("Passage C"); pass3.setContents("But if it works, it works.\nYou're currently on Passage C.");

        pass1.addOption(pass1, "Reload Passage A");
        pass1.addOption(pass2, "Traverse to Passage B");
        pass1.addOption(pass3, "Traverse to Passage C");

        pass2.addOption(pass1, "Traverse to Passage A");
        pass2.addOption(pass2, "Reload Passage B");
        pass2.addOption(pass3, "Traverse to Passage C");

        pass3.addOption(pass1, "Traverse to Passage A");
        pass3.addOption(pass2, "Traverse to Passage B");
        pass3.addOption(pass3, "Reload Passage C");
        prom.SwitchPassage(pass1);



    }
}
