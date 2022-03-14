class Solution {
    public boolean isSubsequence(String s, String t) {
        int lenS = s.length();
        int lenT = t.length();
        
        //if(len)
        
        int[] dp = new int[lenT+1];
        
        for(int i=0; i<lenS;i++) {
            int prevLeft = 0;
            int prev = 0;
            for(int j=0; j<lenT;j++) {
                prevLeft = prev;
                prev = dp[j+1];
                if(s.charAt(i) == t.charAt(j)) {
                    dp[j+1] = 1+prevLeft;
                } else {
                    dp[j+1] = Math.max(prev, dp[j]);
                }
                if(dp[j+1] == lenS) {
                    return true;
                }
            }
            System.out.println(Arrays.toString(dp));
        }
        
        return dp[0] == lenS;
    }
}