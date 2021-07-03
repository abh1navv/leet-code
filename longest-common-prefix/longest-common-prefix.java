class Solution {
    public String longestCommonPrefix(String[] strs) {
        int lenSmallest = findSmallestLength(strs);
        int i=0, prelen=0;
        boolean prefixMatches = true;
        for(i=0;i<lenSmallest && prefixMatches;i++) {
            char ch = strs[0].charAt(i);
            for(String str: strs) {
                if(str.charAt(i) != ch) {
                    prefixMatches = false;
                    break;
                }
            }
            if(prefixMatches) prelen++;

        }
        
        return prelen>0?strs[0].substring(0,prelen):"";
    }
    
    public int findSmallestLength(String[] strs) {
        int minLen = strs[0].length();
        for(String str: strs) {
            int currLen = str.length();
            if(currLen < minLen) {
                minLen = currLen;
            }
        }
        return minLen;
    }
}