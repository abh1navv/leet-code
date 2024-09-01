class Solution {
    public int longestOnes(int[] nums, int k) {
        int flip=0;
        Queue<Integer> flipIndex=new LinkedList<Integer>();
        int maxCount=0;
        int startIndex=0;
        
        for(int i=0; i<nums.length; i++) {
            if(nums[i]!=1) {
                if(flip<k) {
                    flipIndex.offer(i);
                    flip++;
                }
                else {
                    //System.out.println(startIndex+":"+i+":"+flipIndex.peek());
                    maxCount = Math.max(maxCount, i-startIndex);
                    startIndex = k!=0? flipIndex.poll()+1: i+1;
                    flipIndex.offer(i);
                }
            }
        }
        
        maxCount = Math.max(nums.length-startIndex, maxCount);

        
        return maxCount;
    }
}