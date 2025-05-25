import java.util.Scanner;

public class P2816 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // 문제 분석: KBS1과 KBS2를 각각 index 0, 1로 가져오기
    // 채널 최대 수는 100개인데 방법의 길이 최대값은 500 => 처음부터 끝까지 두 번 왕복해도 최대값을 넘지 않음
    // KBS1과 KBS2의 index 값을 구해서 하나하나 직접 끌어올릴 수 있음

    // 두 채널의 index 값 구하기
    int channel = scanner.nextInt();
    scanner.nextLine();

    int kbs1_index = 0;
    int kbs2_index = 0;
    for (int i = 0; i < channel; i++) {
      String s = scanner.nextLine();

      if ("KBS1".equals(s)) kbs1_index = i;
      if ("KBS2".equals(s)) kbs2_index = i;
    }

    // 버튼 입력 방법 출력하기
    if (kbs1_index > kbs2_index) kbs2_index++;
    for (int i = 1; i <= kbs1_index; i++) {
      System.out.print(1);
    }

    for (int i = 1; i <= kbs1_index; i++) {
      System.out.print(4);
    }

    for (int i = 1; i <= kbs2_index; i++) {
      System.out.print(1);
    }

    for (int i = 1; i < kbs2_index; i++) {
      System.out.print(4);
    }
  }
}