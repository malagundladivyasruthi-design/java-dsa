Q1-Roman to Integer.
import java.util.*;

public class RomanToInteger {
    public static int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            int value = map.get(s.charAt(i));
            if (i < s.length() - 1 && value < map.get(s.charAt(i + 1)))
                result -= value;
            else
                result += value;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMIV"));
    }
}
output-1904
Q2-Happy Number.
import java.util.HashSet;

public class HappyNumber {

    static int squareSum(int n) {
        int sum = 0;
        while (n > 0) {
            int d = n % 10;
            sum += d * d;
            n /= 10;
        }
        return sum;
    }

    static boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();

        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = squareSum(n);
        }
        return n == 1;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }
}
Output-true
Q3-Armstrong Numbers
public class Armstrong {

    public static void main(String[] args) {
        int n = 153;
        int temp = n;
        int sum = 0;

        while (temp > 0) {
            int d = temp % 10;
            sum += d * d * d;
            temp /= 10;
        }

        if (sum == n)
            System.out.println("Armstrong Number");
        else
            System.out.println("Not Armstrong Number");
    }
}
Output-Armstrong Number
Q4-Power of Four
public class PowerOfFour {

    static boolean isPowerOfFour(int n) {
        if (n <= 0)
            return false;

        while (n % 4 == 0)
            n /= 4;

        return n == 1;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfFour(64));
    }
}
output-true
Q5-Factorial
public class Factorial {

    public static void main(String[] args) {
        int n = 5;
        int fact = 1;

        for (int i = 1; i <= n; i++)
            fact *= i;

        System.out.println(fact);
    }
}
Output-120
Q6-Excel Sheet Column Title
public class ExcelColumnTitle {

    static String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            n--;
            sb.append((char) ('A' + n % 26));
            n /= 26;
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(convertToTitle(28));
    }
}
Output-AB
Q7-Maximum Product of Three Numbers
import java.util.Arrays;

public class MaxProduct {

    static int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        return Math.max(nums[0] * nums[1] * nums[n - 1],
                        nums[n - 1] * nums[n - 2] * nums[n - 3]);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        System.out.println(maximumProduct(arr));
    }
}
Output-24
Q8-Climbing Stairs
public class ClimbingStairs {

    static int climbStairs(int n) {
        if (n <= 2)
            return n;

        int a = 1, b = 2;

        for (int i = 3; i <= n; i++) {
            int c = a + b;
            a = b;
            b = c;
        }

        return b;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(5));
    }
}
output-8
Q9-Self Dividing Numbers
public class SelfDividing {

    static boolean isSelfDividing(int n) {
        int temp = n;

        while (temp > 0) {
            int d = temp % 10;

            if (d == 0 || n % d != 0)
                return false;

            temp /= 10;
        }

        return true;
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 22; i++) {
            if (isSelfDividing(i))
                System.out.print(i + " ");
        }
    }
}
Output-1 2 3 4 5 6 7 8 9 11 12 15 22

Q10-Add Binary
public class AddBinary {

    static String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0 || carry != 0) {
            int sum = carry;

            if (i >= 0)
                sum += a.charAt(i--) - '0';

            if (j >= 0)
                sum += b.charAt(j--) - '0';

            result.append(sum % 2);
            carry = sum / 2;
        }

        return result.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addBinary("1010", "1011"));
    }
}
Output-10101
Q11-Power of Two
public class PowerOfTwo {

    static boolean isPowerOfTwo(int n) {
        if (n <= 0)
            return false;

        while (n % 2 == 0)
            n /= 2;

        return n == 1;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(16));
    }
}
Output-true
Q12-Integer to Roman
public class IntegerToRoman {

    static String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40,
                        10, 9, 5, 4, 1};

        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L",
                           "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                result.append(romans[i]);
                num -= values[i];
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        int num = 1994;
        System.out.println(intToRoman(num));
    }
}
Output-MCMXCIV

Q13-Unique Paths
public class UniquePaths {

    static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++)
            dp[i][0] = 1;

        for (int j = 0; j < n; j++)
            dp[0][j] = 1;

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7));
    }
}
Output-28
Q14-Gray Code
import java.util.*;

public class GrayCode {

    static List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < (1 << n); i++) {
            result.add(i ^ (i >> 1));
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(grayCode(2));
    }
}
Output-[0, 1, 3, 2]

Q15-Perfect Squares
public class PerfectSquares {

    static int numSquares(int n) {
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            dp[i] = i;

            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        int n = 12;
        System.out.println(numSquares(n));
    }
}
Output-3
