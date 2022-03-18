class Solution {
    public String removeDuplicateLetters(String s) {
        int[] count = new int[26];     
        char[] arr = s.toCharArray();
        for(char c: arr) {
            count[c-'a']++;
        }
        
        boolean[] visited=new boolean[26];
        Stack<Character> stack = new Stack<>();
        
        
        for(char c: arr) {
            count[c-'a']--;
            if(!visited[c-'a']) {
                while(!stack.isEmpty() && stack.peek() > c && count[stack.peek()-'a'] !=0) {
                    visited[stack.pop()-'a'] = false;
                }

                visited[c-'a'] = true;
                stack.push((char)c);
            }
        }
        
        StringBuilder sb =new StringBuilder();
        
        while(!stack.isEmpty()) {
            sb.insert(0,stack.pop());
        }
        
        
        return sb.toString();
    }
    
    
}