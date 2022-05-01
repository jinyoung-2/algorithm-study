#include <algorithm>
#include <string>
#include <vector>

using namespace std;

int solution(vector<vector<int>> triangle) {
    // row(height) = 500
    // 삼각형을 이루는 숫자 = 9999;
    // 500 * 9999 => 오버플로우를 걱정하지 않아도 됨

    // 이 문제의 경우, 삼각형을 이루는 숫자는 음수가 나올 수 없으므로
    // 위에서부터 아래로 인접한 값을 더해나가면 무조건 최댓값을 찾을 수 있다. (그리디?)
    for (int row = 1; row < triangle.size(); row++) { // 위에서부터 아래로 
        for (int col = 0; col < triangle[row].size(); col++) {
            int now_value = triangle[row][col];
            
            if (col == 0) {
                triangle[row][col] = triangle[row - 1][col];
            }
            else if (col == triangle[row].size() - 1) {
                triangle[row][col] = triangle[row - 1][col - 1];
            }
            else {
                triangle[row][col] = max(triangle[row - 1][col - 1], triangle[row][col] = triangle[row - 1][col]);
            }
            
            triangle[row][col] += now_value; 
        }
    }
    
    int last_row_max = 0;
    for (auto last_row : triangle[triangle.size() - 1]) {
        last_row_max = max(last_row_max, last_row);
    }
    
    return last_row_max;
}