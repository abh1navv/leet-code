class Solution {
    public int eraseOverlapIntervals(int[][] points) {
        Arrays.sort(points, (a,b) -> Integer.compare(a[0],b[0]));
        
        int count=0,i=0, currEnd=0;
        while(i<points.length) {
            currEnd = points[i][1];
            
            while(i<points.length-1 && currEnd > points[i+1][0]) {
                currEnd = Math.min(points[i+1][1], currEnd);
                i++;
                count++;
            }
            //count++;
            i++;
        }
        
        return count;
        
    }
}