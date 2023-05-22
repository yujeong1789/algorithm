package backjoon.dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 16040kb / 172ms
 */
public class Paper {
    public static int white = 0;
    public static int blue = 0;
    public static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        solution(0, 0, n);
        System.out.printf("%d\n%d", white, blue);

    }

    public static void solution(int x, int y, int size) {
        if (getColor(x, y, size)) {
            if (arr[x][y] == 0)
                white++;
            else
                blue++;
            return;
        }
        size /= 2;
        solution(x, y, size); // [0][0]
        solution(x, y + size, size); // [0][size-1]
        solution(x + size, y, size); // [size-1][0]
        solution(x + size, y + size, size); // [size-1][size-1]
    }

    public static boolean getColor(int x, int y, int size) {
        int current = arr[x][y];

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[i][j] != current) {
                    return false;
                }
            }
        }
        return true;
    }
}
