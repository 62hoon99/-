import java.util.*;

class Solution {
    public int solution(String s) {
        
        StringBuilder code = new StringBuilder();
        char[] chars = s.toCharArray();
        int start = 0;
        int end = 0;
        for(int i=0; i<chars.length; i++) {
            if(Character.isDigit(chars[i])) {
                code.append(chars[i]);
            } else {
                for(int k=i; k<=chars.length; k++) {
                    String number_alp = s.substring(i, k);
                    if(number_alp.equals("zero")){code.append("0"); i=k-1; break;}
                    else if(number_alp.equals("one")){code.append("1");i=k-1; break;}
                    else if(number_alp.equals("two")){code.append("2");i=k-1; break;}
                    else if(number_alp.equals("three")){code.append("3");i=k-1; break;}
                    else if(number_alp.equals("four")){code.append("4");i=k-1; break;}
                    else if(number_alp.equals("five")){code.append("5");i=k-1; break;}
                    else if(number_alp.equals("six")){code.append("6");i=k-1; break;}
                    else if(number_alp.equals("seven")){code.append("7");i=k-1; break;}
                    else if(number_alp.equals("eight")){code.append("8");i=k-1; break;}
                    else if(number_alp.equals("nine")){code.append("9");i=k-1; break;}
                }
            }
        }
        return Integer.parseInt(code.toString());
    }
}