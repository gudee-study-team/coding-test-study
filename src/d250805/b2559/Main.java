package d250805.b2559;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
      int tempCase = scanner.nextInt();
      int period = scanner.nextInt();

      // [문제 분석]
      // M일의 기온 중 N일동안의 기온의 합을 구해 가장 큰 값을 찾기
      // N일동안의 기온의 합 = 0일부터 i + N일까지의 기온의 합 - 0일부터 i일까지의 기온의 합
      // (예: 4일동안의 기온의 합 = 0일부터 6일까지의 기온의 합 - 0일부터 2일까지의 기온의 합)
      // => M일동안의 기온의 합배열을 구하고 N일동안의 기온의 합의 최대값을 찾자

      int[] tempArr = new int[tempCase];
      for (int i = 0; i < tempArr.length; i++) {
        tempArr[i] = scanner.nextInt();
      }

      int[] tempSumArr = calcSumArr(tempArr);

      System.out.println(calcMaxSum(tempSumArr, period));
    }
  }

  // 기온의 합의 배열을 구하는 메서드
  private static int[] calcSumArr(int[] arr) {
    int[] result = new int[arr.length];
    result[0] = arr[0];
    for (int i = 1; i < result.length; i++) {
      result[i] = result[i - 1] + arr[i];
    }

    return result;
  }

  // period일동안의 합 중 가장 큰 값을 찾아 반환하는 메서드
  private static int calcMaxSum(int[] sumArr, int period) {
    int max = sumArr[period - 1];

    for (int i = 1; i < sumArr.length - period + 1; i++) {
      int sum = sumArr[i + period - 1] - sumArr[i - 1];

      if (sum > max) max = sum;
    }

    return max;
  }
}

