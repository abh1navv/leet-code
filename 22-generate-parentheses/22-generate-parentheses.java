class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        
        generate(ans, new StringBuilder(), n, 0, 0);
        
        return ans;
    }
    
    public void generate(List<String> ans, StringBuilder current, int n, int start, int close) {
        if(start == n && close == n) {
            ans.add(current.toString());
        } else if(start == close) {
            current.append("(");
            generate(ans, current, n, start+1, close);
            current.deleteCharAt(current.length()-1);
        } else if(start == n) {
            current.append(")");
            generate(ans, current, n, start, close+1);
                        current.deleteCharAt(current.length()-1);

        } else {
            current.append("(");
            generate(ans, current, n, start+1, close);
            current.deleteCharAt(current.length()-1);
            current.append(")");
            generate(ans, current, n, start, close+1);
            current.deleteCharAt(current.length()-1);

        }
    }
    
}