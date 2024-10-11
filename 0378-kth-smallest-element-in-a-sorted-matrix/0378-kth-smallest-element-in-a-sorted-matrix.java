class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b) -> a[0]-b[0]);
        
        int n = matrix.length;
        for(int i=0; i<n; i++) {
            pq.offer(new int[]{matrix[i][0], i, 0});
        }
        
        for(int i=0; i<k-1; i++) {
            int[] curr = pq.poll();
            if(curr[2] < n-1) {
                pq.offer(new int[]{matrix[curr[1]][curr[2]+1], curr[1], curr[2]+1});
            } 
        } 

        return pq.poll()[0];
        
    }
}