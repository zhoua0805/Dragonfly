import java.util.Random;//import random function
//Kevin Zhou
//created 22/05/2018
public class DicerollFunction {
    public static int diceRoll() {//Create a diceroll function
        Random roller = new Random();//Create a random number generator
        return roller.nextInt(6) + 1;//Generate a number between 0-5 and add 1 to it
    }
}