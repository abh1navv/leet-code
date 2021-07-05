class Solution {
    public String decodeString(String s) {
        
        String result = convert(s);
            
        return result;
    }
    
    public String convert(String s) {
        char[] chArr = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        StringBuilder sbTemp = new StringBuilder();
        int i=0, x=0;
        while(i<chArr.length) {
            char ch = chArr[i++];
            if(ch >= '0' && ch<='9') {
                x=x*10+Integer.parseInt(String.valueOf(ch));
            } else if(ch == '[') {
                int flag = 1;
                while(i<chArr.length && flag!=0) {
                    ch = chArr[i++];
                    if(ch=='[') flag++;
                    else if(ch==']') flag--;
                    if((flag > 0 && ch ==']') || ch!=']') {
                        sbTemp.append(ch);
                    } 
                }
                String converted = convert(sbTemp.toString());

                for(int j=0;j<x;j++) {
                    sb.append(converted);
                }   
                x=0;
                sbTemp.setLength(0);
            } else if(ch <= 'z' && ch >='a') {
                sb.append(ch);
            }
        }
        return sb.toString();

    }
}