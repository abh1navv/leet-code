class Solution {
    public int nextGreaterElement(int n) {
        char[] chArr = String.valueOf(n).toCharArray();
        int index = -1;
        
        for(int i=chArr.length-1; i>0 ;i--) {
            if(chArr[i] > chArr[i-1]) {
                index = i;
                break;
            }
        }
        
        if(index == -1) return index;
        
        int i=index, j=chArr.length-1;
        while(i<j) {
            char temp = chArr[i];
            chArr[i] = chArr[j];
            chArr[j] = temp;
            i++;
            j--;
        }
        
        j=index-1;
        for(i = j+1;i<chArr.length; i++) {
            if(chArr[i]>chArr[j]) {
                char temp = chArr[i];
                chArr[i] = chArr[j];
                chArr[j] = temp;
                break;
            }
        }        
        
        try {
            long number = Long.parseLong(String.valueOf(chArr));
            return number > Integer.MAX_VALUE? -1:(int) number;
        } catch (NumberFormatException e) {
            return Integer.MAX_VALUE;
        }        
    }
}