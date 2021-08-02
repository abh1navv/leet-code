class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        String[] words = text.split(" ");
        int len = words.length;
                boolean[] notTypeable = new boolean[len];

        int blen = brokenLetters.length();
        for(int i=0;i<len;i++) {
           for(char ch: brokenLetters.toCharArray()) {
               if(notTypeable[i] == false && words[i].contains(String.valueOf(ch))) notTypeable[i] = true;
           }
        }
        
        for(boolean b:notTypeable) {
            if(b) len--;
        }
        return len;
    }
}