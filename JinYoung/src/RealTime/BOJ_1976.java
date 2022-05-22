package RealTime;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 전반적인 로직
 1. 주어진 행렬에서 1인 요소가 있으면, union(a, b) 연산을 한다.
 2. 여행 계획에서 맨 처음 도시를 find 연산하여 루트 노드를 찾는다.
 3. 여행 계획 상의 2 ~ N 도시에 대하여 find 연산을 한 루트 노드와 2에서 수행한 루트 노드를 비교한다.
 3-1. 만약, 서로 루트 노드가 다를 경우 "NO"를 출력한다.
 3-2. 만약, 모든 여행 계획 상의 도시의 루트 노트가 같을 경우 "YES"를 출력한다.
 * */

public class BOJ_1976 {
    public static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int temp = Integer.parseInt(st.nextToken());

                // 연결된 부분은 합집합 연산함.
                if (temp == 1)
                    union(i, j);
            }
        }

        st = new StringTokenizer(br.readLine());
        int start = find(Integer.parseInt(st.nextToken()));
        while(st.hasMoreTokens()){
            int now = Integer.parseInt(st.nextToken());

            // 맨 처음 출발 도시와 연결되어있지 않은 도시가 있으면
            // 여행 계획이 불가능한 것임.
            if (start != find(now)) {
                bw.write("NO\n");
                bw.flush();
                bw.close();
                br.close();
                return;
            }
        }
        bw.write("YES\n");
        bw.flush();
        bw.close();
        br.close();
    }

    // x의 부모를 찾는 연산
    public static int find(int x) {
        if (x == parent[x])
            return x;
        return parent[x] = find(parent[x]);
    }

    // y의 부모를 x의 부모로 치환하는 연산 (x > y 일 경우, 반대)
    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            if (x < y)
                parent[y] = x;
             else
                parent[x] = y;
        }
    }
}
