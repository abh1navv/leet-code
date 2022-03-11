import java.util.Collection;
class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        
        int count;
        
        for(char c: s.toCharArray()) {
            count = map.getOrDefault(c, 0);
            map.put(c, count+1);
        }
        
        for(char c: t.toCharArray()) {
            count = map.getOrDefault(c, 0);
            map.put(c, count-1);
        }
        
        return allZeroes(map.values());
    }
    
    public boolean allZeroes(Collection<Integer> values) {
        for(int v: values) {
            if(v != 0) return false;
        }
        
        return true;
    }
}