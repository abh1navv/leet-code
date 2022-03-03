class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        Set<Integer> finished = new HashSet<>();
        
        for(int[] prerequisite: prerequisites) {
            List<Integer> current;
            if(adjList.containsKey(prerequisite[0])) {
                current = adjList.get(prerequisite[0]);
            } else {
                current = new ArrayList<>();
            }
            current.add(prerequisite[1]);
            adjList.put(prerequisite[0], current);
        }
        
        while(numCourses > 0) {
            Set<Integer> current = new HashSet<>();
            current.add(numCourses-1);
            if(!canFinish(--numCourses, adjList, finished, current)) {
                return false;
            }
        }
        
        return true;
    }
    
    boolean canFinish(int numCourses, Map<Integer, List<Integer>> adjList, Set<Integer> finished, Set<Integer> current) {
        if(finished.contains(numCourses)) return true;
        List<Integer> preRequisites = adjList.get(numCourses);
        
        if(null != preRequisites) {
            for(Integer i: preRequisites) {
                if(current.contains(i)){
                    return false;
                } 
                current.add(i);
                if(!canFinish(i, adjList, finished, current)) {
                    return false;
                }
                current.remove(i);
                finished.add(i);
            }
        }
        finished.add(numCourses);
        return true;
    }
}