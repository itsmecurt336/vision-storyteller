package tests;

import backend.*;
import objects.*;
public class PromptHandlerTest {
    public static void main(String[] args) {
        PromptHandler prom = new PromptHandler();

        Passage pass1 = new Passage("Awakening");    pass1.setContents("You wake up in an unfamiliar bathroom. You get up and see some pills on the counter.");
        Passage pass2 = new Passage("Modifier");     pass2.setContents("You consume the pills. You feel fine. ");
        Passage pass3 = new Passage("Catwalk");      pass3.setContents("You exit the bathroom and see that you're in a building with a party going below you.");
        Passage pass4 = new Passage("Unfamiliar");   pass4.setContents("You kick open the door ahead, and see a sort of table in front of you. A figure shows up on the other end of the table. \n\n\"Please sign the waver.\"");
        Passage pass5 = new Passage("Genesis");      pass5.setContents("You sign the waver with your name. The game has begun.\n\nA shotgun materializes on the center of the table, with 3 shells next to it, two being red and the other being gray. \"2 live rounds. 1 blank.\" The figure grabs the shells and the shotgun. \"The shells are inserted in a hidden sequence.\" The shells enter the shotgun and gets placed in the middle of the table.");
        Passage pass6 = new Passage("Loaded");       pass6.setContents("");
        Passage pass7 = new Passage("Loaded");       pass7.setContents("");

        pass1.addOption(pass3, "Exit the bathroom");
        pass1.addOption(pass2, "Consume the pills");

        pass2.addOption(pass3, "Exit the bathroom");

        pass3.addOption(pass4, "Enter the room ahead");

        pass4.addOption(pass5, "Sign the waver");

        pass5.addOption(pass6, "Shoot self");
        pass5.addOption(pass6, "Shoot the figure");
        prom.SwitchPassage(pass1);



    }
}
