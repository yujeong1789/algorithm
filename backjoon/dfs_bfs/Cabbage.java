package backjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 16180kb / 160ms
 */
public class Cabbage {
    public static int m;
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (t > 0) {
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken()); // 가로길이
            n = Integer.parseInt(st.nextToken()); // 세로길이
            int k = Integer.parseInt(st.nextToken()); // 배추 좌표

            int[][] farm = new int[n][m];
            for (int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                farm[b][a] = 1;
            }
            int result = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (solution(farm, i, j)) {
                        result += 1;
                    }
                }
            }
            System.out.println(result);
            t--;
        }
    }

    public static boolean solution(int[][] farm, int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= m) {
            return false;
        }
        if (farm[x][y] == 1) {
            farm[x][y] = 0;

            solution(farm, x - 1, y);
            solution(farm, x + 1, y);
            solution(farm, x, y + 1);
            solution(farm, x, y - 1);

            return true;
        }
        return false;
    }
}