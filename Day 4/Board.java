public class Board {
    int[][] boardLayout = new int[5][5];
    int occupiedNum = 999;
    public boolean isWinningBoard = false;


    public void addLine(int[] suppliedRow, int rowNum){
        for(int i = 0; i < suppliedRow.length; i++){
            boardLayout[rowNum][i] = suppliedRow[i];
        }
    }

    public void printBoard(){
        for(int i=0; i<boardLayout.length; i++){
            for(int j=0; j<boardLayout[i].length; j++){
                System.out.print(boardLayout[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void checkNewNumber(int calledNum){
        for(int i=0; i<boardLayout.length; i++){
            for(int j=0; j<boardLayout[i].length; j++) {
                if(boardLayout[i][j] == calledNum){
                    boardLayout[i][j] = occupiedNum;
                }
            }
        }
    }

    public void hasWon(){
        isWinningBoard = isWinner();
    }

    public boolean isWinner(){
        for(int i = 0; i<boardLayout.length; i++){
            if(boardLayout[i][0] == occupiedNum){
                if(boardLayout[i][1] == occupiedNum) {
                    if(boardLayout[i][2] == occupiedNum){
                        if(boardLayout[i][3] == occupiedNum){
                            if(boardLayout[i][4] == occupiedNum){
                                return true;
                            }
                        }
                    }
                }
            }
        }

        for(int i = 0; i<boardLayout[0].length; i++){
            if(boardLayout[0][i] == occupiedNum){
                if(boardLayout[1][i] == occupiedNum){
                    if(boardLayout[2][i] == occupiedNum){
                        if(boardLayout[3][i] == occupiedNum){
                            if(boardLayout[4][i] == occupiedNum){
                                return true;
                            }
                        }
                    }
                }
            }
        }

        return false;
    }


    public int calculateScore(int winningCall){
        int score = 0;

        for(int i=0; i<boardLayout.length; i++) {
            for (int j = 0; j < boardLayout[i].length; j++) {
                if(boardLayout[i][j] != occupiedNum){
                    //System.out.println(boardLayout[i][j]);
                    score += boardLayout[i][j];
                }
            }
        }

        score = score * winningCall;

        return score;
    }
}
