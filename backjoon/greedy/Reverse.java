package backjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 다솜이는 0과 1로만 이루어진 문자열 S를 가지고 있다.
 * 다솜이는 이 문자열 S에 있는 모든 숫자를 전부 같게 만들려고 한다.
 * 다솜이가 할 수 있는 행동은 S에서 연속된 하나 이상의 숫자를 잡고 모두 뒤집는 것이다.
 * 뒤집는 것은 1을 0으로, 0을 1로 바꾸는 것을 의미한다.
 * 문자열 S가 주어졌을 때, 다솜이가 해야하는 행동의 최소 횟수를 출력하시오.
 * 
 * 14212kb / 120ms
 */
public class Reverse {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] c = br.readLine().toCharArray();
        char prev = c[0];
        int zero = 0, one = 0;
        for (int i = 1; i < c.length; i++) {
            char current = c[i];
            if (prev != current) {
                if (current == '0') {
                    one++;
                } else {
                    zero++;
                }
            }
            prev = current;
        }
        System.out.println(zero > one ? zero : one);
    }
}
