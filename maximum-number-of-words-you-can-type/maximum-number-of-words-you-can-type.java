class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        boolean[] broken=new boolean[26];
        
        char[] brokenArray = brokenLetters.toCharArray();
        
        for(char ch: brokenArray) {
            broken[ch-'a'] = true;
        }
        String[] words = text.split(" ");
        int len = words.length;
        int count = len;
        for(int i=0;i<len;i++) {
            boolean flag = false;
            for(char ch: words[i].toCharArray()) {
               if(broken[ch-'a']) {
                   count--;
                   break;
               }
            }
        }
        return count;
    }
}