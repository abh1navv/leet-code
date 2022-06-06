class Solution {
    public String maxValue(String n, int x) {
        int len = n.length();
        StringBuilder sb=new StringBuilder(); 
        boolean negative = n.charAt(0) == '-'; 
        for(int i=0; i<len; i++) {
            char c = n.charAt(i);
            if(c-'0' > x && negative) {
                sb.append(x);
                sb.append(n.substring(i));
                break;
            } else if(c-'0' < x && !negative) {
                sb.append(String.valueOf(x));
                sb.append(n.substring(i));
                break;
            } else {
                sb.append(c);
            }
        }
        if(sb.length() == len)                 
            sb.append(String.valueOf(x));

        return sb.toString();
    }
}