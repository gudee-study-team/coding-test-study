package d250527.b2798;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // [문제 분석]
    // N장의 카드 중 임의로 3장을 선택해 나온 합이 M에 최대한 가까워야 함
    // 입력받은 모든 카드를 3장씩 골라 합을 구해서 => M보다 크면 버리고, M보다 작으면 기존 최대값과 비교

    int[] numbers = new int[scanner.nextInt()];
    int m = scanner.nextInt();
    for (int i = 0; i < numbers.length; i++) {
      numbers[i] = scanner.nextInt();
    }

    // [문제를 다시 풀면서 개선한 부분]-----
    // 입력받은 수를 정렬해서 앞부터 3장씩 고르도록 변경
    // 합이 M을 넘으면 이후의 카드를 선택할 필요가 없음 => 수행시간 감소

    Arrays.sort(numbers);

    int result = 0;
    for (int i = 0; i < numbers.length - 2; i++) {
      if (numbers[i] > m) break;

      for (int j = i + 1; j < numbers.length - 1; j++) {
        if (numbers[i] + numbers[j] > m) break;

        for (int k = j + 1; k < numbers.length; k++) {
          int sum = numbers[i] + numbers[j] + numbers[k];
          if (sum > m) break;
          if (sum > result) result = sum;
        }
      }
    }

    // -------------------------------------

    System.out.println(result);
  }
}



//    [기존 코드]

//  int result = 0;
//  for (int i = 0; i < numbers.length - 2; i++) {
//    for (int j = i + 1; j < numbers.length - 1; j++) {
//      for (int k = j + 1; k < numbers.length; k++) {
//        int sum = numbers[i] + numbers[j] + numbers[k];
//        if (sum > m) continue;
//        if (sum > result) result = sum;
//      }
//    }
//  }