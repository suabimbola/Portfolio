import java.util.*;
import java.io.*;
import java.math.*;

class TestAgent2 {

    static int tempDir = 10;
    static String[] directions = {"UP", "DOWN", "LEFT", "RIGHT"};

    static int getRandomInt(int min, int max) 
    {
        return (int) ((Math.random() * (max - min)) + min);

    }

    static void getRandomDir(int dir)
    {
        long startTime = System.nanoTime();

        switch(dir)
        {
            case 0:
                if (tempDir != 1)
                {
                    System.out.println("UP");

                }
                else
                {
                    System.out.println(directions[getRandomInt(2, 3)]);
                }
                break;
            case 1:
                if (tempDir != 0)
                {
                    System.out.println("DOWN");

                }
                else
                {
                    System.out.println(directions[getRandomInt(2, 3)]);
                }
                break;
            case 2:
                if (tempDir != 3)
                {
                    System.out.println("LEFT");

                }
                else
                {
                    System.out.println(directions[getRandomInt(0, 1)]);
                }
                break;

            case 3:
                if (tempDir != 2)
                {
                    System.out.println("RIGHT");

                }
                else
                {
                    System.out.println(directions[getRandomInt(0, 1)]);
                }
                break;
            
        }

            long timeTaken = System.nanoTime() - startTime;
            System.err.println("Executed in:" + timeTaken + " nanoseconds.");

    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        // game loop
        while (true) {
            int N = in.nextInt(); // total number of players (2 to 4).
            int P = in.nextInt(); // your player number (0 to 3).
            for (int i = 0; i < N; i++) {
                int X0 = in.nextInt(); // starting X coordinate of lightcycle (or -1)
                int Y0 = in.nextInt(); // starting Y coordinate of lightcycle (or -1)
                int X1 = in.nextInt(); // starting X coordinate of lightcycle (can be the same as X0 if you play before this player)
                int Y1 = in.nextInt(); // starting Y coordinate of lightcycle (can be the same as Y0 if you play before this player)
            }
            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");
            int dir = getRandomInt(0, 3);

            getRandomDir(dir);

           
            tempDir = dir;

        }
    }
}
