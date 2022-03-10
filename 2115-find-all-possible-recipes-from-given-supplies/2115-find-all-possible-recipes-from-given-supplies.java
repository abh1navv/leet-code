class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, List<String>> adjList=new HashMap<>();
        Map<String, Integer> count = new HashMap<>();
        List<String> ans = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        
        for(String s: supplies) {
            count.put(s, 0);
            queue.offer(s);
        }
        
        IntStream.range(0, recipes.length).forEach(i->adjList.put(recipes[i], new ArrayList<>()));
        IntStream.range(0, supplies.length).forEach(i->adjList.put(supplies[i], new ArrayList<>()));
        
        for(int i=0; i<recipes.length; i++) {
            List<String> current = ingredients.get(i);
            count.put(recipes[i], current.size());
            for(String s: current) {
                if(adjList.containsKey(s)) {
                    adjList.get(s).add(recipes[i]);
                } else {
                    adjList.put(s, new ArrayList<>());
                    adjList.get(s).add(recipes[i]);
                }
            }
            if(count.get(recipes[i]) == 0) queue.offer(recipes[i]);
        }
        
        
        int k=0;
        while(!queue.isEmpty()) {
            String current = queue.poll();
            k++;
            if(k>supplies.length) {
                ans.add(current);
            }
            
            List<String> dependents = adjList.get(current);
            
            for(String dependent: dependents) {
                count.put(dependent, count.get(dependent)-1);
                if(count.get(dependent) == 0) queue.offer(dependent);
            }
        }
        
        return ans;
    }
    
}