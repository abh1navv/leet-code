class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int extra = 0;
        int tank = 0;
        int start = 0;
        
        for(int i=0;i<gas.length;i++) {
            int realCost = gas[i] - cost[i];
            tank += realCost;
            extra += realCost;
            
            if(extra < 0) {
                start = i+1;
                extra = 0;
            }
        }
        
        return tank >= 0 ? start : -1;
    }
    
    

}