class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> stS = new Stack<>();
        Stack<Character> stT = new Stack<>();
        for(char ch: s.toCharArray()) {
            if(ch != '#')
                stS.push(ch);
            else if(!stS.isEmpty())
                stS.pop();
        }
        for(char ch: t.toCharArray()) {
            if(ch != '#')
                stT.push(ch);
            else if(!stT.isEmpty())
                stT.pop();
        }
        if(stS.size() != stT.size()) return false;
        
        while(!stS.isEmpty() && !stT.isEmpty()) {
            if(stS.pop() != stT.pop()) return false;
        }
        
        return stS.isEmpty() && stT.isEmpty();
    }
}