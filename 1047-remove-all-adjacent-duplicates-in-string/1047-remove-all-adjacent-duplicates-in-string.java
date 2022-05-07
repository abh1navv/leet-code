class Solution {
    public String removeDuplicates(String s) {
        char[] chArr  = s.toCharArray();
        int top = 0;
        for(int i=1; i<chArr.length; i++) {
            if(top > -1 && chArr[i]==chArr[top]) top--;
            else {
                chArr[++top] = chArr[i];
            }
        }
        
        return String.valueOf(Arrays.copyOfRange(chArr, 0, top+1));
        
    }
}