class Solution {
    public String addBinary(String a, String b) {
        int aLen = a.length();
        int bLen = b.length();
        int maxLen = Math.max(aLen, bLen);
        int[] ans = new int[maxLen];
        
        int rem = 0;
        int index = 0;
        while(index<maxLen) {
            int curr = rem;
            if(aLen-index >0) {
                curr+=a.charAt(aLen-index-1)-48;
            }
            
            if(bLen-index >0) {
                curr+=b.charAt(bLen-index-1)-48;
            }
            rem=0;
            if(curr>1) rem=1;
            curr=curr%2;
            
            ans[maxLen-(index++)-1] = curr;
        }

        StringBuilder sb = new StringBuilder();
        if(rem>0) sb.append(1);
        for(int i: ans) {
            sb.append(i);
        }
        
        return sb.toString();
    }
}