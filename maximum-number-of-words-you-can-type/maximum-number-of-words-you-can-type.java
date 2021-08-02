class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        String[] words = text.split(" ");
        int len = words.length;

        int blen = brokenLetters.length();
        
        for(int i=0;i<len;i++) {
            boolean flag = false;
            for(char ch: brokenLetters.toCharArray()) {
               if(len<=i) break;
               if(words[i].indexOf(ch) != -1) {
                   words[i] = words[--len]; 
                   flag = true;
               }
            }
            if(len<=i) break;
            if(flag) i--;
        }
        
        return len;
    }
}