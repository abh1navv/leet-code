class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<long[]> pq=new PriorityQueue<>((a,b) -> (int)(a[0]-b[0]));
        
        for(int[] point: points) {
            int distance = point[0]*point[0] + point[1]*point[1];
            pq.offer(new long[]{distance, point[0], point[1]});
        }
        
        int[][] ans=new int[k][2];
        
        for(int[] point: ans) {
            long[] curr = pq.poll();
            point[0] = (int)curr[1];
            point[1] = (int)curr[2];
        }
        
        return ans;
    }
}