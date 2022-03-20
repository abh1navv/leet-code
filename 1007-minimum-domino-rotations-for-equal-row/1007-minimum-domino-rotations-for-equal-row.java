class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int[][] freq = new int[2][7];
        int maxTop=0, maxBot = 0;
        int topVal = 0, botVal=0;
        for(int i=0; i<tops.length; i++) {
            freq[0][tops[i]]++;
            if(freq[0][tops[i]]>topVal) {
                topVal = freq[0][tops[i]];
                maxTop = tops[i];
            }
            freq[1][bottoms[i]]++;
            if(freq[1][bottoms[i]]>botVal) {
                maxBot = bottoms[i];
                botVal = freq[1][bottoms[i]];
            }
        }
        
        if(topVal > botVal) {
            return countFrom(tops, maxTop, bottoms);
        } else {
            return countFrom(bottoms, maxBot, tops);
        } 
        

    }
    
    int countFrom(int[] tops, int maxTop, int[] bottoms) {
        int countTop = 0;
        boolean found=true;
        for(int i=0; i<tops.length; i++) {
            if(maxTop != tops[i]) {
                if(maxTop == bottoms[i]) {
                    countTop++;
                } else {
                    found = false;
                    break;
                }
            }
        }
        
        return found?countTop:-1;
    }
}