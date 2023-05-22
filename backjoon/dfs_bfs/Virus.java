package backjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * 14196kb / 128ms
 */
public class Virus {
    public static ArrayList<ArrayList<Integer>> computers = new ArrayList<>();
    public static boolean[] visits;
    public static int result = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int line = Integer.parseInt(br.readLine());
        visits = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            computers.add(new ArrayList<>());
        }
        StringTokenizer st;
        for (int i = 0; i < line; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            computers.get(a).add(b);
            computers.get(b).add(a);
        }

        solution(1);
        System.out.print(result);
    }

    public static void solution(int x) {
        result += 1;
        visits[x] = true;
        for (int i = 0; i < computers.get(x).size(); i++) {
            int y = computers.get(x).get(i);
            if (!visits[y]) {
                solution(y);
            }
        }
    }
}
