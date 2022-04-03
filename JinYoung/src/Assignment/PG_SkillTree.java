package Assignment;

// 프로그래머스 Lv.2 스킬트리
// https://programmers.co.kr/learn/courses/30/lessons/49993

public class PG_SkillTree {
    public static void main(String[] args) {
        String skill = "CBD";
        String[] skill_trees = {
                "BACDE",
                "CBADF",
                "AECB",
                "BDA"
        };
        Solution solution = new Solution();
        int answer = solution.solution(skill, skill_trees);
        System.out.println(answer);
    }

    static class Solution {
        public int solution(String skill, String[] skill_trees) {
            int answer = 0;    // 가능한 스킬트리 개수
            for (int i = 0; i < skill_trees.length; i++) {
                boolean isBreak = false;
                StringBuilder st = new StringBuilder(skill);

                for (int j = 0; j < skill_trees[i].length(); j++) {
                    // BACDE와 skill인 CBD 비교
                    int k = 0;
                    while (k>=skill.length()||!st.isEmpty()) {
                        if (skill_trees[i].charAt(j) == st.charAt(k)) {
                            if (k == 0)
                                st.delete(0, 1);
                            else {
                                //스킬트리 아님
                                isBreak = true;
                                break;
                            }
                        } else {
                            k++;
                        }
                    }
                    if (isBreak)
                        break;
                    else
                        answer++;
                }
            }
            return answer;
        }
    }
}
