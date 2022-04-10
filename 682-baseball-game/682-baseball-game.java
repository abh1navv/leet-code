class Solution {
    public int calPoints(String[] ops) {
        int sum=0, temp;
        Stack<Integer> stack = new Stack();
        
        for(String s: ops) {
            if(s.equals("C")) {
                stack.pop();
            } else if(s.equals("D")) {
                temp = stack.peek();
                stack.push(temp*2);
            } else if(s.equals("+")) {
                temp = stack.pop();
                int top = stack.peek();
                stack.push(temp);
                stack.push(top+temp);
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        
        for(int i: stack) {
            sum+=i;
        }
        
        
        return sum;
    }
}