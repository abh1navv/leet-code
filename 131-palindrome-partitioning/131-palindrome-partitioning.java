class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        int sLen = s.length();
        getSubstring(s, 0, ans, new ArrayList<String>());
        
        return ans;
    }
    
    public void getSubstring(String s, int index, List<List<String>> ans
                             , List<String> current) {
        if(index == s.length()) {
            ans.add(new ArrayList<>(current));
            return;
        }
        
        for(int i=index; i<s.length(); i++) {
            if(isPalindrome(s, index, i)) {
                current.add(s.substring(index, i+1));
                getSubstring(s, i+1, ans, current);
                current.remove(current.size()-1);
            }
        }
    }
    
    public boolean isPalindrome(String s, int start, int end) {
        while(start <= end) {
            if(s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }
}