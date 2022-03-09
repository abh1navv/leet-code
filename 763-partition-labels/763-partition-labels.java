class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] pos=new int[26];
        List<Integer> ans = new ArrayList<>();
        for(int i=0; i<s.length(); i++) {
            pos[s.charAt(i) - 'a'] = i;
        }
        int end = 0;
        for(int i=0; i<s.length(); i++) {
            end = pos[s.charAt(i)-'a'];
            for(int j=i+1;j<end;j++) {
                end = Math.max(pos[s.charAt(j)-'a'] ,end);
            }
            ans.add(end - i + 1);
            i = end;
        }
        
        return ans;
    }
}