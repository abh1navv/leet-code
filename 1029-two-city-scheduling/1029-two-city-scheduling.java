class Solution {
    public int twoCitySchedCost(int[][] costs) {
        
        Arrays.sort(costs, (a,b)->Math.abs(b[0]-b[1])-Math.abs(a[0]-a[1]));
        
        int first = 0,second=0;
        int sum = 0, n=costs.length/2;
        int index = 0;
        
        while(first!=n && second!=n) {
            int[] curr = costs[index++];
            if(curr[0]> curr[1]) {
                sum+=curr[1];
                second++;
            } else {
                sum+=curr[0];
                first++;
            }
        }
        
        while(first!=n) {
            int[] curr = costs[index++];
            sum+=curr[0];
            first++;
        }
        while(second!=n) {
            int[] curr = costs[index++];
            sum+=curr[1];
            second++;
        }
        
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