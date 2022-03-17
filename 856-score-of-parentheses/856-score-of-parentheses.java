class Solution {
    public int scoreOfParentheses(String s) {
        Stack<String> stack = new Stack<>();
        
        int len = s.length();
        int temp = 0;
        for(int i=0; i<len; i++) {
            char ch = s.charAt(i);
            if(ch == '(') {
                stack.push(String.valueOf(ch));
            } else {
                temp = 0;
                while(!stack.isEmpty() && !stack.peek().equals("(")) {
                    String str = stack.pop();
                    temp+=Integer.parseInt(str);
                }
                stack.pop();
                temp = temp == 0? 1: temp*2;
                stack.push(String.valueOf(temp));
            }
        }
        
        int sum = 0;
        while(!stack.isEmpty()) {
            sum+=Integer.parseInt(stack.pop());
        }
        
        return sum;
    }
}