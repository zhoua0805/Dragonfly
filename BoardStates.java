public class BoardStates {
    //Credit Kevin Zhou, clearBoard method
    //created 28/05/2018
    public static int[][] clear(int[][] board) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                board[i][j] = 0;
            }
        }
        return (board);
    }

    //printBoard method
    //Credit Kevin Zhou, clearBoard method
    //created 28/05/2018
    public static void printBoard(int[][] board) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
    //betterBoard display method
    //Credit Zack Lee, Alex Ka.
    //created 12/06/2018
    public static void betterBoard(int[][] player,int[][] boardEven,int[][] boardOdd) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(player[i][j]+""+boardEven[i][j]+""+boardOdd[i][j]+" ");
            }
            System.out.println();
        }
    }
}
