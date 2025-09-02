package d250812.b20920;

import java.io.*;
import java.util.*;

public class Main {
  private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
  private static final BufferedWriter BW = new BufferedWriter(new OutputStreamWriter(System.out));
  private static Map<String, Integer> wordCount = new HashMap<>(); // 단어의 수를 카운트할 Map
  private static List<String> wordList = new ArrayList<>(); // 단어를 정렬할 단어장 List

  public static void main(String[] args) {
    try (BR; BW) {
      StringTokenizer stringTokenizer = new StringTokenizer(BR.readLine());
      int testCase = Integer.parseInt(stringTokenizer.nextToken());
      int minLength = Integer.parseInt(stringTokenizer.nextToken());

      // [문제 분석]
      // 정렬의 기준은 세 가지
      // 1. 자주 나오는 단어가 앞으로 와야 함
      // 2. 나오는 횟수가 같으면 => 더 긴 단어가 앞으로 와야 함
      // 3. 단어의 길이까지 같으면 => 사전 순으로 정렬

      // 자주 나오는 단어가 더 높은 우선순위를 가져야 함
      // => 정렬을 위한 List와 단어의 수를 카운트할 Map을 사용하자

      for (int i = 0; i < testCase; i++) {
        String word = BR.readLine();

        // 일정 길이 이상인 경우에만 단어장에 추가
        if (word.length() >= minLength) {
          addWordList(word);
        }
      }

      // 중복 제거
      wordList = new ArrayList<>(new HashSet<>(wordList));

      sortWordList();
      printWordList();

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // 단어를 단어장에 추가하는 메서드
  private static void addWordList(String word) {
    int count = wordCount.containsKey(word) ? wordCount.get(word) + 1 : 1;

    wordList.add(word);
    wordCount.put(word, count);
  }

  // 정렬 기준에 따라 단어를 정렬하는 메서드
  private static void sortWordList() {
    wordList.sort(new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        int o1Count = wordCount.get(o1);
        int o2Count = wordCount.get(o2);

        if (o1Count != o2Count) {
          return Integer.compare(o2Count, o1Count); // 1차 정렬: 더 많이 등장한 단어
        } else if (o1.length() != o2.length()) {
          return Integer.compare(o2.length(), o1.length()); // 2차 정렬: 더 긴 단어
        } else {
          return o1.compareTo(o2); // 3차 정렬: 사전상 앞에 있는 단어
        }
      }
    });
  }

  // 정렬을 마친 단어를 출력하는 메서드
  private static void printWordList() throws IOException {
    for (String word : wordList) {
      BW.write(word + "\n");
    }

    BW.flush();
  }
}

