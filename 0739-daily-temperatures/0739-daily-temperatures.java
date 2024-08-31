class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[][] stack = new int[temperatures.length][1];
        stack[0] = new int[]{0,temperatures[0]};
        int index=0;
        for(int i=1; i<temperatures.length; i++) {
            while(index>=0 && temperatures[i] > stack[index][1]) {
                temperatures[stack[index][0]] = i-stack[index][0];
                index--;
            } 
            
            stack[++index] = new int[]{i, temperatures[i]};
        }
        
        while(index >=0) {
            temperatures[stack[index][0]] = 0;
            index--;
        }
        
        return temperatures;
    }
}