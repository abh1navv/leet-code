class Solution {
    public int[] shortestToChar(String s, char c) {
        int current = -1, prev = -1;
        int index = 0;
        int len = s.length();
        
        int[] ans = new int[len];
        
        while(index < len) {
            if(index > current) {
                prev = current;
                current++;
                while(current<len && s.charAt(current) != c) {
                    current++;
                }
                if(current == len) {
                    current = prev;
                }
            }  
            ans[index] = prev!=-1 ? Math.min(index-prev, Math.abs(current-index)): Math.abs(current-index);
            index++;
        }
        
        return ans;
    }
}