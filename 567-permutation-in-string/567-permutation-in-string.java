class Solution {
    public boolean checkInclusion(String s1, String s2) {
    int len1 = s1.length(), len2 = s2.length();
    if (len1 > len2) return false;
    
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < len1; i++) {
        char ch = s1.charAt(i);
        if(map.containsKey(ch)) map.put(ch, map.get(ch)+1);
        else map.put(ch,1);
    }
    
    for (int i = 0; i < len2; i++) {
        char ch = s2.charAt(i);
        if(map.containsKey(ch)) map.put(ch, map.get(ch)-1);
        else {
            map.put(ch,-1);
        }
        
        if(i - len1 >= 0) {
            ch = s2.charAt(i-len1);
            if(map.containsKey(ch)) map.put(ch, map.get(ch)+1);
            else map.put(ch,1);
        }
        
        if (allZero(map)) return true;
    }
    
    return false;
}

    private boolean allZero(Map<Character, Integer> map) {
        for(int i: map.values()) {
            if(i!=0) return false;
        }
        return true;
    }
}