class Solution {
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] dp=new int[2][len];
        
        for(int i=len-1; i>=0; i--) {
            dp[0][i] = 1;
            for(int j=i+1; j<len; j++) {
                if(s.charAt(i) == s.charAt(j)) dp[0][j] = dp[1][j-1]+2;
                else {
                    dp[0][j] = Math.max(dp[1][j], dp[0][j-1]);
                }
            }
            int[] temp = dp[0];
            dp[0] = dp[1];
            dp[1] = temp;
        }
        
        return dp[1][len-1];
    }
}