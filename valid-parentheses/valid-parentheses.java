class Solution {
    public boolean isValid(String s) {
        String starting = "[{(";
        String ending = "]})";
        
        
        int len = s.length();
        char[] stack = new char[len];
        int top=0;

        if(len%2 == 1) return false;
        for(int i=0;i<len;i++) {
            char ch = s.charAt(i);
            int index = ending.indexOf(ch);
            if(index != -1) {
                if(top <=0 || starting.indexOf(stack[--top]) != index) {
                    return false;
                }
            } else {
                stack[top++] = ch;
            }
        }
        return top==0;
    }
}