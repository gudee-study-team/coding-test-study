package d250610.b10773;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Deque<Integer> queue = new ArrayDeque<>();

    // [문제 분석]
    // 1부터 N까지 정렬된 카드를 두고 다음의 행동을 반복
    // 1. 맨 위 카드를 집어서 버리기
    // 2. 맨 위 카드를 집어서 맨 밑에 놓기
    // => Queue 자료구조를 활용해 구현하기

    // 1부터 N까지 큐에 카드 넣기
    int num = scanner.nextInt();
    for (int i = 1; i <= num; i++) {
      queue.offer(i);
    }

    // 1와 2의 행동을 카드가 1장 남을 때까지 반복
    while (queue.size() > 1) {
      queue.poll();
      queue.offer(queue.poll());
    }

    // 마지막 남은 카드를 뽑아 출력
    System.out.println(queue.poll());
  }
}






// 기존 풀이 (List를 사용한 구현)

//public class Main {
//  public static void main(String[] args) {
//    Scanner scanner = new Scanner(System.in);
//    List<Integer> list = new LinkedList<>();   <= index 0에서 카드를 계속 뽑기 때문에 LinkedList 사용
//
//    int cardNum = scanner.nextInt();
//    for (int i = 2; i <= cardNum; i += 2) {    <= 카드가 정렬된 상태에서 끝까지 한 번 돌면 첫 바퀴에서 무조건 홀수가 버려짐
//      list.add(i);                                1회전을 이미 돌았다 가정하고 리스트에 짝수만 추가
//    }
//    if (cardNum % 2 == 1) list.add(0, cardNum);
//
//    boolean cardSwitch = true;   <= 회차 분기: true일 때는 1, false일 때는 2의 행동을 진행
//    while (list.size() > 1) {
//      if (cardSwitch) {
//        list.remove(0);
//        cardSwitch = false;
//        continue;
//      }
//
//      int number = list.remove(0);
//      list.add(number);
//      cardSwitch = true;
//    }
//
//    System.out.println(list.get(0));
//  }
//}