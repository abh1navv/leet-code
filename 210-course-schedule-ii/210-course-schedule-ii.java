class Solution {
    public int[] findOrder(int num, int[][] pre) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        IntStream.range(0, num).forEach(i->map.put(i, new ArrayList<>()));
        
        int[] out = new int[num];
        int[] ans = new int[num];
        int index = 0;
                                        
        for(int[] i: pre) {
            map.get(i[1]).add(i[0]);
            out[i[0]]++;
        }
        
        Queue<Integer> toVisit = new LinkedList<>();
        
        for(int i=0;i<num;i++) {
            if(out[i] == 0) toVisit.offer(i);
        }
        
        while(!toVisit.isEmpty()) {
            int curr = toVisit.poll();
            ans[index++] = curr;
            List<Integer> list = map.get(curr);
            
            if(!list.isEmpty()) {
                for(Integer i: list) {
                    out[i]--;
                    if(out[i] == 0) toVisit.offer(i);
                }
            }
        }
        
        
        return index == num ? ans: new int[]{};
    }
    
}