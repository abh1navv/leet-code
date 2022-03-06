class Solution {
     public boolean searchMatrix(int[][] matrix, int target) {
         int top=0, right = matrix[0].length-1;
        while(top < matrix.length && right >= 0) {
            if(matrix[top][right] < target) top++;
            else if(matrix[top][right] > target) right--;
            else return true;
        }
        return false;
    }
    
    
}