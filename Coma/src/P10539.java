import java.util.Scanner;

public class P10539 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // 문제 분석: 수열 A의 해당 항까지의 평균값을 항으로 하는 수열 B
    // 수열 B를 주었을 때 수열 A를 구하기

    // 해당 항까지의 평균값 => 수열 B의 각 항의 숫자는 (index + 1)로 나뉜 결과
    // 각 항을 해당 값으로 곱하면 수열 A의 합배열
    int[] sumArrOfA = new int[scanner.nextInt()];
    for (int i = 0; i < sumArrOfA.length; i++) {
      sumArrOfA[i] = scanner.nextInt() * (i + 1);
    }

    // 합배열의 n번째 항에서 n - 1번째 항을 빼면 수열 A의 n번째 항의 값
    int[] arrA = new int[sumArrOfA.length];
    arrA[0] = sumArrOfA[0];
    for (int i = 1; i < arrA.length; i++) {
      arrA[i] = sumArrOfA[i] - sumArrOfA[i - 1];
    }

    for (int i : arrA) {
      System.out.print(i + " ");
    }
  }
}
