package backjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 길이가 N인 정수 배열 A와 B가 있다. 다음과 같이 함수 S를 정의하자.
 * S = A[0] × B[0] + ... + A[N-1] × B[N-1]S의 값을 가장 작게 만들기 위해 A의 수를 재배열하자.
 * 단, B에 있는 수는 재배열하면 안 된다.
 * S의 최솟값을 출력하는 프로그램을 작성하시오.
 * 첫째 줄에 N이 주어진다.
 * 둘째 줄에는 A에 있는 N개의 수가 순서대로 주어지고, 셋째 줄에는 B에 있는 수가 순서대로 주어진다.
 * N은 50보다 작거나 같은 자연수이고, A와 B의 각 원소는 100보다 작거나 같은 음이 아닌 정수이다.
 * 
 * 14240kb / 124ms
 */
public class Treasure {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n], b = new int[n];
        int sum = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(a);
        Arrays.sort(b);

        for (int i = 1; i <= n; i++) {
            sum += a[i - 1] * b[n - i];
        }

        System.out.println(sum);
    }
}
