class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int len = asteroids.length;
        int[] positive=new int[len];
        int[] negative=new int[len];
        int posTop = -1, negTop=-1;
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
                        negative[++negTop] = asteroid;
                    }
                } else {
                    negative[++negTop]=asteroid;
                }
            }
            //System.out.println(Arrays.toString(positive) + ":" +posTop);
            //System.out.println(Arrays.toString(negative) + ":" +negTop);

        }
        int[] ans = new int[posTop+1+negTop+1];
        int index = ans.length-1;
        while(posTop > -1) {
            ans[index--] = positive[posTop--]; 
        }
        while(negTop > -1) {
            ans[index--] = negative[negTop--]; 
        }
        
        return ans;
    }
}