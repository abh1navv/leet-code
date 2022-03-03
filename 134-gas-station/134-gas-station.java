class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int extra = 0, tank = 0, start = 0;
        
        for(int i=0;i<gas.length;i++) {
            tank += gas[i] - cost[i];
            extra += gas[i] - cost[i];
            
            if(extra < 0) {
                start = i+1;
                extra = 0;
            }
        }
        
        return tank >= 0 ? start : -1;
    }
    
    

}