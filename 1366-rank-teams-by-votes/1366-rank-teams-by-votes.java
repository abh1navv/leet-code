class Solution {
    public String rankTeams(String[] votes) {
        Vote[] arr=new Vote[26];
        
        for(int i=0; i<26;i++) {
            arr[i] = new Vote((char)(i+'A'));
        }
        int len = votes[0].length();
        Set<Character> chars = new HashSet<>();
        for(String vote: votes) {
            for(int i=0; i<len; i++) {
                arr[vote.charAt(i) - 'A'].count[i]++;
                chars.add(vote.charAt(i));
            }
        }
                
        Arrays.sort(arr);
        StringBuilder sb=new StringBuilder();
        for(Vote vote: arr) {
            if(chars.contains(vote.c)) {
                sb.append(vote.c);
            }
        }
        
        return sb.toString();
    }
    
    class Vote implements Comparable<Vote> {
        char c;
        int[] count;
        
        Vote(char c) {
            this.c = c;
            count = new int[26];
        }
        
        public int compareTo(Vote that) {
            for(int i=0;i<26; i++) {
                if(this.count[i] > that.count[i]) return -1;
                else if(this.count[i] < that.count[i]) return 1;
            }
            return 0;
        }
    }
}