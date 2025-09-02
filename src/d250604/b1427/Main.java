package d250604.b1427;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // [문제 분석]
    // 공백 없이 주어진 수들을 내림차순으로 정렬하기
    // 객체 배열은 Comparator를 사용할 수 있다

    // 배열 생성
    String[] numbers = scanner.nextLine().split("");

    // 배열 정렬
    Arrays.sort(numbers, Comparator.reverseOrder());

    // 출력
    System.out.println(String.join("", numbers));
  }
}
