// 걸린시간 : 9분
// 링크 : https://programmers.co.kr/learn/courses/30/lessons/42885

#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

int solution(vector<int> people, int limit) {
    int answer = 0;
    
    // 오름차순으로 정렬
    sort(people.begin(), people.end(), less<int>());
    
    int left = 0;
    int right = people.size() - 1;
    while (left <= right) {
        // 가장 가벼운 사람과 가장 무거운 사람을 더했을 때, 무게제한을 넘는다면
        if (people[left] + people[right] > limit) {
            // 무거운 사람만 태움
            right--;
        }
        
        // 같이 탈 수 있다면
        else {
            // 같이 태움
            left++;
            right--;
        }
        
        answer++;
    }
    
    return answer;
}