package src.queue_stack;

/*
<문제 해석>
return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.
주어진 temperatures 배열은 일상 온도를 나타낸다, 이때 answer[i]는 i번째 날에서 더 따뜻해지기를 기다려야 하는 날을 의미한다. answer 배열을 리턴해라.
만약 이것이 가능한 미래의 날이 없다면, 0을 리턴해라.

- 제약 조건 -
1 <= temperatures.length <= 10^5
-> O(N^2)는 불가! 이중 for문으로 brute force 불가!

<코드 설계>
1. for문을 돌리는데
 */

import java.util.Stack;

public class DailyTemSolution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> tempStack = new Stack<>();
        Stack<Integer> dayStack = new Stack<>();
        int[] answer = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {

            while (!tempStack.isEmpty() && (tempStack.peek() < temperatures[i])) {
                tempStack.pop();
                Integer prev_day = dayStack.pop();
                answer[prev_day] = i - prev_day; // 현재 날짜 - 과거 날짜
            }

            tempStack.push(temperatures[i]);
            dayStack.push(i);
        }
        return answer;

    }
}
