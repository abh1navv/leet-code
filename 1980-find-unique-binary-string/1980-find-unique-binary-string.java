class Solution {
    public String findDifferentBinaryString(String[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        
        String prev = nums[0];
        if(prev.contains("1")) return zeroString(n);
        
        for(int i=1; i<n; i++) {
            String curr = nums[i];
            String prevPlusOne = prevPlusOne(prev);
            if(!curr.equalsIgnoreCase(prevPlusOne)) return prevPlusOne;
            prev = curr;
        }
        
        return prevPlusOne(nums[n-1]);
    }
    
    String zeroString(int n) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n;i++) {
            sb.append("0");
        }
        
        return sb.toString();
    }
    
    String prevPlusOne(String prev) {
        char[] prevArr = prev.toCharArray();
        int rem = 1;
        int n = prevArr.length-1;
        while(rem > 0) {
            int sum = (prevArr[n]-'0') + rem;
            rem = sum/2;
            prevArr[n--] = (char)('0'+sum%2);
        }
        
        return String.valueOf(prevArr);
    }
}