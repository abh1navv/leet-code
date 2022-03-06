class Solution {
    public int[][] kClosest(int[][] points, int k) {
        //if (points==null || points.length==0 || k<=0) 
        //    return new int[0][0];
        if (points.length<=k) 
            return points;
        
        quickSelect(points, k, 0, points.length-1);
        return Arrays.copyOfRange(points, 0, k);
    }
    
    private void quickSelect(int[][] points, int k, int left, int right) {
        if (left==right) 
            return;
        int i = left;
        int j = right;
        int pivot = left + ((right-left)/2);
        int pivotD = distance(points[pivot]);
        while(left <= right) {
            int leftD = distance(points[left]);
            int rightD = distance(points[right]);
            if(leftD < pivotD) 
                left++;
            else if(rightD>pivotD) 
                right--;
             else {
                swap(points, left, right);
                left++;
                right--;
            }
        }
        
        if (left < k) 
            quickSelect(points, k, left, j);
        else if (left>k) 
            quickSelect(points, k, i, left-1);
        
    }
    
    private int distance(int[] point) {
        return point[0]*point[0] + point[1]*point[1];
    }
    
    private void swap(int[][] points, int i, int j) {
        int[] tmp = points[i];
        points[i] = points[j];
        points[j] = tmp;
    }
}