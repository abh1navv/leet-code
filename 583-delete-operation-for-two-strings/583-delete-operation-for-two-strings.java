class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp=new int[2][len2+1];
        
        for(int i=0; i<=len1; i++) {
            for(int j=0; j<=len2; j++) {
                if(i==0 || j==0) dp[1][j]=0;
                else
                dp[1][j] = word1.charAt(i-1) == word2.charAt(j-1)? dp[0][j-1]+1: Math.max(dp[0][j], dp[1][j-1]);
            }
            int[] temp = dp[0];
            dp[0] = dp[1];
            dp[1] = temp;
        }
        
        return len1+len2-2*dp[0][len2];
    }
}