package unused;

import java.util.*;

import backend.Console;

public class Wave {
    public static void main(String[] args) {
        sinWave();
    }

    public static void oceanWave() {
        double frequency = 0.01;
        int amplitude = 30;
        int speed = 20;

        int i = 0;
        while (true) {

            i++;
            try {
                int coordinate = (int) Math.round(Math.sin(i * frequency) * amplitude) +
                        amplitude;
                if (coordinate > 50 && coordinate < 60) {
                    amplitude += 5;
                } else {
                    // amplitude -= 0.00001;
                }
                Thread.sleep(speed);
                String space = " ".repeat(coordinate);
                String line = (" ".repeat(amplitude) + space + "|");

                if (coordinate > amplitude) {

                    line += "|".repeat(coordinate - amplitude);
                } else if (coordinate < amplitude) {
                    line = " ".repeat((coordinate) + (amplitude - (amplitude - coordinate)))
                            + "|".repeat(Math.abs(coordinate - amplitude)) + "|";
                }

                if (coordinate > amplitude) {

                }
                System.out.println(line);
            } catch (Exception e) {

            }
        }
    }

    public static void sinWave() {
        double frequency = 0.05;
        int amplitude = 30;
        int speed = 20;

        int i = 0;
        while (true) {
            i++;
            try {
                int coordinate = (int) Math.round(Math.sin(i * frequency) * amplitude) +
                        amplitude;
                Thread.sleep(speed);
                String space = " ".repeat(coordinate);
                String line = (space + "|");

                if (coordinate < amplitude) {
                    line += "|".repeat(amplitude - coordinate); Console.setFGColor(128,255,128);
                } else if (coordinate > amplitude) {
                    line = (" ".repeat(amplitude)) + ("|").repeat(coordinate - amplitude); Console.setFGColor(128,128,255);
                }

                // if (coordinate > amplitude) {
                // line += "|".repeat(coordinate - amplitude);
                // }
                System.out.println(line);
            } catch (Exception e) {

            }
        }
    }

    public static void linearWave() {
        int i = 0;
        boolean rising = true;
        while (true) {
            try {

                if (i == 0) {
                    rising = true;
                } else if (i == 40) {
                    rising = false;
                }

                if (rising) {
                    i++;
                } else {
                    i--;
                }

                String input = " ".repeat(i);
                if (i > (40 / 2)) {
                    input = " ".repeat((40 / 2)) + "|".repeat((i - (40 / 2)));
                } else if (i < (40 / 2)) {
                    input += "|".repeat(Math.abs(i - 20));
                }
                System.out.println(input + "|");
                Thread.sleep(20);
            } catch (Exception e) {

            }
        }

    }
}
