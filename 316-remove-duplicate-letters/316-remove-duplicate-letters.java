class Solution {
    public String removeDuplicateLetters(String s) {
        int[] count = new int[26];     
        char[] arr = s.toCharArray();
        for(char c: arr) {
            count[c-'a']++;
        }
        
        boolean[] visited=new boolean[26];
        Deque<Character> stack = new ArrayDeque<>();
        
        int index = 0;
        for(char c: arr) {
            index = c-'a';
            count[index]--;
            if(!visited[index]) {
                while(!stack.isEmpty() && stack.peek() > c && count[stack.peek()-'a'] !=0) {
                    visited[stack.pop()-'a'] = false;
                }

                visited[index] = true;
                stack.push(c);
            }
        }
        
        StringBuilder sb =new StringBuilder();
        
        while(!stack.isEmpty()) {
            sb.append(stack.pollLast());
        }
        
        
        return sb.toString();
    }
    
    
}