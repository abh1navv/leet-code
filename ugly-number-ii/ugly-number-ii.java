class Solution {
    public int nthUglyNumber(int n) {
        int count = 1, current = 1;
        int[] ugly = new int[n];
        ugly[0] = 1;
        int index2=0,index3=0,index5=0;
        int next2=2,next3=3,next5=5;
        while(count<n) {
            current = Math.min(Math.min(next2,next3),next5);
            ugly[count++] = current;
            if(current == next2) next2 = 2*ugly[++index2];
            if(current == next3) next3 = 3*ugly[++index3];
            if(current == next5) next5 = 5*ugly[++index5];
        }
        return ugly[n-1];
    }  
}