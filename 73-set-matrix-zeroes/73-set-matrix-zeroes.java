class Solution {
    public void setZeroes(int[][] matrix) {
        int rlen = matrix.length;
        int clen = matrix[0].length;
        int column0=1;
        for(int i=0; i< rlen; i++){
            if(matrix[i][0] == 0) {
                column0 = 0;
            }
            for(int j=1; j<clen; j++) {
                if(matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for(int i=rlen-1; i>=0; i--) {
            for(int j=clen-1; j>=1; j--) {
                if(matrix[i][0] == 0 || matrix[0][j]==0) {
                    matrix[i][j] = 0;
                } 
            }
            if(column0 == 0) matrix[i][0] = 0;
        }
    }
}