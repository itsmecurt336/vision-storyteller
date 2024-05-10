package tests;

import backend.Console;
       
public class ConsoleTest {
    public static void main (String[] args) {

        Console.Clear();
        Console.WriteLine("america ya");
        Console.setFGColor(91, 206, 250);
        Console.WriteLine("hallo"); Console.setFGColor(245, 169, 184);
        Console.WriteLine("hallo");Console.setFGColor(255, 255, 255);
        Console.WriteLine("hallo");Console.setFGColor(245, 169, 184);
        Console.WriteLine("hallo");Console.setFGColor(91, 206, 250);
        Console.WriteLine("hallo");
        Console.addEffect("Reset");
    }
}
