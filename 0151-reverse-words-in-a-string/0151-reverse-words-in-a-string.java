class Solution {
    public String reverseWords(String s) {
        
        StringBuilder ans=new StringBuilder();

        int end=s.length(); 
        for(int i=s.length()-1;i>=0;i--) {
            char ch = s.charAt(i);
            if(ch==' ' && i<end-1){
                ans.append(s.substring(i+1,end)).append(" ");
                while(i>0 && s.charAt(i-1)==' ') i--;
                end=i;
            }
        }
        
        ans.append(s.substring(0,end));
        
        return ans.toString().trim();
    }
}