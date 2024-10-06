class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> sortAndGroup = new HashMap<>();
        
        for(String str: strs) {
            String sorted = getCountString(str);
            List<String> prev = sortAndGroup.getOrDefault(sorted, new ArrayList<>());
            prev.add(str);
            sortAndGroup.put(sorted, prev);
            
        }
        
        return sortAndGroup.values().stream().toList();
    }
    
    String getCountString(String str) {
        int[] counts = new int[26];
        for(char ch: str.toCharArray()) {
            counts[ch-'a']++;
        }
        
        return Arrays.toString(counts);
    }
        
}