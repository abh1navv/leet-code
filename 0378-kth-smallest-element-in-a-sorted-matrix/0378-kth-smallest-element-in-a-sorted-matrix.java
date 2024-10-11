class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        
        int n = matrix.length;
        for(int i=0; i<n; i++) {
        for(int j=0; j<n; j++) {
            pq.add(matrix[i][j]);
        }
        }
        
        int ans = 0;
        while(k!=1) {
            k--;
            pq.poll();
        }
        
        return pq.poll();
        
    }
}