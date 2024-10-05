class Solution {
    public int[][] generateMatrix(int n) {
        
        int[][] matrix = new int[n][n];
        
        int row = 0, col = 0, len = n-1;
        int nextRow = 0, nextCol = 0, start=0;
        
        for(int i=1; i<= n*n; i++) {
            matrix[row][col] = i;
            
            nextRow = getNextRow(row, col, len, start);
            nextCol = getNextCol(row, col, len, start);
             if(col == start && row == start+1) {
                 len--;
                 start++;
             }
            
            row = nextRow;
            col = nextCol;
            
            //System.out.println(row +" "+col);
        }
        
        return matrix;
    }
    
    int getNextRow(int row, int col, int len, int start) {
        if(col == len && row < len) return row+1; // going down
        if(col == start && row > start+1) return row-1; // going up
        
        
        return row;
    }
    
    int getNextCol(int row, int col, int len, int start) {
        if(row == start && col < len) return col+1; // going right
        if(row == len && col > start) return col-1; // going left
        if(col == start && row == start+1) return col+1; // going right
        
        return col;
    }

    
    
}