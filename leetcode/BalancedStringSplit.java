package leetcode;

public class BalancedStringSplit {
    /*
     * Balanced strings are those that have an equal quantity of 'L' and 'R'
     * characters.
     * Given a balanced string s, split it into some number of substrings such that:
     * Each substring is balanced.
     * Return the maximum number of balanced strings you can obtain.
     * 
     * Input: s = "RLRRLLRLRL"
     * Output: 4
     * Explanation: s can be split into "RL", "RRLL", "RL", "RL", each substring
     * contains same number of 'L' and 'R'.
     */
    public static int solution(String s) {
        int R = 0;
        int L = 0;
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'R') {
                R++;
            } else {
                L++;
            }

            if (R == L) {
                R = 0;
                L = 0;
                result++;
            }
        }
        return result;
    }
}
