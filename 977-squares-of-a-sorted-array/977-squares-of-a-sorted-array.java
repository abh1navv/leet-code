class Solution {
    public int[] sortedSquares(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        
        //check for invalid cases as per question
        if (n == 0) {
            return result;
        }
        
        int i = 0;
        int j = n - 1;
        int index = n - 1;
        
        while (i <= j) {
            if (Math.abs(arr[i]) > Math.abs(arr[j])) {
                result[index] = arr[i] * arr[i];
                i++;
            } else {
                result[index] = arr[j] * arr[j];
                j--;
            }
            index--;
        }
        return result;
    }
}