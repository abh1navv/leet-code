class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> romToInt = new HashMap<>();
        romToInt.put('I',1);
        romToInt.put('V',5);
        romToInt.put('X',10);
        romToInt.put('L',50);
        romToInt.put('C',100);
        romToInt.put('D',500);
        romToInt.put('M',1000);
        
        int num = 0, i=0;
        int len = s.length();
        for(i=0;i<len-1;i++) {
            char ch = s.charAt(i);
            char ch2 = s.charAt(i+1);
            if(romToInt.get(ch) < romToInt.get(ch2)) {
                num-=romToInt.get(ch);
            } else {
                num+=romToInt.get(ch);
            }                
        }
        num+=romToInt.get(s.charAt(i));
        return num;
    }
}