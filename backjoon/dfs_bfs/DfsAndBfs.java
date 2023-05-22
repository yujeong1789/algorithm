package backjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 19712kb / 248ms
 */
public class DfsAndBfs {
    public static boolean[] visited;
    public static ArrayList<ArrayList<Integer>> arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());

        visited = new boolean[n + 1];
        arr = new ArrayList<>(n + 1);
        for (int i = 0; i <= n; i++) {
            arr.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr.get(a).add(b);
            arr.get(b).add(a);
        }

        StringBuilder sb = new StringBuilder();
        dfs(v, sb);
        sb.append("\n");
        visited = new boolean[n + 1];
        bfs(v, sb);
        System.out.print(sb);
    }

    public static void dfs(int v, StringBuilder sb) {
        visited[v] = true;
        sb.append(v).append(" ");
        Collections.sort(arr.get(v)); // 번호가 작은 노드를 먼저 방문하기 위해 정렬
        for (int i = 0; i < arr.get(v).size(); i++) {
            int node = arr.get(v).get(i);
            if (!visited[node]) {
                dfs(node, sb);
            }
        }
    }

    public static void bfs(int v, StringBuilder sb) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(v);
        visited[v] = true;
        while (!q.isEmpty()) {
            int x = q.poll();
            sb.append(x).append(" ");
            Collections.sort(arr.get(x));
            for (int i = 0; i < arr.get(x).size(); i++) {
                int y = arr.get(x).get(i);
                if (!visited[y]) {
                    q.offer(y);
                    visited[y] = true;
                }
            }
        }
    }
}