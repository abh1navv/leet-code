class Solution {
    public int twoCitySchedCost(int[][] costs) {
        
        Arrays.sort(costs, (a,b)->Math.abs(b[0]-b[1])-Math.abs(a[0]-a[1]));
        
        int first = 0,second=0;
        int sum = 0, n=costs.length/2;
        int index = 0;
        int[] curr;
        
        while(first!=n && second!=n) {
            curr = costs[index++];
            if(curr[0]> curr[1]) {
                sum+=curr[1];
                second++;
            } else {
                sum+=curr[0];
                first++;
            }
        }
        
        while(first!=n) {
            curr = costs[index++];
            sum+=curr[0];
            first++;
        }
        while(second!=n) {
            curr = costs[index++];
            sum+=curr[1];
            second++;
        }
        
        return sum;
    }
}