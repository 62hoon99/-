import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        
        List<String> skills = List.of(skill.split(""));
        
        for (String skill_tree : skill_trees) {
            List<String> list = List.of(skill_tree.split(""));
            int idx = 0;
            for (String l : list) {
                if (skills.contains(l) && !skills.get(idx++).equals(l)) {
                    answer++;
                    break;
                }
            }
        }
        
        return skill_trees.length - answer;
    }
}