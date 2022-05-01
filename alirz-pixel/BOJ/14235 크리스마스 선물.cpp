#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int main() {
    int n;
    cin >> n;

    priority_queue<int, vector<int>, less<int>> present;

    for (int i = 0; i < n; i++) {
        int a;
        cin >> a;

        // 착한 아이를 만남
        if (a == 0) {
            // 선물이 없음
            if (present.empty()) {
                cout << "-1\n";
            }
            else {
                cout << present.top() << "\n";
                present.pop();
            }
        }

        else {
            // 선물 충전하기
            int charge_present;
            for (int charge = 0; charge < a; charge++) {
                cin >> charge_present;

                present.push(charge_present);
            }
        }
    }

    return 0;
}