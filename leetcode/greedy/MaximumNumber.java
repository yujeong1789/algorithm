package leetcode.greedy;

public class MaximumNumber {
    public static int solution(int num) {
        String temp = String.valueOf(num);
        if (temp.contains("6")) {
            temp = temp.replaceFirst("6", "9");
            num = Integer.parseInt(temp);
        }
        return num;
    }
}
