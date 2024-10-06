class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        
        getStrings(ans, n, 0, 0, "");
        
        return ans;
    }
    
    void getStrings(List<String> ans, int n, int left, int right, String curr) {
        if(curr.length() == n*2) {
            ans.add(curr);
        }
        
        if(left<n) {
            curr+="(";
            getStrings(ans, n, left+1, right, curr);
            curr = curr.substring(0, curr.length()-1);
        }
        
        if(right<n && right<left) {
            curr+=")";
            getStrings(ans, n, left, right+1, curr);
            curr = curr.substring(0, curr.length()-1);
        }
        
    }
}