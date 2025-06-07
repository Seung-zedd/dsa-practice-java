package src.hash_table;

import java.util.*;

/*
<문제 해석>
int형 nums 배열과 int형 target이 주어졌을 때, 더해서 target을 만족하는 2개의 숫자 인덱스를 리턴하라.
(단, 같은 원소는 다시 사용할 수 없고, 각각의 input에는 정확히 하나의 솔루션만 있다고 가정한다. 즉, 답은 반드시 존재한다)

- 제약 조건 -
2 <= nums.length <= 10^4 => O(N^2) 사용 불가!

<코드 설계>
for문으로 순회하는데:
map.put(nums[i], target - nums[i])로 다음에 매칭될 value를 저장한다.
 만약에 다음 회차에서 value가 key에 존재하면:
 return [nums[i], target - nums[i]]
 */

public class TwoSumSolution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] answer = new int[2];

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                answer[0] = map.get(complement);
                answer[1] = i;
            }
            map.put(nums[i], i);
        }
        return answer;
    }
}
