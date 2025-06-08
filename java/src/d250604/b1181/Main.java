package d250604.b1181;

import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
    Set<String> set = new HashSet<>();
    List<String> list;

    // [문제 분석]
    // 정렬의 순서: 1. 단어의 길이 2. 단어의 사전 순서
    // 중복된 단어는 제거 => Set 인터페이스 사용
    // 정렬 우선 순위에 맞게 메서드를 오버라이딩한 Comparator 구현

    // 입력 + Set 으로 중복 제거
    int amountWord = Integer.parseInt(bufferedReader.readLine());
    for (int i = 0; i < amountWord; i++) {
      set.add(bufferedReader.readLine());
    }

    // List로 변환 후 조건에 맞게 compare를 오버라이딩한 Comparator 익명 클래스 객체를 활용
    list = new ArrayList<>(set);
    list.sort(new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        if (o1.length() == o2.length()) { // 단어의 길이가 같으면 -> 단어를 사전 순으로 비교
          return o1.compareTo(o2);
        } else {
          return Integer.compare(o1.length(), o2.length());
        }
      }
    });

    // 출력
    for (String s : list) {
      bufferedWriter.write(s + "\n");
    }

    bufferedWriter.flush();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
