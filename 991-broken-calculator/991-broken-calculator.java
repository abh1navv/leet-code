class Solution {
    public int brokenCalc(int startValue, int target) {

        int count = 0;
        while(target != startValue) {
            if(target % 2 == 1) target++;
            else if(target > startValue) {
                target/=2;
            } else {
                count+=(startValue-target-1);
                target+=(startValue-target);
            }
            count++;
        }
        return count;
    }
    
}