class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] required = new int[numCourses];
        Map<Integer, List<Integer>> dependents = new HashMap<>();
        
        for(int[] pair: prerequisites) {
            required[pair[0]] ++;
            var list = dependents.getOrDefault(pair[1], new ArrayList<>());
            list.add(pair[0]);
            dependents.put(pair[1], list);
        }
        
        Queue<Integer> next = new LinkedList<>();
        
        for(int i=0; i<numCourses; i++) {
            if(required[i] == 0) {
                next.add(i);
            }
        }
        
        int count = 0;
        
        
        while(!next.isEmpty()) {
            int len = next.size();
            while(len > 0) {
                int n = next.poll();
                count++;
                if(dependents.containsKey(n)) {
                    for(int x: dependents.get(n)) {
                        required[x]--;
                        if(required[x] <= 0){
                            next.add(x);
                        }
                    }
                }
                len--;
            }
            
        }
        
        return count == numCourses;
    }
}