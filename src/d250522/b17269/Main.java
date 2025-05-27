package d250522.b17269;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    List<Integer> list = new ArrayList<>();
    List<Integer> backupList;

    // 문제 분석: 각 알파벳을 해당하는 숫자로 변경
    // => 배열의 항과 바로 옆 항의 합을 가지는 새로운 배열을 생성 => 배열의 길이가 2가 될 때까지 반복

    int myNameLength = scanner.nextInt();
    int yourNameLength = scanner.nextInt();
    scanner.nextLine();

    String[] name = scanner.nextLine().split(" ");
    String myName = name[0];
    String yourName = name[1];

    // 포인터를 사용해 이름의 각 알파벳을 해당하는 숫자로 변경해 하나씩 List에 추가
    // 알파벳 문자를 받아 해당하는 숫자를 반환하는 changeEngToNum 메서드 작성
    int myPointer = 0;
    int yourPointer = 0;
    while (myPointer < myNameLength || yourPointer < yourNameLength) {
      if (myPointer < myNameLength) list.add(changeEngToNum(myName.charAt(myPointer++)));
      if (yourPointer < yourNameLength) list.add(changeEngToNum(yourName.charAt(yourPointer++)));
    }

    // 리스트의 크기가 2가 될 때까지 무한 반복
    // 매 회마다 기존 List를 Backup List에 넣고, 새로운 ArrayList 객체를 생성해 활용
    while (list.size() > 2) {
      backupList = list;
      list = new ArrayList<>();

      for (int i = 0; i < backupList.size() - 1; i++) {
        list.add((backupList.get(i) + backupList.get(i + 1)) % 10);
      }
    }

    // 결과 출력
    String result;
    if (list.get(0) % 10 != 0) {
      result = "" + (list.get(0) % 10) + (list.get(1) % 10) + "%";
    } else {
      result = (list.get(1) % 10) + "%";
    }

    System.out.println(result);
  }

  public static int changeEngToNum(char c) {
    return switch (c) {
      case 'C', 'G', 'I', 'J', 'L', 'O', 'S', 'U', 'V', 'W', 'Z' -> 1;
      case 'B', 'D', 'N', 'P', 'Q', 'R', 'T', 'X', 'Y' -> 2;
      case 'A', 'F', 'H', 'K', 'M' -> 3;
      case 'E' -> 4;
      default -> 0;
    };
  }
}
