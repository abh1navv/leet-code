class Solution {
    public String largestNumber(int[] nums) {
        List<String> list = new ArrayList<>();
        
        for(int i:nums) list.add(String.valueOf(i));
        list.sort(new Comparator<String>(){
                        public int compare(String a, String b){
                            String s1 = a + b;
                            String s2 = b + a;
                            return s2.compareTo(s1);
                        }
                    });
        
        String ans = String.join("", list);
        int len = ans.length();
        int i=0;
        while(i<len-1 && ans.charAt(i) == '0'){i++;}
        
        return ans.substring(i);
    }
    
}