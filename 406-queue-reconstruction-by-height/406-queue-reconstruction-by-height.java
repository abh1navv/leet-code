class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (person1, person2) -> {
            if(person1[0] != person2[0]) return person2[0]-person1[0];
            else return person1[1]-person2[1];
        });
        
        List<int[]> list = new LinkedList<>();
        
        for(int[] person: people) {
            list.add(person[1], person);
        }
            
        return list.toArray(new int[people.length][2]);
    }
    
}