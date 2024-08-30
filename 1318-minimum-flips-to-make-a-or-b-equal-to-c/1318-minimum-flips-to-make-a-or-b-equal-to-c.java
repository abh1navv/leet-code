class Solution {
    public int minFlips(int a, int b, int c) {
        int count=0;
        while(a!=0 || b!=0 || c!=0){
            if(c%2 == 0) {
                count+=b%2+a%2;
            } else if( a%2==0 && b%2==0) {
                count++;
            }
            
           a = a>>1;
            b = b>>1;
            c = c>>1;
            
        }
        
        return count;
    }
}