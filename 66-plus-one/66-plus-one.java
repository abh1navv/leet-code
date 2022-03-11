class Solution {
    public int[] plusOne(int[] digits) {
        
        if(digits[digits.length-1] <=8) {
            digits[digits.length-1]++;
            return digits;
        }
        digits[digits.length-1] = 0;
        
        int rem = 1;
        for(int i=digits.length-2; i>=0; i--) {
            if(rem == 0) return digits;
            digits[i] = digits[i] + rem;
            rem = digits[i]/10;
            digits[i] = digits[i]%10;
        }
        
        if(rem == 0) return digits;

        
        int[] ans = new int[digits.length+1];
        ans[0] = rem;
        System.arraycopy(digits, 0, ans, 1, digits.length);
        
        return ans;
    }
}