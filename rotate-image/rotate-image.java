class Solution {
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        int curr = 1;
        for(int i=0;i<len;i++) {
            for(int j=0;i+j<len-1;j++) {
                int newCol = len-i-1;
                int newRow = len-j-1;
                int temp = matrix[i][j];
                matrix[i][j] = matrix[newRow][newCol];
                matrix[newRow][newCol] = temp;
            }
        }
        for(int i=0;i<len/2;i++) {
            for(int j=0;j<len;j++) {
                int newCol = j;
                int newRow = len-i-1;
                int temp = matrix[i][j];
                matrix[i][j] = matrix[newRow][newCol];
                matrix[newRow][newCol] = temp;
            }
        }
    }
}