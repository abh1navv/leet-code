class Solution {
    public int maximalSquare(char[][] matrix) {
        int max = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        for(int i=0; i<cols; i++){
            max = Math.max(max, matrix[0][i]-48);
        }
        
        for(int i=0; i<rows; i++) {
            for(int j=cols-1; j>=0; j--) {
                if(i>0 && j<cols-1 && matrix[i][j] == '1') {
                    matrix[i][j] = (char)('1'+ (Math.min(Math.min(matrix[i][j+1], matrix[i-1][j]), matrix[i-1][j+1]) -'0'));
                }
                max = Math.max(max, matrix[i][j]-'0');

            }
        }
                
        return max*max;
    }
}