class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        String bigger=null;
        String smaller = null;
        int bigLen = 0;
        int smallLen = 0;
        if(len1 > len2) {
            bigLen = len1;
            smallLen = len2;
            bigger = str1;
            smaller = str2;
        } else {
            bigLen = len2;
            smallLen = len1;
            bigger = str2;
            smaller = str1;
        }
        
        for(int i=smallLen; i>0; i--) {
            if(bigLen % i == 0 && smallLen % i == 0) {
                int div1 = bigLen/i;
                int div2 = smallLen/i;
                for(int j=0; j<smallLen-i+1; j++) {
                    String subStr = smaller.substring(j, j+i);
                    //System.out.println(div+" "+subStr);
                    StringBuilder fullString1 = new StringBuilder();
                    while(div1 !=0) {
                        div1--;
                        fullString1.append(subStr);
                    }
                    
                    if(fullString1.toString().equals(bigger)) {
                        StringBuilder fullString2 = new StringBuilder();
                        while(div2 !=0) {
                            div2--;
                            fullString2.append(subStr);
                        }
                        if(fullString2.toString().equals(smaller)) {
                            return subStr;
                        }
                    }
                }
            }
        }
        
        return "";
    }
}