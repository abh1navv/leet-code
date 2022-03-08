class Solution {
    public int characterReplacement(String s, int k) {
        int len = s.length();
        int max = 0, toBeChanged = 0, maxLength = 0;
        int[] count = new int[26];
        int left = 0;
        
        for(int right=0; right<len; right++) {
            max = Math.max(max, ++count[s.charAt(right) - 'A']);
            
            toBeChanged =  right-left+1 - max;
            if(toBeChanged > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }
            
            maxLength = Math.max(right-left+1, maxLength);
        }
        
        return maxLength;
    }
}