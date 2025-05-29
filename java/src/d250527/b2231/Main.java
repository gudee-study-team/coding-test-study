package d250527.b2231;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // [문제 분석]
    // 생성자를 "wxyz" 라고 한다면 분해합은 wxyz + w + x + y + z
    // 각 자리의 최대값은 9 => 생성자와 분해합의 차이는 최대 (자릿수 x 9)
    // => n자리수 분해합 X의 생성자는 반드시 X - 9n 이상에 있어야 함

    int number = scanner.nextInt();
    int startNum = number - (String.valueOf(number).length() * 9); // 생성자의 가능한 최소값
    if (startNum <= 0) startNum = 1;

    // 생성자의 최소값부터 1씩 증가하며 탐색
    for (int i = startNum; i <= number; i++) {
      if (cal(i) == number) {
        System.out.println(i);
        return; // 가장 먼저 발견한 생성자가 가장 작은 생성자 => 출력 후 즉시 종료
      }
    }

    System.out.println(0); // 생성자가 없으면 0 출력
  }

  // 생성자 num의 분해합을 구하는 메서드
  public static int cal(int num) {
    String[] numString = String.valueOf(num).split("");
    for (String s : numString) {
      num += Integer.parseInt(s);
    }

    return num;
  }
}
