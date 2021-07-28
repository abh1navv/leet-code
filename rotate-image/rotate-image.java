class Solution {
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        int curr = 1;
        for(int i=0;i<len;i++) {
            for(int j=0;i+j<len-1;j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[len-j-1][len-i-1];
                matrix[len-j-1][len-i-1] = temp;
            }
        }
        for(int i=0;i<len/2;i++) {
            for(int j=0;j<len;j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[len-i-1][j];
                matrix[len-i-1][j] = temp;
            }
        }
    }
}