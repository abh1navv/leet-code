class Solution {
    public String largestNumber(int[] nums) {
        
        nums = Arrays.stream(nums)
                .boxed()
                .sorted(new Comparator<Integer>(){
                        public int compare(Integer a, Integer b){
                            String str1 = String.valueOf(a);
                            String str2 = String.valueOf(b);
                            String s1 = str1 + str2;
                            String s2 = str2 + str1;
                            return s2.compareTo(s1);
                        }
                    }) 
                .mapToInt(i -> i)
                .toArray();
        
        String ans = Arrays.toString(nums).replaceAll("\\[|\\]|,|\\s", "");
        int len = ans.length();
        int i=0;
        while(i<len-1 && ans.charAt(i) == '0'){i++;}
        
        return ans.substring(i);
    }
    
}