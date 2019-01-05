import java.util.Scanner;

public class Dragonfly {
    //speedChart method
    // created by Lucas
    //31/05/2018
    //updated by Alice Zhou
    //06/06/2018
    public static int getSpeed(int mosquitosEaten) { // input # of mosquitos player has eaten
        int speed = 0;
        if (mosquitosEaten < 6) {
            speed = (int)Math.ceil(3 - (mosquitosEaten*.5));
        }
        return speed; // takes 3, subtracts 0.5 per mosquito, ceilings number and returns it
    }
    //created by Alice Zhou
    //04/06/2018
    //updated by Alex Canning, Nicolas Ruza, Chen Hsu
    //08/06/2018
    public static int[][] CheckEaten (int[]dragonfly, int[][]mosquito) {
        if (mosquito[dragonfly[1]][dragonfly[0]] != 0) {   //there's a (or more) mosquito(es) on that spot
            dragonfly[2] += mosquito[dragonfly[1]][dragonfly[0]];
            mosquito[dragonfly[1]][dragonfly[0]] = 0;   //clear the position
            System.out.println("Congrats! You ate a mosquito.");
        }
        return mosquito;
    }

    //this is the method for moving dragonflies
    //Created by Alice Zhou
    //28/05/2018
    //updated 06/06/2018
    //updated 14/06/2018
    public static int[] MoveDragonfly(int[] a) {
        Scanner input = new Scanner(System.in); //ask the user to input the coordinates to which he wants to move the dragonfly
        while (true){
            int y;
            int x;
            System.out.println("Please input the the x coordinate you want to move to");
            try {                                 //get x
                x = Integer.parseInt(input.next());
            }catch (IllegalArgumentException e) {
                System.out.println("invalid input!");
                continue;
            }
            System.out.println("Please input the the y coordinate you want to move to");
            try {                                 //get y
                y = Integer.parseInt(input.next());
            }catch (IllegalArgumentException e) {
                System.out.println("invalid input!");
                continue;
            }

            //Move the dragonflies directly to the spot the user wants to move to
            if ((y-a[1]) <= Dragonfly.getSpeed(a[2]) && (y-a[1]) >= -1 * Dragonfly.getSpeed(a[2]) && (x-a[0]) <= Dragonfly.getSpeed(a[2]) && (x-a[0]) >= -1 * Dragonfly.getSpeed(a[2]) && y < 9 && y > -1 && x < 10 && x > -1) {
                a[1] = y; //set up the new y coordinate
                a[0] = x; //set up the new x coordinate
                break; //break the while loop
            }else {
                System.out.println("invalid move");   //if it's out of bound, print "invalid move"
            }
        }
        return a;    //return the new dragonfly position
    }

}