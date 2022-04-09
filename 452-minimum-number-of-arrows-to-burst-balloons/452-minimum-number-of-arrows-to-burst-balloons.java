class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a,b)->Integer.compare(a[0],b[0]));
        int currEnd = points[0][1], count=1;
        for(int[] point: points) {
            if(point[0] > currEnd) {
                count++;
                currEnd = point[1];
            } else {
                currEnd = Math.min(currEnd, point[1]);
            }
        }
        
        return count;        
    }

}