class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] stack = new int[temperatures.length];
        stack[0] = 0;
        int index=0;
        for(int i=1; i<temperatures.length; i++) {
            while(index>=0 && temperatures[i] > temperatures[stack[index]]) {
                temperatures[stack[index]] = i-stack[index];
                index--;
            } 
            
            stack[++index] = i;
        }
        
        while(index >=0) {
            temperatures[stack[index]] = 0;
            index--;
        }
        
        return temperatures;
    }
}