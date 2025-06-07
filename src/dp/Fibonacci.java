package src.dp;

import java.util.*;

public class Fibonacci {
    public int fib(int n) {
        HashMap<Integer, Integer> memo = new HashMap<>();
        int[] table = new int[n + 1]; // 배열은 0부터 시작하므로 1을 더해줘야함
        return bottomUp(n, table);
    }

    private static int bottomUp(int n, int[] table) {
        // base condition
        table[0] = 0;
        table[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            table[i] = table[i - 1] + table[i - 2];
        }

        return table[n];
    }

    private static int topdown(int n, HashMap<Integer, Integer> memo) {
        // base condition
        // 0, 1, 1, 2, 3, 5, 8, 13, 21, ...
        if (n <= 1) {
            return n;
        }
        // n이 메모리에 없으면 재귀 함수를 호출
        if (!memo.containsKey(n)) {
            memo.put(n, topdown(n - 1, memo) + topdown(n - 2, memo));
        }
        // n이 메모리에 있으면 메모리에 있는 value를 리턴
        return memo.get(n);
    }

    public static void main(String[] args) {
        // 0, 1, 1, 2, 3, 5, 8, 13, 21, ...
        Fibonacci f = new Fibonacci();
        System.out.println(f.fib(5));
    }

}
