package d250805.b11659;

import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
         BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {
      String[] setting = bufferedReader.readLine().split(" ");
      int numCount = Integer.parseInt(setting[0]);
      int testCase = Integer.parseInt(setting[1]);

      // [문제 분석]
      // 주어진 수열의 i부터 j까지의 합 구하기
      // 수의 개수와 테스트 케이스가 매우 많음 (최대 100,000) => 합 배열을 먼저 구하고 활용해 시간 절약

      String[] numbers = bufferedReader.readLine().split(" ");
      int[] numberArr = new int[numCount];
      for (int i = 0; i < numberArr.length; i++) {
        numberArr[i] = Integer.parseInt(numbers[i]);
      }

      // i번째 인덱스까지의 합에 대한 값을 저장하는 합 배열
      int[] numberSumArr = new int[numCount];
      numberSumArr[0] = numberArr[0];
      for (int i = 1; i < numberSumArr.length; i++) {
        numberSumArr[i] = numberSumArr[i - 1] + numberArr[i];
      }

      for (int i = 0; i < testCase; i++) {
        String[] pointer = bufferedReader.readLine().split(" ");
        int iPoint = Integer.parseInt(pointer[0]);
        int jPoint = Integer.parseInt(pointer[1]);

        if (iPoint <= 1) {
          bufferedWriter.write(numberSumArr[jPoint - 1] + "\n"); // i가 0번째 인덱스인 경우
        } else {
          bufferedWriter.write((numberSumArr[jPoint - 1] - numberSumArr[iPoint - 2]) + "\n");
        }
      }

      bufferedWriter.flush();
    }
  }
}

