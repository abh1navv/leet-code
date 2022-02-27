class Solution {
    public String largestNumber(int[] nums) {
        
        List<String> arr = new ArrayList<>();

        for(int i=0;i<nums.length;i++) {
            arr.add(String.valueOf(nums[i]));
        }
        Collections.sort(arr, new Comparator<String> (){
            public int compare(String str1, String str2){
                String s1 = str1 + str2;
                String s2 = str2 + str1;
                return s2.compareTo(s1);
            }
        });
        int i=0;
        while(true && arr.size()>1) {
            if("0".equals(arr.get(i))) arr.remove(i);
            else break;
        }
        
        return String.join("", arr);
    }
    
}