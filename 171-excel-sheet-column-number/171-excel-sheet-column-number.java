class Solution {
    public int titleToNumber(String columnTitle) {
        int multiplier = 1;
        int number = 0;
        for(int i=columnTitle.length()-1; i>=0; i--) {
            number+=(multiplier*(columnTitle.charAt(i)-'A'+1));
            multiplier*=26;
        }
        return number;
    }
}