class Solution {
    public String removeStars(String s) {
        char[] chArr= s.toCharArray();
        char[] stack = new char[chArr.length];
        int index = 0;
        for(int i=0; i<chArr.length; i++) {
            if(chArr[i] != '*') stack[index++] = chArr[i];
            else index--;
        }
        
        return String.copyValueOf(stack, 0, index);
        
    }
}