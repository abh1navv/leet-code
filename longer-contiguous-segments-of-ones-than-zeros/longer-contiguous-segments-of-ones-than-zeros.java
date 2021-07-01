

class Solution {

    public boolean checkZeroOnes(String s) {

        int len = s.length();
        int maxones =0, maxzero= 0;
        int zeroes=0, ones=0;
        for(int i=0; i<len; i++) {
            char c= s.charAt(i);
            if (c == '1')  {
              ones++;
              if (ones > maxones ) maxones = ones; 
              zeroes = 0;
            } else {
              zeroes++;
              if (zeroes > maxzero) maxzero = zeroes;
              ones= 0;
            }
        }
        return maxones > maxzero;
    }

}