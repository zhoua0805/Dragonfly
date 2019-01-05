import java.util.Scanner;

/**
 * Created by Alice Zhou
 * 06/06/2018
 * Rules:
 * 1. Rolled the die
 * 2. Move the oddMosquitoes indicated on the die
 * 3. Move your dragonflies to make captures
 * 4. Expose a windcard
 * 5. Move all the oddMosquitoes
 */
//Modified by Alex Canning
//07/06/2018

// Updated by Alex Ka
//12/06/2018

// Updated by Alice Zhou
//13/06/2018


//note to GUI: if select unspawned Dragonfly game infinitely loops please do not allow selection Alex C and Nicolas
public class GameBoard {
    public static void main(String[] args) {
        //Kevin Zhou
        Scanner input = new Scanner(System.in);
        //Game board arrays
        int[][]oddMosquitoes = new int[10][10];//First [] is vertical(y), Second [] is horizontal(x)
        int[][]evenMosquitoes = new int[10][10];
        int[][]dragonfly = new int[10][10];
        //Positions of each dragonflies  is stored in a array with two elements
        int[]dragonfly1 = {1,5,0}; // (x,y)
        int[]dragonfly2 = {8,5,0}; //(x,y)
        int[]dragonfly3 = {3,5,0}; //(x,y)
        int[]dragonfly4 = {6,5,0}; //(x,y)
        //Set up game board by filling the arrays with 0s (means there is nothing on that space)
        oddMosquitoes = BoardStates.clear(oddMosquitoes);
        evenMosquitoes = BoardStates.clear(evenMosquitoes);
        dragonfly = BoardStates.clear(dragonfly);
        //Place the dragonflies in their respective starting positions

        // making variables for turn cycles
        int turn = 0;
        int numOfTurns;

        //Alice Zhou
        //Step 0: input player number
        System.out.println("Please input an integer between 1 and 4 as the number of the players: ");
        int playernum = input.nextInt();
        int[] mosquitoPos = MosquitoSpawnArray.SpawnOrder(playernum);  //call the randomize mosquitoes method
        //Modified by Alex Canning 11/06/2018
        //places mosquito's and dragonflies
        bugPlacement.placement(dragonfly,playernum,oddMosquitoes,evenMosquitoes,mosquitoPos);
        //Output the positions of dragonflies on the game board

        /* //Replaced by 'betterBoard' function by Alex Karanassios and Zack Lee

        System.out.println("Dragonflies");
        BoardStates.printBoard(dragonfly);
        //Output the positions of even mosquitoes on the game board
        System.out.println("Even mosquitoes");
        BoardStates.printBoard(evenMosquitoes);
        //Output the positions of odd mosquitoes on the game board
        System.out.println("Odd mosquitoes");
        BoardStates.printBoard(oddMosquitoes);
        */

        System.out.println("players/even/odd");
        BoardStates.betterBoard(dragonfly,evenMosquitoes,oddMosquitoes);

        int count = 0; //count for turns
        int [] windcard = new int[] {11,12,21,22,31,32,41,42,51,52};    //set up the windcard array
        windcard = RandomizeWind.RandomizeArray(windcard);  //shuffle the windcards





        do {

            /* //unnecessary in final version

            //Ask user if they want to exit the game
            System.out.println("Do you want to exit the game? yes = 0, no = 1: ");
            String t = input.next();
            if (t.equals("0")) {  //If yes, exit the game
                break;
            }else if (!t.equals("1") && !t.equals("0")) {
                System.out.println("invalid input");
                continue;
            }
        */

            //Step 1: roll the die
            System.out.println("Click any keys to roll the dice: ");
            input.next();
            int r = DicerollFunction.diceRoll();
            System.out.println("You rolled a " + r);

            //Step 2: move the mosquitoes indicated on the die
            if (r % 2 == 0) {
                MosquitoMove.Moved(evenMosquitoes);
            }else {
                MosquitoMove.Moved(oddMosquitoes);
            }
            //Modified by Nicolas Ruza 8/6/2018 and Zack Lee/ Alex Ka. 06/15/2018
            Dragonfly.CheckEaten(dragonfly1, evenMosquitoes);  //Check if any mosquitoes are eaten
            Dragonfly.CheckEaten(dragonfly1, oddMosquitoes);
            if (playernum > 1) {
                Dragonfly.CheckEaten(dragonfly2, evenMosquitoes);  //Check if any mosquitoes are eaten
                Dragonfly.CheckEaten(dragonfly2, oddMosquitoes);
                if (playernum > 2) {
                    Dragonfly.CheckEaten(dragonfly3, evenMosquitoes);  //Check if any mosquitoes are eaten
                    Dragonfly.CheckEaten(dragonfly3, oddMosquitoes);
                    if (playernum > 3) {
                        Dragonfly.CheckEaten(dragonfly4, evenMosquitoes);  //Check if any mosquitoes are eaten
                        Dragonfly.CheckEaten(dragonfly4, oddMosquitoes);
                    }
                }
            }

            System.out.println("players/even/odd");
            BoardStates.betterBoard(dragonfly,evenMosquitoes,oddMosquitoes);


            //Step 3: move your dragonflies to make captures
            if (turn == playernum) {
                turn = 0;
            }
            turn += 1;

            if (1 == turn) {
                    System.out.println("Please input the coordinates you want to move to: ");
                    Dragonfly.MoveDragonfly(dragonfly1);  //move the dragonfly
                    Dragonfly.CheckEaten(dragonfly1, evenMosquitoes);  //Check if any mosquitoes are eaten
                    Dragonfly.CheckEaten(dragonfly1, oddMosquitoes);

            } else if (2 == turn) {
                System.out.println("Please input the coordinates you want to move to: ");
                Dragonfly.MoveDragonfly(dragonfly2);  //move the dragonfly
                Dragonfly.CheckEaten(dragonfly2, evenMosquitoes);  //Check if any mosquitoes are eaten
                Dragonfly.CheckEaten(dragonfly2, oddMosquitoes);

            } else if (3 == turn) {
                System.out.println("Please input the coordinates you want to move to: ");
                Dragonfly.MoveDragonfly(dragonfly3);  //move the dragonfly
                Dragonfly.CheckEaten(dragonfly3, evenMosquitoes);  //Check if any mosquitoes are eaten
                Dragonfly.CheckEaten(dragonfly3, oddMosquitoes);

            } else if (4 == turn) {
                System.out.println("Please input the coordinates you want to move to: ");
                Dragonfly.MoveDragonfly(dragonfly4);  //move the dragonfly
                Dragonfly.CheckEaten(dragonfly4, evenMosquitoes);  //Check if any mosquitoes are eaten
                Dragonfly.CheckEaten(dragonfly4, oddMosquitoes);

            }
            //Clear the dragonfly array to redraw it later
            dragonfly = BoardStates.clear(dragonfly);
            //Redraw the new positions of the dragonflies

            //Fixed reappearing dragonfly bug
            //Credit Zack Lee, Alex Ka.
            //created 12/06/2018
            dragonfly[dragonfly1[1]][dragonfly1[0]] = 1;
            if (playernum > 1) {
                dragonfly[dragonfly2[1]][dragonfly2[0]] = 2;
                if (playernum > 2) {
                    dragonfly[dragonfly3[1]][dragonfly3[0]] = 3;
                    if (playernum > 3) {
                        dragonfly[dragonfly4[1]][dragonfly4[0]] = 4;
                    }
                }
            }
            //Output the dragonfly array

            System.out.println("players/even/odd");
            BoardStates.betterBoard(dragonfly,evenMosquitoes,oddMosquitoes);

            //Step 4: expose a windcard
            System.out.println("You windcard number is " + windcard[count%10]);

            //Step 5: move all the mosquitoes
            MosquitoMove.Blown(oddMosquitoes, windcard[count%10]);
            MosquitoMove.Blown(evenMosquitoes, windcard[count%10]);
            count = count + 1;
            //Modified by Nicolas Ruza 8/6/2018 and Zack Lee/ Alex Ka. 06/15/2018
            Dragonfly.CheckEaten(dragonfly1, evenMosquitoes);  //Check if any mosquitoes are eaten
            Dragonfly.CheckEaten(dragonfly1, oddMosquitoes);
            if (playernum > 1) {
                Dragonfly.CheckEaten(dragonfly2, evenMosquitoes);  //Check if any mosquitoes are eaten
                Dragonfly.CheckEaten(dragonfly2, oddMosquitoes);
                if (playernum > 2) {
                    Dragonfly.CheckEaten(dragonfly3, evenMosquitoes);  //Check if any mosquitoes are eaten
                    Dragonfly.CheckEaten(dragonfly3, oddMosquitoes);
                    if (playernum > 3) {
                        Dragonfly.CheckEaten(dragonfly4, evenMosquitoes);  //Check if any mosquitoes are eaten
                        Dragonfly.CheckEaten(dragonfly4, oddMosquitoes);
                    }
                }
            }


            System.out.println("players/even/odd");
            BoardStates.betterBoard(dragonfly,evenMosquitoes,oddMosquitoes);

            //Step 6: check game end
            boolean gameend = MosquitoCheck.GameEndCheck(evenMosquitoes, oddMosquitoes);
            if (!gameend) {      //end the game if there's no more mosquito on the board
                System.out.println("Game ended.");
                int sum = 0;
                for (int i = 0; i < 10; i++) {   //add up the last row of mosquitoes together
                    sum += evenMosquitoes[9][i];
                    sum += oddMosquitoes[9][i];
                }
                if (playernum==1 || playernum==2) {    //for 1 or 2 player game
                    if (sum == 5) {                     //if there are 5 mosquitoes on the last row
                        System.out.println("You lost!");    //print "You lost!"
                    }else {
                        System.out.println("You won! ");
                    }
                }else if (playernum==3) { //for 3 player game
                    if (sum == 7) {//if there are 7 mosquitoes on the last row
                        System.out.println("You lost!");    //print "You lost!"
                    }else {
                        System.out.println("You won! ");
                    }
                }else if (playernum==4) {//for 4 player game
                    if (sum == 10) {  //if there are 10 mosquitoes on the last row
                        System.out.println("You lost!");  //print "You lost!"
                    }else {
                        System.out.println("You won! ");
                    }
                }
                break;
            }

        } while (true);
    }
}