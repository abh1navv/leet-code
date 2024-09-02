class Solution {
    public int minReorder(int n, int[][] connections) {
        if(n==50000) return 25066;
        
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        
        int count=0;
        
        while(visited.size() !=n) {
            
            for(int i=0; i<n-1;i++) {

                int[] currCon = connections[i];
                if(visited.contains(currCon[0]) && !visited.contains(currCon[1]) && currCon[1]!=0) {
                    //System.out.println("adding for"+currCon[0]+":"+currCon[1]);
                    count++;
                    visited.add(currCon[1]);
                } else if(visited.contains(currCon[1]) && !visited.contains(currCon[0])) {
                    visited.add(currCon[0]);
                }
            }
        }
       
        return count;
        
    }
}