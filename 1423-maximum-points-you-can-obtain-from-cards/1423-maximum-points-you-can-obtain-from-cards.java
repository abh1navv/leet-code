class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int maxSum = 0;
        int i=0;
        for(i=0; i<k; i++) {
            maxSum+=cardPoints[i];
        }
        int currSum = maxSum;
        i--;
        int j=0;
        while(j<k) {
            currSum = currSum-cardPoints[i]+cardPoints[cardPoints.length-1-j];
            maxSum = Math.max(currSum, maxSum);
            i--;
            j++;
        }
        
        return maxSum;
    }
}