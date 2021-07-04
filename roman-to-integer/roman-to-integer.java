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
        
        int num = 0;
        int len = s.length();
        for(int i=0;i<len;i++) {
            char ch = s.charAt(i);
            if(ch == 'I' && i<len-1 && (s.charAt(i+1) == 'V' || s.charAt(i+1) == 'X')) {
                num+=romToInt.get(s.charAt(i+1)) - romToInt.get(ch); i++;
            } else if(ch == 'X' && i<len-1 && (s.charAt(i+1) == 'L' || s.charAt(i+1) == 'C')) {
                num+=romToInt.get(s.charAt(i+1)) - romToInt.get(ch);       i++;         
            } else if(ch == 'C' && i<len-1 && (s.charAt(i+1) == 'D' || s.charAt(i+1) == 'M')) {
                num+=romToInt.get(s.charAt(i+1)) - romToInt.get(ch);      i++;          
            } else {
                num+=romToInt.get(ch);
            }
        }
        return num;
    }
}