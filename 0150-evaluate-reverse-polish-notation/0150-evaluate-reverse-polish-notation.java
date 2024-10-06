class Solution {
    public int evalRPN(String[] tokens) {
        int[] stack = new int[tokens.length];
        int top = 0;
        
        for(String token: tokens) {
            if(token.equals("+") || token.equals("*") || token.equals("-") || token.equals("/")) {
                int second = stack[--top];
                int first = stack[--top];
                stack[top++] = calculate(first, second, token);
            } else {
                stack[top++] = Integer.parseInt(token);
            }
        }
        //System.out.println(Arrays.toString(stack));
        return stack[0];
    }
    
    int calculate(int first, int second, String token) {
        if(token.equals("+")) {
            return first+second;
        } else if(token.equals("*")) {
            return first*second;
        } else if(token.equals("-")) {
            return first-second;
        } else {
            return first/second;
        }
    }
}