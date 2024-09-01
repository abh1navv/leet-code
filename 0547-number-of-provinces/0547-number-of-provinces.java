class Solution {
    public int findCircleNum(int[][] isConnected) {
        var n = isConnected.length;
        boolean[] visited=new boolean[n];
        int count=0;
        for(int i=0;i<n;i++) {
            if(!visited[i]) {
                visited[i]=true;
                count++;
                markVisited(i, visited, isConnected);
            }
        }
        return count;
    }
    
    void markVisited(int row, boolean[] visited, int[][] isConnected) {
        for(int i=0;i<isConnected.length;i++) {
            if(!visited[i] && isConnected[row][i] == 1) {
                visited[i]=true;
                markVisited(i, visited, isConnected);
            }
        }
    }
}