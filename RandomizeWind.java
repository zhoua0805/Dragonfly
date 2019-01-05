import java.util.Random;

public class RandomizeWind {
    //created by Lucas
    //29/05/2018
    //method to shuffle the wind cards
    public static int[] RandomizeArray(int[] array){ // https://www.programcreek.com/2012/02/java-method-to-shuffle-an-int-array-with-random-order/
        Random rgen = new Random();  // Random number generator
        int cycle = 1; // is what cycle the shuffler is on
        int targetCycles = 5; // sets how many times the shuffler will pass over the array
        for (int i=0; i<array.length; i++) { // Loops through each slot of array as many times as dictated by target cycles
            int randomPosition = rgen.nextInt(array.length); // finds a random spot in the array
            int temp = array[i]; // puts current position in temporary variable
            array[i] = array[randomPosition]; // moves value in random position to current position
            array[randomPosition] = temp; // moves temp (previously known as current position) into random position
            if (i == (array.length - 1) && cycle < targetCycles) { // resets current position to zero if target cycles has not yet been reached. Increments Cycle counter.
                i = 0;
                cycle ++;
            }
        }
        return array; // sends back array
    }
 
    /*  first digit decides which direction the wind blows
        second digit decides the strength of the wind
        1 is left, 2 is left and down, 3 is down, 4 is right and down, 5 is right
        1 is 1 space, 2 is 2 spaces
    */
}