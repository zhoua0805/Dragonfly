public class MosquitoCheck{
    //Created by Alex Canning
    //created 01/06/2018
    //Checked by Alice Zhou 06/06/2018
    //updated 07/06/2018
    //Checked by Alice Zhou 07/06/2018
    static boolean GameEndCheck(int[][] Remaining, int[][] Remaining2){//input mosquito board
        boolean FlagOutput=false;//false for game end
        for (int i=0;i<9;i++){//Check for mosquitoes in any non-bottom row
            for(int j=0;j<10;j++){//Check for mosquitoes all non-bottom columns
                if (Remaining[i][j]!=0||Remaining2[i][j]!=0){//check both arrays for valid non zero entry
                    FlagOutput = true;//true for continue game
                }
            }
        }
        return FlagOutput;//return result
    }
}