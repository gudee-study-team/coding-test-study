package d250731.b28279;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
  private static final Deque<String> deque = new ArrayDeque<>();
  private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
  private static final BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

  // [문제 분석]
  // Deque 자료구조에서 지원하는 기능들을 입력받아 어떤 명령인지 구분하고
  // 해당하는 명령을 실행하는 메서드로 보내 실행

  public static void main(String[] args) {
    try (bufferedReader; bufferedWriter) {
      int testCase = Integer.parseInt(bufferedReader.readLine());
      for (int i = 0; i < testCase; i++) {
        dequeService(bufferedReader.readLine());
      }

      bufferedWriter.flush();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // 서비스에서 명령의 종류를 구분하고 각 명령을 담당하는 메서드를 실행
  private static void dequeService(String input) throws Exception {
    String[] command = input.split(" ");
    switch (command[0]) {
      case "1" -> offerFirst(command[1]);
      case "2" -> offerLast(command[1]);
      case "3" -> pollFirst();
      case "4" -> pollLast();
      case "5" -> size();
      case "6" -> empty();
      case "7" -> peekFirst();
      case "8" -> peekLast();
      default -> System.out.println("잘못된 명령입니다.");
    }
  }

  private static void offerFirst(String num) {
    deque.offerFirst(num);
  }

  private static void offerLast(String num) {
    deque.offerLast(num);
  }

  private static void pollFirst() throws Exception {
    bufferedWriter.write(deque.isEmpty() ? "-1\n" : deque.pollFirst() + "\n");
  }

  private static void pollLast() throws Exception {
    bufferedWriter.write(deque.isEmpty() ? "-1\n" : deque.pollLast() + "\n");
  }

  private static void size() throws Exception {
    bufferedWriter.write(deque.size() + "\n");
  }

  private static void empty() throws Exception {
    bufferedWriter.write(deque.isEmpty() ? "1\n" : "0\n");
  }

  private static void peekFirst() throws Exception {
    bufferedWriter.write(deque.isEmpty() ? "-1\n" : deque.peekFirst() + "\n");
  }

  private static void peekLast() throws Exception {
    bufferedWriter.write(deque.isEmpty() ? "-1\n" : deque.peekLast() + "\n");
  }
}

