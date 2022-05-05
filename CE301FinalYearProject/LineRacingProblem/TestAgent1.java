import java.util.Scanner;
import java.io.*;
import java.math.*;


class TestAgent1 
{
    static int getRandom(int min, int max) 
    {
        return (int) ((Math.random() * (max - min)) + min);
    
    }

    static void getRandomDir(int dir)
    {
        long startTime = System.nanoTime();

        switch(dir)
            {
                case 0:
                    System.out.println("UP");
                    break;
                case 1:
                    System.out.println("DOWN");
                    break;
                case 2:
                    System.out.println("LEFT");
                    break;

                case 3:
                    System.out.println("RIGHT");
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
            int dir = getRandom(0, 3);

            getRandomDir(dir);

        }
    }
}
