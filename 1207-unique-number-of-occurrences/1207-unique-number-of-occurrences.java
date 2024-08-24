class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num: arr) {
            map.put(num, map.getOrDefault(num,0) + 1);
        }
                
        return map.values().stream().collect(Collectors.toSet()).size() == map.size();
    }
}