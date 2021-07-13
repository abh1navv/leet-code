class Solution {
    public int strStr(String haystack, String needle) {
        int hayLen = haystack.length();
        int nedLen = needle.length();
        if(nedLen==0) return 0;
        if(nedLen>hayLen) return -1;
        char first = needle.charAt(0);

        for(int i=0;i<hayLen;i++) {
            char ch = haystack.charAt(i);
            if(ch == first && hayLen-i > nedLen-1) {
                int size = 1;
                for(int j=i+1;j<nedLen+i;j++) {
                    char ch2 = haystack.charAt(j);
                    if(ch2 != needle.charAt(j-i)) break;
                    else size++;
                }
                if(size==nedLen) return i;
            }
        }
        
        return -1;
    }
}