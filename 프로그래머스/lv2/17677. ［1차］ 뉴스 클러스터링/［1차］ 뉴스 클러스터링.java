import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        
        List<String> str1Group = new ArrayList<>();
        List<String> str2Group = new ArrayList<>();
        
        char[] str1CharArray = str1.toCharArray();
        char[] str2CharArray = str2.toCharArray();
        
        String tmp = "";
        for (int i = 0; i < str1CharArray.length; i++) {
            if (Character.isAlphabetic(str1CharArray[i])) {
                tmp += str1CharArray[i] + "";
                if (tmp.length() == 2) {
                    str1Group.add(tmp.toLowerCase());
                    tmp = str1CharArray[i] + "";
                }
            } else {
                tmp = "";
            }
        }
        tmp = "";
        for (int i = 0; i < str2CharArray.length; i++) {
            if (Character.isAlphabetic(str2CharArray[i])) {
                tmp += str2CharArray[i] + "";
                if (tmp.length() == 2) {
                    str2Group.add(tmp.toLowerCase());
                    tmp = str2CharArray[i] + "";
                }
            } else {
                tmp = "";
            }
        }
        
        int gyo = 0;
        int hap = 0;
        int[] str1Check = new int[str1Group.size()];
        int[] str2Check = new int[str2Group.size()];
        
        if (str1Group.size() <= str2Group.size()) {
            for (int i = 0; i < str1Group.size(); i++) {
                for (int k = 0; k < str2Group.size(); k++) {
                    if (str2Check[k] == 0 && str1Group.get(i).equals(str2Group.get(k))) {
                        gyo++;
                        str2Check[k] = 1;
                        break;
                    }
                }
            }
        } else {
            for (int i = 0; i < str2Group.size(); i++) {
                for (int k = 0; k < str1Group.size(); k++) {
                    if (str1Check[k] == 0 && str2Group.get(i).equals(str1Group.get(k))) {
                        gyo++;
                        str1Check[k] = 1;
                        break;
                    }
                }
            }
        }
        
        hap = str1Group.size() + str2Group.size() - gyo;
        if (hap == 0) {
            gyo = 1;
            hap = 1;
        }
        answer = (gyo * 65536) / hap;
        
        return answer;
    }
}