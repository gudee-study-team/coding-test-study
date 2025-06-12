package d250610.b9012;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Deque<String> stack = new ArrayDeque<>();

    // [문제 분석]
    // 입력 데이터가 VPS가 되기 위해 만족해야 하는 조건
    // 1. 기호 (와 )의 갯수가 서로 같아야 함
    // 2. 기호 )의 갯수는 반드시 자신 앞의 기호 (의 갯수를 초과할 수 없음

    // 스택을 사용해 구현 => 기호가 (일 경우 push, )일 경우 pop 하면서 입력 데이터를 검증
    // 1. 데이터 검증이 끝난 후 stack이 비어있지 않은 경우 => 조건 1에 위배
    // 2. 데이터 검증 중 pop 메서드에서 NoSuchElementException 예외 발생 => 조건 2에 위배

    int testCase = scanner.nextInt();
    scanner.nextLine();

    for (int i = 0; i < testCase; i++) {
      stack.clear();
      String[] ps = scanner.nextLine().split(""); // 검증할 데이터 입력

      // 데이터 검증
      try {
        for (String p : ps) {
          switch (p) {
            case "(" -> stack.push("PS");
            case ")" -> stack.pop();
          }
        }

        // 조건 1 판단
        if (stack.isEmpty()) System.out.println("YES");
        else System.out.println("NO");
      } catch (NoSuchElementException e) { // 조건 2 판단
        System.out.println("NO");
      }
    }
  }
}

// 기존 풀이 (Pointer를 사용한 구현)

//public class Main {
//  public static void main(String[] args) {
//    Scanner scanner = new Scanner(System.in);
//
//    int testCase = scanner.nextInt();
//    scanner.nextLine();
//
//    VPS를 만족하는 조건
//    1. (와 )의 갯수가 같아야 함
//    2. )는 반드시 이전에 나온 (의 갯수를 초과할 수 없음
//
//    두 조건을 만족하는지 검증하는 Pointer를 지정
//    검증 중 (을 만나면 Pointer를 1 증가시키고, )를 만나면 1 감소시킴
//    1. 입력 데이터의 검증이 끝났을 때 Pointer가 0이 아니면 조건 1에 위배되므로 VPS가 아님
//    2. 입력 데이터 검증 도중 Pointer가 0보다 작아질 경우 조건 2에 위배되므로 VPS가 아님
//
//    for (int i = 0; i < testCase; i++) {
//      int pointer = 0;
//      boolean isVPS = true;
//      String[] vps = scanner.nextLine().split("");
//
//      for (String s : vps) {
//        if (s.equals("(")) {
//          pointer++;
//        } else {
//          pointer--;
//        }
//
//        조건 2 판단
//        if (pointer < 0) {
//          isVPS = false;
//        }
//      }
//
//      조건 1 판단
//      if (pointer > 0) {
//        isVPS = false;
//      }
//
//      if (isVPS) System.out.println("YES");
//      else System.out.println("NO");
//    }
//  }
//}