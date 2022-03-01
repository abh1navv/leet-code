class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int in_car = 0;
        int[] increase = new int[1001];
        for (int i = 0; i < trips.length; i ++) { // find out the number of the **net increase** passengers for each stop
            increase[trips[i][1]] += trips[i][0];
            increase[trips[i][2]] -= trips[i][0];
        }
        for (int i = 0; i <= 1000; i ++) { // from start to end, for each stop we calculate the number of passengers in the car.
            in_car += increase[i];
            if (in_car > capacity) return false; // once the number of passengers in the car exceeds the capacity
        }
        return true;
    }
}