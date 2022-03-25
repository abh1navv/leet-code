class Solution {
    public int twoCitySchedCost(int[][] costs) {
        PriorityQueue<Cost> pqFirst = new PriorityQueue<>(
            (a,b)->Math.abs(b.first-b.second)-Math.abs(a.second-a.first));
        //PriorityQueue<Cost> pqSec = new PriorityQueue<>((a,b)->a.second-b.second);
        for(int i=0; i<costs.length; i++) {
            Cost cost = new Cost(costs[i][0], costs[i][1]);
            pqFirst.offer(cost);
            //pqSec.offer(cost);
        }
        
        Set<Cost> seen = new HashSet<>();
        int first = 0,second=0;
        int sum = 0, n=costs.length/2;
        
        while(first!=n && second!=n) {
            Cost curr = pqFirst.poll();
            if(curr.first > curr.second) {
                sum+=curr.second;
                second++;
            } else {
                sum+=curr.first;
                first++;
            }
        }
        
        while(first!=n) {
            Cost curr = pqFirst.poll();
            sum+=curr.first;
            first++;
        }
        while(second!=n) {
            Cost curr = pqFirst.poll();
            sum+=curr.second;
            second++;
        }
        
        
        
        // while(n!=0) {
        //     while(seen.contains(pqFirst.peek())) {
        //         pqFirst.poll();
        //     }
        //     Cost curr = pqFirst.poll();
        //     sum+=curr.first;
        //     seen.add(curr);
        //     while(seen.contains(pqSec.peek())) {
        //         pqSec.poll();
        //     }
        //     curr = pqSec.poll();
        //     sum+=curr.second;
        //     seen.add(curr);
        //     n--;
        // }
        
        
        
        return sum;
    }
    
    class Cost {
        int first;
        int second;
        Cost(int first, int second) {
            this.first = first;
            this.second = second;
        }
        
        public String toString() {
            return first + ":" +second;
        }
    }
}