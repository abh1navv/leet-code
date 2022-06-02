class Solution {
    public int totalFruit(int[] fruits) {
        if(fruits.length == 1) return 1;
        
        int lastIndexOfFirst=0, lastIndexOfSecond=-1, start=0;
        int first=fruits[0], second=-1;
        int max = 1, curr=0;
        
        for(int i=1;i<fruits.length;i++) {
            if(fruits[i] == first) {
              lastIndexOfFirst = i;  
            } else if(second == -1) {
              second = fruits[i];
              lastIndexOfSecond = i;
            } else if(second == fruits[i]) {
              lastIndexOfSecond = i;  
            } else {
                curr = i-start;
                max = Math.max(max, curr);
                
                if(fruits[i-1] == first) {
                    start = lastIndexOfSecond+1; 
                } else {
                    start = lastIndexOfFirst+1;
                    first = second;
                    lastIndexOfFirst = lastIndexOfSecond;
                }
                
                second = fruits[i];
                lastIndexOfSecond = i;
            }
        }
        curr = fruits.length-Math.min(lastIndexOfFirst+1, start);
        max = Math.max(max, curr);
        
        return max;
    }
}