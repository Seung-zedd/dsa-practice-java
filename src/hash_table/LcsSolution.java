package src.hash_table;

import java.util.*;

/*
<문제 해석>
int형 nums 배열이 정렬되지 않은 채로 주어졌을 때, 연속적인 원소 시퀀스의 길이를 리턴하라.(단, O(N) 내에 런타임을 구성해야 한다. -> sort 쓰지 말라는 뜻!)

- 제약 조건 -
0 <= nums.length <= 10^5 => longest_length = 0으로 초기화하라는 뜻
-10^9 <= nums[i] <= 10^9 => 최솟값을 찾으시오
<코드 설계>
시퀀스의 시작점만 처리합니다(num-1이 없는 숫자).
시작점을 찾으면, 해당 지점부터 연속된 숫자를 찾아 시퀀스 길이를 계산합니다.

 */

public class LcsSolution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int streak = 1; // longest_streak을 업데이트하기 위해 전역변수 설정

        if (nums.length == 0) {
            return 0;
        }

        for (int i : nums) {
            set.add(i);
        }

        for (Integer num : set) {
            if (!set.contains(num - 1)) {
                int curNum = num; // 시퀀스 시작점으로 설정
                int curStreak = 1; // 다른 시퀀스 검사 위해 다시 1로 설정

                while (set.contains(curNum + 1)) {
                    curStreak += 1;
                    curNum += 1;
                }
                streak = Math.max(curStreak, streak); // 시퀀스 업데이트
            }
        }
        return streak;
    }
}