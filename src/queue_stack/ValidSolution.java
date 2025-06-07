package src.queue_stack;

/*
string이 valid이려면:
1. 열린 괄호는 같은 타입의 괄호에 의해 닫혀 있어야 한다.
2. 열린 괄호들은 올바른 순서로 닫혀야 한다.
3. 모든 닫힌 괄호는 일치하는 같은 타입의 열린 괄호가 있다.


- 제약 조건 -
1 <= s.length <= 10^4 => O(N^2)는 안된다, 즉 이중 for문은 사용 x

<코드 설계>
if 열린 괄호: stack.push()
else 닫힌 괄호: stack.peek()로 top 원소를 확인한 후, 매칭되는 열린 괄호가 있으면 stack.pop()
=> 만약에 닫힌 괄호만 주어지면, 위의 if문을 거치지 않기 때문에 바로 false를 리턴
for문이 끝나면 return stack.isEmpty()로 boolean값 리턴
 */

import java.util.Stack;

public class ValidSolution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (stack.isEmpty()) {
                return false; // 열린 괄호가 스택에 없으면 false
            } else if ((c == ')' && stack.peek() == '(') || (c == '}' && stack.peek() == '{') || (c == ']' && stack.peek() == '[')) {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();

    }

}
