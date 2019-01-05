import java.util.Random;
public class MosquitoSpawnArray {
    //Created by Alex Canning
    //06/06/2018
    //Checked by Alice Zhou 06/06/2018

    private static Random generator = new Random();
    static int []SpawnOrder(int Players){
        int EvenMosquito=0;//initialize temp variables
        int OddMosquito=0;
        if (Players==1||Players==2){//set values to number of that type to spawn
            EvenMosquito=3;
            OddMosquito=2;
        }else if (Players==3){
            EvenMosquito=3;
            OddMosquito=4;
        }else if (Players==4){
            EvenMosquito=5;
            OddMosquito=5;
        }

        int[] MosquitoTypePlace;
        MosquitoTypePlace=new int[EvenMosquito+OddMosquito];

        for (int i=0; i<MosquitoTypePlace.length;i++) {
            if (EvenMosquito>0&&OddMosquito>0) {//options to spawn
                if(generator.nextInt(6)%2==0){//randomly select spawned type
                    MosquitoTypePlace[i] =2;//even spawn
                    EvenMosquito-=1;//reduce remaining
                }else{//randomly not even
                    MosquitoTypePlace[i] =1;//odd spawn
                    OddMosquito-=1;//reduce remaining
                }

            }else if (EvenMosquito==0){//no evens left
                MosquitoTypePlace[i] =1;//odd spawn
                OddMosquito-=1;//reduce remaining
            }else if (OddMosquito==0){//no odds left
                MosquitoTypePlace[i] =2;//even spawn
                EvenMosquito-=1;//reduce remaining
            }
        }
        return MosquitoTypePlace;//return order
    }
}