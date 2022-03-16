class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        stack.push(pushed[0]);
        
        int indexPushed = 1, indexPopped = 0;
        
        while(indexPushed < pushed.length) {
            if(!stack.isEmpty() && stack.peek() == popped[indexPopped]) {
                stack.pop();
                indexPopped++;
            } else {
                stack.push(pushed[indexPushed++]);
            }
        }
        
        while(indexPopped < popped.length) {
            if(stack.pop() != popped[indexPopped++]) return false;
        }
        
        return indexPushed == pushed.length && indexPopped == popped.length && stack.isEmpty();
    }
    
}