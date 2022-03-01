class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int currentCap = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.station - b.station);
        
        for(int[] trip:trips) {
            pq.offer(new Pair(trip[1], trip[0]));
            pq.offer(new Pair(trip[2], -trip[0]));
        }
        
        while(!pq.isEmpty()) {
            Pair current = pq.poll();
            currentCap+=current.capacity;
            if(currentCap > capacity && current.station != pq.peek().station){
                return false;
            }
        }
        
        return true;
    }
    
    class Pair {
        int capacity;
        int station;
        
        Pair(int station, int capacity) {
            this.capacity = capacity;
            this.station = station;
        }
    }
}