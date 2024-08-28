class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visited=new HashSet<>();
        List<Integer> queue = new ArrayList<>();
        queue.add(0);
        
        int start=0;
        
        while(start < queue.size()) {
            if(!visited.contains(queue.get(start))) {
                queue.addAll(rooms.get(queue.get(start)));
                visited.add(queue.get(start));
            }
            start++;
        }
        
        return visited.size() == rooms.size();
    }
}