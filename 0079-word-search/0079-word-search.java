class Solution {
    
    //Set<Search> unsuccessfulSearches = new HashSet<>();
    
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(found(i, j, word, 0, m, n, board)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    boolean found(int row, int col, String word, int index, int m, int n,char[][] board) {
        
        
        if(board[row][col] != word.charAt(index)) {
            return false;
        }
        index++;

        if(index == word.length()) {
            return true;
        }
    
        boolean left = false, right = false, top = false, bottom = false;
        
        char temp =  board[row][col];
        board[row][col] = '0';
        
        if(row > 0) {
            left = found(row-1, col, word, index, m, n, board);
        }
        
        if(row <m-1) {
            right = found(row+1, col, word, index, m, n, board);
        }
        
        if(col > 0) {
            top = found(row, col-1, word, index, m, n, board);
        } 
        
        if(col <n-1) {
            bottom = found(row, col+1, word, index, m, n, board);
        }
        
        board[row][col] = temp;
        
        return left || right || top || bottom;
        
    }
}