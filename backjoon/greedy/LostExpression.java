package backjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 세준이는 양수와 +, -, 그리고 괄호를 가지고 식을 만들고 괄호를 모두 지웠다.
 * 그리고 나서 세준이는 괄호를 적절히 쳐서 이 식의 값을 최소로 만들려고 한다.
 * 괄호를 적절히 쳐서 이 식의 값을 최소로 만드는 프로그램을 작성하시오.
 * 
 * 첫째 줄에 식이 주어진다. 식은 ‘0’~‘9’, ‘+’, 그리고 ‘-’만으로 이루어져 있고, 가장 처음과 마지막 문자는 숫자이다.
 * 그리고 연속해서 두 개 이상의 연산자가 나타나지 않고, 5자리보다 많이 연속되는 숫자는 없다.
 * 수는 0으로 시작할 수 있다. 입력으로 주어지는 식의 길이는 50보다 작거나 같다.
 * 
 * 14168kb / 132ms
 */
public class LostExpression {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // -를 기준으로 split하면 덧셈에 괄호를 친 것과 같아짐
        String[] expression = br.readLine().split("\\-");
        int sum = 0;

        for (int i = 0; i < expression.length; i++) {
            int temp = 0;

            // 다시 +를 기준으로 split해 덧셈 연산
            for (String str : expression[i].split("\\+")) {
                temp += Integer.parseInt(str);
            }

            // 첫번째 값을 sum에 할당
            if (i == 0) {
                sum = temp;
            } else { // 이후 sum에서 덧셈 연산 결과를 뺀다
                sum -= temp;
            }
        }
        System.out.println(sum);
    }
}