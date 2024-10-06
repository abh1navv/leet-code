class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> sortAndGroup = new HashMap<>();
        
        for(String str: strs) {
           char[] ca = new char[26];
            for(char c : str.toCharArray()){
                ca[c - 'a'] += 1;
            }
            String sorted = new String(ca);
            List<String> prev = sortAndGroup.getOrDefault(sorted, new ArrayList<>());
            prev.add(str);
            sortAndGroup.put(sorted, prev);
            
        }
        
        return new ArrayList<>(sortAndGroup.values());
    }
        
}