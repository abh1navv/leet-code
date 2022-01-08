public class Solution {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int m = A.length;
        int n = B.length;
        int i=0,j=0;
        int[][] result = new int[m + n][2];

        int index = 0;
        while(i<m && j<n) {
            result[index][0] = Math.max(A[i][0], B[j][0]);
            result[index][1] = Math.min(A[i][1], B[j][1]);
            if(result[index][1] == A[i][1]) i++; 
            if(result[index][1] == B[j][1]) j++;
            
            if(result[index][0] <= result[index][1]){
                index++;
            }
        } 
        return Arrays.copyOfRange(result, 0, index);

    }
}