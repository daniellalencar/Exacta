package com.exacta.question1;

import java.util.Arrays;
import java.util.IntSummaryStatistics;

public class Solution1 {
  public int solution(int[] A) {
    int minorValueInList = getMinorValueInList(A);
    return getMinorValueIsNotInList(A, minorValueInList);
  }

  private int getMinorValueIsNotInList(int[] values, int minorValueInList) {
    int minorValue = minorValueInList;
    final boolean isValueInList = isValueInList(values, minorValue);
    if (isValueInList) {
      minorValue = minorValueInList + 1;
      return getMinorValueIsNotInList(values, minorValue);
    } else {
      return minorValue;
    }
  }

  public static boolean isValueInList(final int[] arr, final int value) {
    return Arrays.stream(arr).anyMatch(i -> i == value);
  }

  private int getMinorValueInList(int[] a) {
    final IntSummaryStatistics summaryStatistics = Arrays.stream(a).summaryStatistics();
    final int min = summaryStatistics.getMin();
    if (min <= 0) {
      return 1;
    }
    return min;
  }

  public static void main(String[] args) {
    int[] a = {1, 3, 6, 4, 1, 2};
    Solution1 solution4 = new Solution1();
    int minorValue = solution4.solution(a);
    System.out.println(minorValue);

    int[] b = {1, 2, 3};
    solution4 = new Solution1();
    minorValue = solution4.solution(b);
    System.out.println(minorValue);

    int[] c = {-1, -3};
    solution4 = new Solution1();
    minorValue = solution4.solution(c);
    System.out.println(minorValue);
  }
}
