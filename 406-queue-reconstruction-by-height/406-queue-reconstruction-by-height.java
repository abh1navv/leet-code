class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (person1, person2) -> {
            if(person1[0] != person2[0]) return person1[0]-person2[0];
            else return person2[1]-person1[1];
        });
        
        int len = people.length;
        for(int i=len-1; i>=0; i--) {
            int before = people[i][1];
            if(before > 0) {
                int j=i;
                while(j<len-1 && before!=0) {
                    swap(people, j, j+1);
                    j++;
                    before--;
                }
            }
        }
            
        return people;
    }
    
    void swap(int[][] people, int first, int second) {
        int[] temp = people[first];
        people[first] = people[second];
        people[second] = temp;
    }
}