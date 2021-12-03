//https://leetcode.com/problems/maximum-product-subarray/submissions/

import java.util.Arrays;

public class MaximumProductSubarray {
    public static int maxProduct(int[] nums) {
        if (nums.length == 1)
            return nums[0];
        else if (nums.length == 0) return 0;

        int answer = 1;
        int[] arrCopy = new int[nums.length];
        int numNegative = 0;
        int numPositive = 0;


        for (int i = 0; i < nums.length; i++) {
            arrCopy[i] = nums[i];
        }

        Arrays.sort(arrCopy);

        for (int i = 0; i < arrCopy.length; i++) {
            if (arrCopy[i] < 0)
                numNegative++;
            else if (nums[i] > 0)
                numPositive++;
        }

        if (numNegative % 2 != 0) {
            if (numPositive == 0) {
                for (int i = 0; i < arrCopy.length - 1; i++) {
                    answer *= arrCopy[i];
                }
            } else {
                int leftHalf = 1; int rightHalf = 1;
                for (int i = 0; i < nums.length; i++) {
                    if (nums[i] == arrCopy[0]) break;
                    leftHalf *= nums[i];
                }
                for (int j = nums.length - 1; j >= 0; j--) {
                    if (nums[j] == arrCopy[0]) break;
                    rightHalf *= nums[j];
                }
                answer = Math.max(leftHalf, rightHalf);
            }
        } else {
            for (int i : nums) {
                answer *= i;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{-1, -2, -3}));
    }
}

/*
    // LeetCode solution from @Chaitanya1706 (https://leetcode.com/problems/maximum-product-subarray/discuss/1608862/JAVA-or-3-Solutions-or-Detailed-Explanation-Using-Image)
       
    public int maxProduct(int[] nums) {
        
        int max = nums[0], min = nums[0], ans = nums[0];
        int n = nums.length;
        
        for (int i = 1; i < n; i++) {
        
			// Swapping min and max
            if (nums[i] < 0){
                int temp = max;
                max = min;
                min = temp;
            }
                
            max = Math.max(nums[i], max * nums[i]);
            min = Math.min(nums[i], min * nums[i]);

            ans = Math.max(ans, max);
        }
       
        return ans;
    }

*/
