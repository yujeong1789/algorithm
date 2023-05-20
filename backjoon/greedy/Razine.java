package backjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 게임에는 총 N개의 레벨이 있고, 각 레벨을 클리어할 때 마다 점수가 주어진다.
 * 플레이어의 점수는 레벨을 클리어하면서 얻은 점수의 합으로, 이 점수를 바탕으로 온라인 순위를 매긴다.
 * 동준이는 레벨을 난이도 순으로 배치했다.
 * 하지만, 실수로 쉬운 레벨이 어려운 레벨보다 점수를 많이 받는 경우를 만들었다.
 * 이 문제를 해결하기 위해 동준이는 특정 레벨의 점수를 감소시키려고 한다.
 * 이렇게해서 각 레벨을 클리어할 때 주는 점수가 증가하게 만들려고 한다.
 * 
 * 14112kb / 120ms
 */
public class Razine {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;
        for (int i = n - 2; i >= 0; i--) {
            int last = arr[i + 1];
            int current = arr[i];
            if (current >= last) {
                count += current - (last - 1);
                arr[i] = last - 1;
            }
        }
        System.out.println(count);
    }
}
