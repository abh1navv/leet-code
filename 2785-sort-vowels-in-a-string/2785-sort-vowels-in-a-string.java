class Solution {
    public String sortVowels(String s) {
        char[] vowels = "AEIOUaeiou".toCharArray();
        Map<Character, Integer> freq = new HashMap<>();
        
        char[] str = s.toCharArray();
        for(char c: str) {
            if(isVowel(c)) {
                freq.put(c, freq.getOrDefault(c, 0) + 1);
            }
        }
        
        int currVowel = 0;
        
        for(int i=0; i<str.length; i++) {
            char c = str[i];
            if(isVowel(c)) {
                while(!freq.containsKey(vowels[currVowel]) || freq.get(vowels[currVowel]) <= 0) currVowel++;
                freq.put(vowels[currVowel], freq.get(vowels[currVowel])-1);
                str[i] = vowels[currVowel];    
            }
            
        }
            
        
        return String.valueOf(str);
            
    }
    
    
    boolean isVowel(char c) {
        return c=='a' || c=='e' || c=='i' || c=='o' || c=='u' || c=='A' || c=='E' || c=='I' || c=='O' || c=='U';
    }
}