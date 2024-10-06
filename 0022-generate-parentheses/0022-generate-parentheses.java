class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        
        getStrings(ans, n, 0, 0, new StringBuilder());
        
        return ans;
    }
    
    void getStrings(List<String> ans, int n, int left, int right, StringBuilder curr) {
        if(curr.length() == n*2) {
            ans.add(curr.toString());
        }
        
        if(left<n) {
            curr.append("(");
            getStrings(ans, n, left+1, right, curr);
            curr.deleteCharAt(curr.length()-1);
        }
        
        if(right<n && right<left) {
            curr.append(")");
            getStrings(ans, n, left, right+1, curr);
            curr.deleteCharAt(curr.length()-1);
        }
        
    }
}