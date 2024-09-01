class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int len = asteroids.length;
        int[] positive=new int[len];
        int posTop = -1, negTop=len;
        for(int asteroid: asteroids) {
            if(asteroid > 0) {
               
                positive[++posTop] = asteroid;
            
                
            } else {
                if(posTop > -1) {
                    while(posTop > -1 && positive[posTop]*-1 > asteroid) {
                        posTop--;
                    } 
                    if(posTop > -1 && positive[posTop]*-1 == asteroid) {
                        posTop--;
                    } else if(posTop == -1){
                        positive[--negTop] = asteroid;
                    }
                } else {
                    positive[--negTop]=asteroid;
                }
            }
        }
        int[] ans = new int[posTop+1+(len-negTop)];
        int index = ans.length-1;
        while(posTop > -1) {
            ans[index--] = positive[posTop--]; 
        }
        while(negTop < len) {
            ans[index--] = positive[negTop++]; 
        }
        
        return ans;
    }
}