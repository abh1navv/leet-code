class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = findRow(matrix, target);
        return row>=0 && binarySearch(matrix[row], target);
    }
    
    public int findRow(int[][] matrix, int target) {
        int start=0, end=matrix.length-1, mid=0;
        
        while(start<=end) {
            mid = (start+end)/2;
            if(matrix[mid][0] > target){
                end = mid-1;
            } else if (matrix[mid][0] <= target && matrix[mid][matrix[mid].length-1] >= target){
                return mid;
            } else {
                start = mid+1;
            }
        }
        
        return -1;
    }
    
    public boolean binarySearch(int[] matrix, int target) {
        int start=0, end=matrix.length-1, mid=0;
        
        while(start<=end) {
            mid = (start+end)/2;
            if(matrix[mid] > target){
                end = mid-1;
            } else if (matrix[mid] < target){
                start = mid + 1;
            } else {
                return true;
            }
        }
        
        return false;
    }
}