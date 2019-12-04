//package com.amadeus.apt.rm.tests.rest.tests;

import java.util.Scanner;

public class Knapsack {
  static int optimalWeight(int W, int[] weights) {
    int value[][] = new int[weights.length + 1][W + 1];
    for (int i = 0; i <= weights.length; i++) {
      for (int w = 0; w <= W; w++) {
        if (i == 0 || w == 0) {
          value[i][w] = 0;
        } else if (weights[i - 1] <= w) {
          int max = value[i - 1][w - weights[i - 1]] + weights[i - 1];
          if (max > value[i - 1][w]) {
            value[i][w] = max;
          } else {
            value[i][w] = value[i - 1][w];
          }
        } else {
          value[i][w] = value[i - 1][w];
        }
      }
    }

    // for (int[] arr : value) {
    // for (int i = 0; i < arr.length; i++) {
    // System.out.print(arr[i] + " ");
    // }
    // System.out.println();
    // }

    return value[weights.length][W];
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int W, n;
    W = scanner.nextInt();
    n = scanner.nextInt();
    int[] w = new int[n];
    for (int i = 0; i < n; i++) {
      w[i] = scanner.nextInt();
    }
    System.out.println(optimalWeight(W, w));
    scanner.close();
  }
}
