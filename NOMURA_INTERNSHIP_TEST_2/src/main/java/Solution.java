import java.util.Stack;

public class Solution {
    public String solution(int[] stack1, int[] stack2, int[] stack3) {
        // Implement your solution here
        Stack<Integer> stackStack1 = new Stack<>();
        Stack<Integer> stackStack2 = new Stack<>();
        Stack<Integer> stackStack3 = new Stack<>();
        for (int i : stack1) {
            stackStack1.push(i);
        }
        for (int i : stack2) {
            stackStack2.push(i);
        }
        for (int i : stack3) {
            stackStack3.push(i);
        }
        StringBuffer sb = new StringBuffer();
        // 存在stack为空的情况
        int maxStackNum = 0;
        while (true) {
            maxStackNum = findMax(stackStack1, stackStack2, stackStack3);
            if (maxStackNum == 0) {
                break;
            }
            switch (maxStackNum) {
                case 1:
                    sb.append("1");
                    stackStack1.pop();
                    break;
                case 2:
                    sb.append("2");
                    stackStack2.pop();
                    break;
                case 3:
                    sb.append("3");
                    stackStack3.pop();
                    break;
            }
        }
        return sb.toString();
    }

    public int findMax(Stack<Integer> stack1, Stack<Integer> stack2, Stack<Integer> stack3) {
        int[] peeks = new int[3];
        if (stack1.empty()) {
            peeks[0] = -1;
        }
        else {
            peeks[0] = stack1.peek();
        }
        if (stack2.empty()) {
            peeks[1] = -1;
        }
        else {
            peeks[1] = stack2.peek();
        }
        if (stack3.empty()) {
            peeks[2] = -1;
        }
        else {
            peeks[2] = stack3.peek();
        }

        int max = 0;
        if (peeks[0] != -1) {
            max = 1;
        }
        for (int i = 1; i < 3; ++i) {
            if (peeks[i] == -1) {
                continue;
            }
            if (max == 0) {
                max = i + 1;
                continue;
            }
            if (peeks[i] > peeks[max - 1]) {
                max = i + 1;
            }
        }
        return max;
    }
}
