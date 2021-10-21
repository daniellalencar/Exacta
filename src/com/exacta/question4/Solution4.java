package com.exacta.question4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution4 {
  public void printIntersection(int[] setA, int[] setB) {
    if (setA != null && setB != null) {
      Arrays.sort(setA);
      Arrays.sort(setB);
      ArrayList<Integer> commonSet = new ArrayList<Integer>();

      //      for (int i = 0; i < setA.length; i++) {
      //        for (int j = 0; j < setB.length; j++) {
      //          if (setA[i] == setB[j] && !commonSet.contains(setA[i])) {
      //            commonSet.add(setA[i]);
      //          }
      //        }
      //      }

      final List<Integer> intsA = Arrays.stream(setA).boxed().collect(Collectors.toList());
      final List<Integer> intsB = Arrays.stream(setB).boxed().collect(Collectors.toList());
      Set<Integer> auxCommonSet = new HashSet<>();
      auxCommonSet.addAll(intsA);
      auxCommonSet.addAll(intsB);
      commonSet = new ArrayList<>(auxCommonSet);

      for (int k = 0; k < commonSet.size(); k++) {
        System.out.print(commonSet.get(k) + " ");
      }
    }
  }

  public static void main(String[] args) {
    Solution4 solution4 = new Solution4();
    int setA[] = {1, 2, 3, 4, 5};
    int setB[] = {3, 4, 5, 6, 7};

    solution4.printIntersection(setA, setB);
    //	  System.out.println(solution4);
  }
}
