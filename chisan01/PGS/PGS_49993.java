package PGS;

// [프로그래머스] Lv.2 스킬트리

import java.util.*;

class Solution {
    private boolean checkSkillTree(String skillOrders, boolean[] isOrderedSkill, String skillTree) {
        int skillOrderCheckIndex = 0;
        for (int i = 0; i < skillTree.length(); i++) {
            char curSkill = skillTree.charAt(i);
            if(isOrderedSkill[curSkill - 'A']) {
                if(curSkill != skillOrders.charAt(skillOrderCheckIndex)) return false;
                skillOrderCheckIndex++;
            }
        }
        return true;
    }

    public int solution(String skillOrders, String[] skill_trees) {
        int answer = 0;
        // 선행 스킬에 포함되어 있는 스킬 구분
        boolean[] isOrderedSkill = new boolean[26];
        Arrays.fill(isOrderedSkill, false);
        for (int i = 0; i < skillOrders.length(); i++) {
            isOrderedSkill[skillOrders.charAt(i) - 'A'] = true;
        }

        for (String skill_tree : skill_trees) {
            if(checkSkillTree(skillOrders, isOrderedSkill, skill_tree)) {
                answer++;
            }
        }
        return answer;
    }
}

public class PGS_49993 {
    public static void main(String[] args) {
        Solution s = new Solution();
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
        System.out.println(s.solution("CBD", skill_trees));
    }
}
