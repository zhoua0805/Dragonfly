//Kevin Zhou
//Date started coding 08/06/2018
//Modification:11/06/18, replaced if statements with a switch statement
//Tested by Nicolas and Alex C 11/06/2018
public class bugPlacement {
    //Start of function you want to import
    public static void placement(int[][]dragonflies, int players, int[][]oddMosquitoes, int[][]evenMosquitoes, int[]order){//Parameters of the function: the dragonfly 2-D array, the number of players, the array of odd and even mosquitoes and the order of the odd and even mosquitoes
        dragonflies[5][1] = 1;//Place the first dragonfly
        for (int i = 0; i < 5; i++){//Open a for loop that runs for 5 times
            //The order array consists of 1s (odd mosquito) and 2s (even mosquito)
            if(order[i] == 1){//If the order array has a 1 in the specified index (an odd mosquito is going to be placed)
                oddMosquitoes[0][i*2] = 1;//Place a mosquito in the oddMosquito array (The for loop will place mosquitoes at alternating places (white spots on game board))
            } else {//If the order array has a 2 in the specified index (an even mosquito is being placed next)
                evenMosquitoes[0][i*2] = 1;//Place a mosquito in the oddMosquito array (This for loop will place mosquitoes at alternating places (white spots on game board))
            }
        }
        switch(players){//Create a switch statement that is controlled by the players variable
            case 1:
                break;//end case
            case 2://If players equals 2 (two players are playing)
                dragonflies[5][8] = 2;//Place the second dragonfly on the board
                break;//end case
            case 3://if players equals 3 (three players are playing)
                dragonflies[5][8] = 2;//Place the second dragonfly on the board
                dragonflies[5][3] = 3;//Place the third dragonfly
                if(order[5] == 1){//If the order array has a 1 in the 5th index (6th mosquito is odd)
                    oddMosquitoes[0][1] = 1;//Place a mosquito in the odd mosquito array (corresponding to the first red spot on the real life game board)
                }else{//If the order array has a 2 in the 5th index (6th mosquito is even)
                    evenMosquitoes[0][1]=1;//Place a mosquito in the even mosquito array (corresponding to the first red spot on the real life game board)
                }
                if(order[6] == 1){//If the order array has a 1 in the 6th index (7th mosquito is odd)
                    oddMosquitoes[0][7] = 1;//Place a mosquito in the odd mosquito array (corresponding to the second red spot on the real life game board)
                }else{//If the order array has a 2 in the 6th index (7th mosquito is even)
                    evenMosquitoes[0][7]=1;//Place a mosquito in the even mosquito array (corresponding to the second red spot on the real life game board)
                }
                break;//end case
            case 4://If players equals 4
                dragonflies[5][8] = 2;//Place the second dragonfly on the board
                dragonflies[5][3] = 3;//PLace the third dragonfly
                if(order[5] == 1){//If the order array has a 1 in the 5th index (6th mosquito is odd)
                    oddMosquitoes[0][1] = 1;//Place a mosquito in the odd mosquito array (corresponding to the first red spot on the real life game board)
                }else{//If the order array has a 2 in the 5th index (6th mosquito is even)
                    evenMosquitoes[0][1]=1;//Place a mosquito in the even mosquito array (corresponding to the first red spot on the real life game board)
                }
                if(order[6] == 1){//If the order array has a 1 in the 6th index (7th mosquito is odd)
                    oddMosquitoes[0][7] = 1;//Place a mosquito in the odd mosquito array (corresponding to the second red spot on the real life game board)
                }else{//If the order array has a 2 in the 6th index (7th mosquito is even)
                    evenMosquitoes[0][7]=1;//Place a mosquito in the even mosquito array (corresponding to the second red spot on the real life game board)
                }
                dragonflies[5][6] = 4;//Place the fourth dragonfly
                if(order[7] == 1){//If the order array has a 1 in the 7th index (8th mosquito is odd)
                    oddMosquitoes[0][3] = 1;//Place a mosquito in the odd mosquito array (corresponding to the 1st yellow spot on the real life game board)
                }else{//If the order array has a 2 in the 7th index (8th mosquito is even)
                    evenMosquitoes[0][3]=1;//Place a mosquito in the even mosquito array (corresponding to the 1st yellow spot on the real life game board)
                }
                if(order[8] == 1){//If the order array has a 1 in the 8th index (9th mosquito is odd)
                    oddMosquitoes[0][5] = 1;//Place a mosquito in the odd mosquito array (corresponding to the 2nd yellow spot on the real life game board)
                }else{//If the order array has a 2 in the 8th index (9th mosquito is even)
                    evenMosquitoes[0][5]=1;//Place a mosquito in the even mosquito array (corresponding to the 2nd yellow spot on the real life game board)
                }
                if(order[9] == 1){//If the order array has a 1 in the 9th index (10th mosquito is odd)
                    oddMosquitoes[0][9] = 1;//Place a mosquito in the odd mosquito array (corresponding to the 3rd yellow spot on the real life game board)
                }else{//If the order array has a 2 in the 9th index (10th mosquito is odd)
                    evenMosquitoes[0][9]=1;//Place a mosquito in the even mosquito array (corresponding to the 3rd yellow spot on the real life game board)
                }
                break;//end case
        }
    }
}