class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(source);
        
        Set<Integer> seen = new HashSet<>();
        int current = 0;
        while(!stack.isEmpty()) {
            current = stack.pop();
            seen.add(current);
            
            if(current == destination) {
                return true;
            }
            
            for(int[] edge: edges) {
                if(edge[0] == current  && !seen.contains(edge[1])) {
                    if(edge[1] == destination) return true;
                    stack.push(edge[1]);
                } else if(edge[1] == current  && !seen.contains(edge[0])) {
                    if(edge[0] == destination) return true;
                    stack.push(edge[0]);
                }
            }
            
        }
        return false;
    }
}