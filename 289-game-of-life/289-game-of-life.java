class Solution {
    public void gameOfLife(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                int count = getEight(i,j, board, rows, cols);
                if(count == 3 && board[i][j] == 0) board[i][j] = -1;
                if(count < 2 && board[i][j] == 1) board[i][j] = 2;
                if(count > 3 && board[i][j] == 1) board[i][j] = 2;
            }
        }
        
        for(int i=0; i<rows; i++) {
            //System.out.println(Arrays.toString(board[i]));
            for(int j=0; j<cols; j++) {
                if(board[i][j] == 2) board[i][j]=0;
                if(board[i][j] == -1) board[i][j]=1;
            }
        }

        
        
    }
    
    int getEight(int i, int j, int[][]board, int rows, int cols) {
        int count = 0;
        if(i>0) count = board[i-1][j]>0 ? count+1:count;
        if(j>0) count=board[i][j-1]>0 ? count+1:count;
        if(i<rows-1 ) count=board[i+1][j]>0 ? count+1:count;
        if(j<cols-1) count=board[i][j+1]>0 ? count+1:count;
        if(i>0 && j>0) count=board[i-1][j-1]>0 ? count+1:count;
        if(i>0 && j<cols-1) count=board[i-1][j+1]>0 ? count+1:count;
        if(i<rows-1 && j>0) count=board[i+1][j-1]>0 ? count+1:count;
        if(i<rows-1 && j<cols-1) count=board[i+1][j+1]>0 ? count+1:count;
        return count;
    }
}