class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int index=0;
        while(index<letters.length&&letters[index]<=target) index++;
        
        return index==letters.length?letters[0]:letters[index];
    }
}