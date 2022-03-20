// 걸린시간 : 20분
// 링크 : https://programmers.co.kr/learn/courses/30/lessons/49993

#include <string>
#include <vector>
#include <map>

#include <iostream>
using namespace std;

int solution(string skill, vector<string> skill_trees) {
    int answer = 0;
    
    map<char, int> m;
    
    // 선행 스킬이 있는지 빠르게 O(log n) 확인하기 위함 
    for (int i = 0; i < skill.length(); i++) {
        m[skill[i]] = i + 1;
    }
    
    for (auto skill_tree : skill_trees) {
        bool is_true = true; // 가능한 스킬트리인지 확인을 위한 변수 (후처리를 위함)
        int curr = 0; // 선행 스킬의 index를 나타내는 변수
        
        for (auto now : skill_tree) {
            if (m[now] != 0) { // 지금 찍으려는 스킬이 선행 스킬에 있다면,
                if (skill[curr] == now) {  // 그리고 선행 스킬 순서대로 진행되고 있다면
                    curr++; // 다음 선행 스킬을 비교할 수 있도록 1 증가
                }
                else {
                    // 지금 찍으려는 스킬이 선행 스킬에 있지만 
                    // 선행 스킬대로 찍지는 않음
                    is_true = false; 
                    break;
                }
            }
        }
        
        if (is_true) {
            answer++;
        }
    }
    
    return answer;
}