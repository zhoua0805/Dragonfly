public class MosquitoMove {
    //created by Alex Canning
    //created 04/06/2018
    //updated 05/06/2018
    //Checked by Alice Zhou 05/06/2018

    static int[][]Moved(int[][] MosquitoPosition){//input is mosquito array to move
        for (int i=8;i>=0;i--) {//Check for mosquitoes in any non-bottom row
            for (int j = 9; j >= 0; j--) {//Check for mosquitoes all non-bottom columns
                MosquitoPosition[i+1][j]+=MosquitoPosition[i][j];//Move entry down
                MosquitoPosition[i][j]=0;//clear checked entry
            }
        }
        return MosquitoPosition;//return new board state
    }


    //created by Alex Canning
    //updated 06/06/2018
    static int[][]Blown(int[][] MosquitoPosition, int WindCardNumber){//input each array with the wind card separately
        if (WindCardNumber==11||WindCardNumber==12) {//left 1 or 2
            for (int i = 8; i >= 0; i--) {//Check for mosquitoes in any non-bottom row
                for (int j = 1; j < 10; j++) {//Check for mosquitoes all  columns but extreme left
                    if (MosquitoPosition[i][j] != 0) {//if mosquito on space
                        if (WindCardNumber == 11) {//left 1
                            MosquitoPosition[i][j - 1] += MosquitoPosition[i][j];//Move entry left 1
                            MosquitoPosition[i][j] = 0;//clear checked entry
                        } else {//left 2
                            //space to the left
                            if (j == 1) {//only one space to the left
                                MosquitoPosition[i][j - 1] += MosquitoPosition[i][j];//Move entry left 1
                                MosquitoPosition[i][j] = 0;//clear checked entry
                            } else {//more than one space to left
                                MosquitoPosition[i][j - 2] += MosquitoPosition[i][j];//Move entry left 1
                                MosquitoPosition[i][j] = 0;//clear checked entry
                            }
                        }
                    }
                }
            }
        }else if (WindCardNumber==21||WindCardNumber==22){//down-left 1 or 2
            for (int i = 8; i >= 0; i--) {//Check for mosquitoes in any non-bottom row
                for (int j = 1; j < 10; j++) {//Check for mosquitoes all  columns except extreme left
                    if (MosquitoPosition[i][j] != 0) {//if mosquito on space
                        if (WindCardNumber == 21) {//down-left 1
                            MosquitoPosition[i+1][j - 1] += MosquitoPosition[i][j];//Move entry down-left 1
                            MosquitoPosition[i][j] = 0;//clear checked entry
                        } else{
                            if (j == 1) {//only one space to the left
                                MosquitoPosition[i + 1][j - 1] += MosquitoPosition[i][j];//Move entry down-left 1
                                MosquitoPosition[i][j] = 0;//clear checked entry
                            } else if(i==8) {//blown off board
                                MosquitoPosition[i][j] = 0;//clear checked entry
                            } else {//more than one space to left
                                MosquitoPosition[i + 2][j - 2] += MosquitoPosition[i][j];//Move entry down-left 1
                                MosquitoPosition[i][j] = 0;//clear checked entry
                            }
                        }
                    }
                }
            }
        }else if (WindCardNumber==31||WindCardNumber==32){//down 1 or 2
            for (int i=8;i>=0;i--) {//Check for mosquitoes in any non-bottom row
                for (int j = 9; j >= 0; j--) {//Check for mosquitoes all non-bottom columns
                    if (MosquitoPosition[i][j] != 0) {//if mosquito on space
                        if (WindCardNumber==31){//down 1
                            MosquitoPosition[i+1][j]+=MosquitoPosition[i][j];//Move entry 1 down
                            MosquitoPosition[i][j]=0;//clear checked entry
                        }else {//2 down
                            if (i==8){//blown off board
                                MosquitoPosition[i][j]=0;//clear checked entry
                            }else {
                                MosquitoPosition[i + 2][j] += MosquitoPosition[i][j];//Move entry 2 down
                                MosquitoPosition[i][j] = 0;//clear checked entry
                            }
                        }
                    }
                }
            }
        }else if (WindCardNumber==41||WindCardNumber==42){//down right
            for (int i=8;i>=0;i--) {//Check for mosquitoes in any non-bottom row
                for (int j = 8; j >= 0; j--) {//Check for mosquitoes all non-bottom columns
                    if (MosquitoPosition[i][j] != 0) {//if mosquito on space
                        if (WindCardNumber==41) {//down-right 1
                            MosquitoPosition[i+1][j+1]+=MosquitoPosition[i][j];//Move entry 1 down
                            MosquitoPosition[i][j]=0;//clear checked entry
                        }else {//2 down right
                            if (j==8){//only one spot to the right
                                MosquitoPosition[i+1][j+1]+=MosquitoPosition[i][j];//Move entry 1 down
                                MosquitoPosition[i][j]=0;//clear checked entry
                            }else{//space to the right
                                MosquitoPosition[i+2][j+2]+=MosquitoPosition[i][j];//Move entry 1 down
                                MosquitoPosition[i][j]=0;//clear checked entry
                            }
                        }
                    }
                }
            }
        }else if (WindCardNumber==51||WindCardNumber==52){//right 1 or 2
            for (int i=8;i>=0;i--) {//Check for mosquitoes in any non-bottom row
                for (int j = 8; j >= 0; j--) {//Check for mosquitoes all non-bottom columns
                    if (MosquitoPosition[i][j] != 0) {//if mosquito on space
                        if (WindCardNumber==51){//right 1
                            MosquitoPosition[i][j+1]+=MosquitoPosition[i][j];//move entry right
                            MosquitoPosition[i][j]=0;//clear checked entry
                        }else {//right 2
                            if (j==8){//only one space
                                MosquitoPosition[i][j+1]+=MosquitoPosition[i][j];//move 1 right
                                MosquitoPosition[i][j]=0;//clear checked entry
                            }else if(i==8){//blown off board
                                MosquitoPosition[i][j]=0;//clear checked entry
                            }else{//space to the right
                                MosquitoPosition[i][j+2]+=MosquitoPosition[i][j];//move 2 right
                                MosquitoPosition[i][j]=0;//clear checked entry
                            }
                        }
                    }
                }
            }
        }
        return MosquitoPosition;
    }
}