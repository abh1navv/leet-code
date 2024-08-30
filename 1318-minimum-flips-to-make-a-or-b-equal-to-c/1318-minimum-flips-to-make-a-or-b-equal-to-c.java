class Solution {
    public int minFlips(int a, int b, int c) {
        int count=0;
        while(a!=0 || b!=0 || c!=0){
            int cdigit = c%2;
            int bdigit = b%2;
            int adigit = a%2;
            //System.out.println(adigit+" "+bdigit+" "+cdigit+" "+count);

            if(cdigit == 0) {
                count+=adigit+bdigit;
            } else if(adigit==0 && bdigit==0) {
                count++;
            }
            
            
            a = a/2;
            b = b/2;
            c = c/2;
            
            //System.out.println(a+" "+b+" "+c+" "+count);
        }
        
        return count;
    }
}