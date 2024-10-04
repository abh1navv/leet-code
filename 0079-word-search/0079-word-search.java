class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        int len = word.length();
        
        int[][] dp=new int[rows][cols];
        
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                if(exists(board, word, i, j, 0, rows, cols, len, dp)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public boolean exists(char[][] board, String word, int i, int j, int pos, int rows, int cols, int len, int[][] dp) {
        if(i<0 || j<0 || i==rows || j==cols || dp[i][j] == 1) return false;
        else if(board[i][j] != word.charAt(pos)) return false;
        else if(pos == len-1) return true;
        else {
            dp[i][j] = 1;
            boolean ans = false;
            ans = ans || exists(board, word, i-1, j, pos+1, rows, cols, len, dp);
            ans = ans || exists(board, word, i, j-1, pos+1, rows, cols, len, dp);
            ans = ans || exists(board, word, i+1, j, pos+1, rows, cols, len, dp);
            ans = ans || exists(board, word, i, j+1, pos+1, rows, cols, len, dp);
            dp[i][j] = 0;
            return ans;
        }
    }
}