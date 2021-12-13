// https://leetcode.com/problems/largest-rectangle-in-histogram/submissions/
// Explanation video: https://www.youtube.com/watch?v=vcv3REtIvEo&ab_channel=TECHDOSE

import java.util.Stack;

public class ConsecutiveCharacters {
    public static int largestRectangleArea(int[] heights) {
//        (Left - Right + 1) * Height
        int max = 0;
        Stack<Integer> myStack = new Stack<>();
        int[] leftLimit = new int[heights.length];
        int[] rightLimit = new int[heights.length];

        for (int i = 0; i < heights.length; i++) {
            if (myStack.isEmpty()) {
                leftLimit[i] = 0;
            } else {
                while (!myStack.isEmpty() && heights[myStack.peek()] >= heights[i])
                    myStack.pop();
                leftLimit[i] = myStack.isEmpty() ? 0 : myStack.peek() + 1;
            }
            myStack.push(i);
        }

        while (!myStack.isEmpty()) myStack.pop();

        for (int i = heights.length - 1; i >=0; i--) {
            if (myStack.empty()) {
                rightLimit[i] = i;
                myStack.push(i);
            } else {
                while(!myStack.isEmpty() && heights[myStack.peek()] >= heights[i])
                    myStack.pop();
                rightLimit[i] = myStack.isEmpty() ? heights.length - 1 : myStack.peek() - 1;
                System.out.println(rightLimit[i]);
                myStack.push(i);
            }
        }

        for (int i = 0; i < heights.length; i++) {
            max = Math.max(max, heights[i] * (rightLimit[i] - leftLimit[i] + 1));
        }

        return max;
    }

    public static void main(String[] args) {
        largestRectangleArea(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
    }
}

// If less than top, set left bound to equal the top and pop the stack