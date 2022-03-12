class Solution {
    public int[] dailyTemperatures(int[] temps) {
        Stack<Temp> pq = new Stack<>();
        pq.push(new Temp(temps[temps.length-1], temps.length-1));
        
        int[] ans = new int[temps.length];
        for(int i=temps.length-2; i>=0; i--) {
            while(!pq.isEmpty() && pq.peek().value <= temps[i]) {
                pq.pop();
            }
            ans[i] = !pq.isEmpty() ? pq.peek().pos-i: 0;

            pq.push(new Temp(temps[i], i));
        }
        
        return ans;
    }
    
    class Temp {
        int value;
        int pos;
        
        Temp(int value, int pos) {
            this.value = value;
            this.pos = pos;
        }
    }
}