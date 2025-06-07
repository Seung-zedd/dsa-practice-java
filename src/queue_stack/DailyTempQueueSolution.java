package src.queue_stack;

import java.util.Deque;
import java.util.LinkedList;

public class DailyTempQueueSolution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> tempQueue = new LinkedList<>();
        Deque<Integer> dayQueue = new LinkedList<>();
        int[] answer = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {

            while (!tempQueue.isEmpty() && tempQueue.peek() < temperatures[i]) {
                tempQueue.remove();
                Integer prev_day = dayQueue.remove();
                answer[prev_day] = i - prev_day;
            }

            tempQueue.addFirst(temperatures[i]);
            dayQueue.addFirst(i);
        }
        return answer;

    }
}
