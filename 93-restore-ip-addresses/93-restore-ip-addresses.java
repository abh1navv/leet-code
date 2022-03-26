class Solution {

    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        int slen = s.length();
        if(slen > 15) return ans;
        
        getIpAddresses(s, 0, new ArrayList<Integer>(), ans, slen);
        return ans;
    }
    
    public void getIpAddresses(String s, int start, List<Integer> list, List<String> ans, int slen) {
        int num = 0;
        
        
        if(list.size() == 3) {
            String remaining = s.substring(start);

            if(remaining.equals("") || remaining.length()>3) return;
            
            num = Integer.parseInt(remaining);
            if(num<=255) {
                list.add(num);
                String finalStr = list.stream()
                    .map(i->String.valueOf(i))
                    .collect(Collectors.joining("."));
                
                if(slen + 3 == finalStr.length()) {
                    ans.add(finalStr);
                }
                list.remove(list.size()-1);

            } 
            return;
        } 
        
        for(int i=start+1;i<slen;i++) {
            num = Integer.parseInt(s.substring(start,i));
            if(num<=255 && (4-list.size())*3>=slen-i) {
                list.add(num);
                getIpAddresses(s, i, list, ans, slen);
                list.remove(list.size()-1);
            } else {
                return;
            }
        }
    }
}