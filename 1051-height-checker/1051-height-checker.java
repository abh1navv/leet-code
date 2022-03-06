class Solution {
    public int heightChecker(int[] heights) {
        int[] expected=new int[101];
        int count = 0;
        for(int i=0; i<heights.length; i++) {
            expected[heights[i]]++;
        }
        int j=0;
        for(int i=1; i<101; i++) {
            if(expected[i]!=0 && i!=heights[j++]) count++;
            if(expected[i] > 1) {
                expected[i--]--;
            }
        }
        return count;
    }
}