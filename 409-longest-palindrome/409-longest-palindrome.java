class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = Arrays.stream(s.split("")).collect(Collectors.groupingBy(c -> c.charAt(0), Collectors.summingInt(c -> 1)));
        int evens = 0;
        int oddMax = 0;
        
        
        for(Map.Entry<Character, Integer> a: map.entrySet()) {
            if(a.getValue() % 2 == 0) {
                evens += a.getValue();
            } else {
                evens += a.getValue()-1;
                oddMax = 1;
            }
        }
        
        return evens+oddMax;
    }
}