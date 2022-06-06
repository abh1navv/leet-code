class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> indexFirst = new HashMap<>();
        for(int i=0;i<list1.length; i++) {
            indexFirst.put(list1[i], i);
        }
        
        List<String> ans = new ArrayList<>();
        
        int leastSum = Integer.MAX_VALUE;
        for(int i=0;i<list2.length; i++) {
            if(indexFirst.containsKey(list2[i])) {
                int curr = indexFirst.get(list2[i])+i;
                if(curr==leastSum) {
                    ans.add(list2[i]);
                } else if(curr < leastSum) {
                    ans.clear();
                    leastSum = curr;
                    ans.add(list2[i]);
                }
            }
        }
        return ans.toArray(new String[ans.size()]);
    }
}