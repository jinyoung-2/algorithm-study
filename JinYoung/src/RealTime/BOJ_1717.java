package RealTime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1717 {
    public static int[] parent;
    public static int[] rank;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        rank = new int[n + 1];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int command = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (command == 0) {
                // Union 연산
                union(a, b);
            } else if (command == 1) {
                sb.append((isSameParent(a, b) ? "YES" : "NO") + "\n");
            }
        }
        System.out.println(sb);
        br.close();
    }

    // x가 속한 그래프의 루트 노드를 반환
    public static int find(int x) {
        // x의 루트노드가 x일 경우. 즉, x와 연결된 노드가 없을 경우.
        if (x == parent[x]) return x;
        // 재귀를 이용해 최상위노드를 찾는 과정에서 경로 최적화를 실시
        return parent[x] = find(parent[x]);
    }

    // x와 y의 부모가 같은지, 즉 x와 y의 root node가 동일한지 확인
    public static boolean isSameParent(int x, int y) {
        x = find(x);
        y = find(y);

//        if (x == y)
//            return true;
//        return false;
        return x == y;
    }

    // Union 연산: 두 집합을 공통의 부모를 갖는 구조로 합치는 연산
    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

//        if(x!=y){
//            if (x < y) {
//                parent[y] = x;
//            } else {
//                parent[x] = y;
//            }
//        }
        if (x == y) return;
        if (rank[x] < rank[y])
            parent[x] = y;
        else {
            // 같을 경우 아무거나 붙여주고 rank( 노드의 깊이를 하나 추가 한다 )
            if (rank[x] == rank[y])
                rank[x]++;
            parent[y] = x;
        }
    }
}