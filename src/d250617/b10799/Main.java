package d250617.b10799;

import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // [문제 분석]
    // (를 만나면 스택을 추가하고, )를 만나면 스택을 제거
    // 하지만 () 이렇게 붙어있으면 그 자체를 레이저로 간주하고 쇠막대기를 자름
    // => 일단 (인 경우 스택에 넣고, )인 경우 2가지 중 하나로 판단
    // 1. 바로 앞이 (이면 합쳐서 레이저가 되고 2. 바로 앞이 )이면 막대기를 제거

    // 쇠막대기의 수는 레이저가 되었을 때의 스택의 크기
    // 어차피 스택을 써도 스택의 크기만 사용되기 때문에 => 포인터로 푸는 것이 조금 더 효율적이겠다

    String[] line = scanner.nextLine().split("");
    int count = 0;
    int tree = 0; // 포인터: 쇠막대기 (풀 당시엔 통나무인줄 알았음)
    for (int i = 0; i < line.length; i++) {
      switch (line[i]) {
        case "(" -> tree++; // "("인 경우 포인터를 증가

        case ")" -> {
          if (i == 0) continue; // 시작부터 ")"인 경우에 대한 처리

          switch (line[i - 1]) {
            case "(" -> count += --tree; // 바로 앞이 "("인 경우 -> 방금 전 넣었던 "("를 제거하고 레이저로 자르기
            case ")" -> { // 바로 앞이 ")"인 경우 -> 막대기 끄트머리 하나를 마저 추가하고 포인터 감소
              tree--;
              count++;
            }
          }
        }
      }
    }

    System.out.println(count);
  }
}
