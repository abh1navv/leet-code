class Solution {
    public int orangesRotting(int[][] grid) {
        LinkedList<int[]> queue=new LinkedList<>();
    
        int m = grid.length; 
        int n=grid[0].length;
        
        int total = 0;
        int count=0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length;j++) {
                if(grid[i][j] == 2) {
                    queue.add(new int[]{i,j});
                }
                
                if(grid[i][j]!=0) {
                    total ++;
                }
            }
        }
        int ans = -1;
        while(!queue.isEmpty()) {
            
            ans++;
            int len = queue.size();
            for(int i=0; i<len; i++) {
                int[] next = queue.pollFirst();
                               // System.out.print(next[0]+":"+next[1]+" ");

                count++;
                if(next[0] > 0 && grid[next[0]-1][next[1]] == 1) {
                    queue.add(new int[]{next[0]-1,next[1]});
                    grid[next[0]-1][next[1]] = 2;
                } 
                if(next[0] < m-1 && grid[next[0]+1][next[1]] == 1) {
                    queue.add(new int[]{next[0]+1,next[1]});
                    grid[next[0]+1][next[1]] = 2;
                } 
                if(next[1] > 0 && grid[next[0]][next[1]-1] == 1) {
                    queue.add(new int[]{next[0],next[1]-1});
                    grid[next[0]][next[1]-1] = 2;
                } 
                if(next[1] < n-1 && grid[next[0]][next[1]+1] == 1) {
                    queue.add(new int[]{next[0],next[1]+1});
                    grid[next[0]][next[1]+1] = 2;
                } 
            }
                            //System.out.println(count);

            
        }
        
        return count == total? ans == -1?0:ans:-1;
        
        
    }
}