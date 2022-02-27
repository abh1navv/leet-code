class Solution {
    public String largestNumber(int[] nums) {
        List<String> list = new ArrayList<>();
        
        for(int i:nums) list.add(String.valueOf(i));
        list.sort((a,b) -> (b+a).compareTo(a+b));
        
        String ans = String.join("", list);
        int len = ans.length();
        int i=0;
        while(i<len-1 && ans.charAt(i) == '0'){i++;}
        
        return ans.substring(i);
    }
    
}