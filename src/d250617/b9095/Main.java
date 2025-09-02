package d250617.b9095;

import java.util.Scanner;

public class Main {
  static int count = 0;

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // [문제 분석]
    // 주어진 정수를 1, 2, 3의 합으로 나타내기
    // 경우의 수는 세 가지: 1을 선택했을 때, 2를 선택했을 때, 3을 선택했을 때
    // 각각의 경우에 대해 -1, -2, -3을 한 값으로 재귀 호출
    // 재귀 중 정수의 값이 0이 되면 올바르게 선택된 것 => count를 증가
    // 0보다 작아지면 잘못 선택된 것 => count 하지 않고 return

    int testCase = scanner.nextInt();
    for (int i = 0; i < testCase; i++) {
      count = 0;
      sep123(scanner.nextInt());
      System.out.println(count);
    }
  }

  static void sep123(int num) {
    if (num < 0) return; // 잘못 선택된 경우

    if (num == 0) { // 올바르게 선택된 경우
      count++;
      return;
    }

    // 재귀 호출 (1을 선택한 이후의 재귀가 모두 끝나면 다시 2를 선택하고 재귀 호출 ...)
    sep123(num - 1);
    if (num >= 2) sep123(num - 2);
    if (num >= 3) sep123(num - 3);
  }
}
