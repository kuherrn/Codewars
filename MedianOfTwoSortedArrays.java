//https://leetcode.com/problems/median-of-two-sorted-arrays/submissions/


import java.util.Arrays;

class MedianOfTwoSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] myArray = new int[nums1.length + nums2.length];

        System.arraycopy(nums1, 0, myArray, 0, nums1.length);
        System.arraycopy(nums2, 0, myArray, nums1.length, nums2.length);
        Arrays.sort(myArray);
        
        if (myArray.length % 2 != 0) return (myArray[myArray.length/2]);
        return ((double) myArray[(myArray.length / 2) - 1] + myArray[(myArray.length / 2)]) / 2;

    }
}