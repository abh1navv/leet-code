class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
                
        int i=0;
        int j=people.length-1;
        
        int count=0, currentCount=1;

        while(i<=j) {
            if(people[j] + people[i] <= limit) {
                i++;
                j--;
                count++;
            } else {
                count++;
                j--;
            }
        }
        
        return count;
    }
}