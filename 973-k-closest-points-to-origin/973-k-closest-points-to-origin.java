class Solution {
    public int[][] kClosest(int[][] points, int k) {
        quickSelect(points, k, 0 , points.length-1);
        return Arrays.copyOfRange(points, 0, k);
    }
    
    void quickSelect(int[][] points, int k, int start, int end) {
        if(start>=end) return;
       
        int j = partition(points, k, start, end);
        
        if(j == k) return;
        else if(j<k) quickSelect(points, k, j+1 , end);
        else quickSelect(points, k, start, j-1);
    }
    
    int partition(int[][] points, int k, int start, int end) {
        int[] current = points[end];
        int j=start;
        for(int i=start; i<end; i++) {
            if(distance(points[i][0], points[i][1]) <= distance(current[0], current[1])) {
                int[] temp = points[j];
                points[j] = points[i];
                points[i] = temp;
                j++;
            }
        }
        
        int[] temp = points[end];
        points[end] = points[j];
        points[j] = temp;
        
        return j;
    }
    
    int distance(int x, int y) {
        return x*x + y*y;
    }
}