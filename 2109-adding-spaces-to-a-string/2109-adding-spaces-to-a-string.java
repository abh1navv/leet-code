class Solution {
    public String addSpaces(String s, int[] spaces) {
        int sLen = s.length();
        int spLen = spaces.length;
        char[] chArr = new char[sLen + spLen];
        int spIndex = 0, nextSpace = spaces[spIndex], index = 0;
        
        for(int i=0;  i<sLen;  i++) {
            if(nextSpace!=i) chArr[index++] = s.charAt(i);
            else {
                chArr[index++] = ' ';
                nextSpace = spIndex < spLen-1? spaces[++spIndex]: -1;
                i--;
            }
        }
        
        return String.valueOf(chArr);
    }
}