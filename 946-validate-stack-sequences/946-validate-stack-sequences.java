class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        stack.push(pushed[0]);
        return checkValidity(pushed, popped, 1, 0, stack);
    }
    
    public boolean checkValidity(int[] pushed, int[] popped, int indexPushed, int indexPopped, Stack<Integer> stack) {
        while(indexPushed < pushed.length) {
            if(!stack.isEmpty() && stack.peek() == popped[indexPopped]) {
                stack.pop();
                indexPopped++;
            } else {
                stack.push(pushed[indexPushed++]);
            }
            //System.out.println(stack);
        }
        
        while(indexPopped < popped.length) {
            if(stack.pop() != popped[indexPopped++]) return false;
        }
        
        return indexPushed == pushed.length && indexPopped == popped.length && stack.isEmpty();

    }
}