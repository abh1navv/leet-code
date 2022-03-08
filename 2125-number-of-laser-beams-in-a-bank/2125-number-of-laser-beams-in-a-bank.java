class Solution {
    public int numberOfBeams(String[] bank) {
        int[] matrix = new int[bank.length];
        
        for(int i=0; i< bank.length; i++) {
            matrix[i] = bank[i].chars().map(c->c-48).reduce((a,b) -> a+b).getAsInt();
        }
        int prev = 0, count=0;
        for(int i=0; i<bank.length; i++) {
            if(matrix[i] == 0) continue;
            else {
                count+= prev*matrix[i];
                prev = matrix[i];
            }
        }
        
        return count;
        
    }
}