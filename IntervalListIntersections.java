
// https://leetcode.com/problems/interval-list-intersections/submissions/

import java.util.ArrayList;

class IntervalListIntersections {
    public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        ArrayList<int[]> myArray = new ArrayList<>();

        int pointerA = 0;
        int pointerB = 0;

        while(pointerA < firstList.length && pointerB < secondList.length) {

            if (secondList[pointerB][1] > firstList[pointerA][0] && secondList[pointerB][0] < firstList[pointerA][1]) {
                myArray.add(new int[]{Math.max(secondList[pointerB][0], firstList[pointerA][0]), Math.min(firstList[pointerA][1], secondList[pointerB][1])});
            } else if (firstList[pointerA][1] > secondList[pointerB][0] && firstList[pointerA][0] < secondList[pointerB][1]) {
                myArray.add(new int[]{secondList[pointerB][1], firstList[pointerA][0]});
            } else if (firstList[pointerA][1] == secondList[pointerB][0]) {
                myArray.add(new int[]{firstList[pointerA][1], firstList[pointerA][1]});
            } else if (firstList[pointerA][0] == secondList[pointerB][1]) {
                myArray.add(new int[]{firstList[pointerA][0], firstList[pointerA][0]});
            }

            if (firstList[pointerA][1] < secondList[pointerB][1]) {
                pointerA++;
            } else if (secondList[pointerB][1] < firstList[pointerA][1]) {
                pointerB++;
            } else {
                pointerA++;
                pointerB++;
            }
        }

        int[][] result = new int[myArray.size()][2];
        for (int i = 0; i < result.length; i++) {
            result[i] = myArray.get(i);
        }
        return secondList;
    }
}

/*
        Set A[i,j]
        Set B[l,m]
        Maintain 2 pointers

        If m > i && l < j, return [l,j]
        if j > l && i < m, return [i,m]
        if j == l return [j, j]
        if i == m return [i, i]

        if any array is a subarray within a parent array, return the subarray too

       */