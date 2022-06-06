class Solution {
    public String maxValue(String n, int x) {
        StringBuilder sb=new StringBuilder(); 
        boolean negative = n.charAt(0) == '-'; 
        for(int i=0; i<n.length(); i++) {
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
        if(sb.length() == n.length())                 
            sb.append(String.valueOf(x));

        return sb.toString();
    }
}