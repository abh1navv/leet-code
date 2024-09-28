class Solution {
    public boolean isValid(String s) {
        
        char[] stack = new char[s.length()];
        int top = -1;
        
        for(char ch: s.toCharArray()) {
            if(ch == '(' || ch == '{' || ch == '[' ) {
                stack[++top] = ch;
            } else {
                if(top < 0) return false;
                char curr = stack[top];
                if(ch == ')' && curr != '(') return false;
                if(ch == '}' && curr != '{') return false;
                if(ch == ']' && curr != '[') return false;
                top--;
            }
        }
        
        return top==-1;
    }
}