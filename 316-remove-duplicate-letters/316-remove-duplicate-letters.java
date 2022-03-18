class Solution {
    public String removeDuplicateLetters(String s) {
        int[] count = new int[26];        
        s.chars().forEach(c->count[c-'a']++);
        
        boolean[] visited=new boolean[26];
        Stack<Character> stack = new Stack<>();
        
        
        s.chars().forEach(c->{
            count[c-'a']--;
            if(!visited[c-'a']) {
                while(!stack.isEmpty() && stack.peek() > c && count[stack.peek()-'a'] !=0) {
                    visited[stack.pop()-'a'] = false;
                }

                visited[c-'a'] = true;
                stack.push((char)c);
            }
        });
        
        StringBuilder sb =new StringBuilder();
        
        while(!stack.isEmpty()) {
            sb.insert(0,stack.pop());
        }
        
        
        return sb.toString();
    }
    
    
}