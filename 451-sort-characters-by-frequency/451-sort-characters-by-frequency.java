class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        
        int count = 0;
        for(int i=0; i<s.length();i++) {
            count = map.getOrDefault(s.charAt(i), 0);
            map.put(s.charAt(i), count+1);
        }
        
        PriorityQueue<Char> pq = new PriorityQueue<>((a,b) -> b.freq - a.freq);
        
        for(Map.Entry<Character, Integer> entry: map.entrySet()) {
            pq.offer(new Char(entry.getKey(), entry.getValue()));
        }
        StringBuilder ans = new StringBuilder();
        while(!pq.isEmpty()) {
            Char ch = pq.poll();
            while(ch.freq!=0) {
                ans.append(ch.c);
                ch.freq--;
            }
        }
        
        return ans.toString();
    }
    
    class Char {
        char c;
        int freq;
        Char(char c, int freq) {
            this.c = c;
            this.freq = freq;
        }
    }
}