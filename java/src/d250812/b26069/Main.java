package d250812.b26069;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
  private static final Set<String> danceSet = new HashSet<>(); // 춤추는 사람들을 담을 Set
  private static final String FIRST_DANCER = "ChongChong"; // 최초의 춤추는 자

  public static void main(String[] args) {
    StringTokenizer stringTokenizer;
    danceSet.add(FIRST_DANCER);

    // [문제 분석]
    // 춤을 추는 사람과 만나면 춤을 추게 됨 + 춤을 멈추는 일은 없음 => 만나는 사람을 Set에 넣어버리자!
    // 중복 제거는 Set이 알아서 해줄 것

    try (Scanner scanner = new Scanner(System.in)) {
      int testCase = scanner.nextInt();
      scanner.nextLine();

      for (int i = 0; i < testCase; i++) {
        stringTokenizer = new StringTokenizer(scanner.nextLine());
        meetPeople(stringTokenizer.nextToken(), stringTokenizer.nextToken());
      }
    }

    System.out.println(danceSet.size());
  }

  // 둘 중 하나라도 춤을 추고 있다면 둘 다 Set에 넣어버리는 메서드
  private static void meetPeople(String person1, String person2) {
    if (danceSet.contains(person1) || danceSet.contains(person2)) {
      danceSet.add(person1);
      danceSet.add(person2);
    }
  }
}

