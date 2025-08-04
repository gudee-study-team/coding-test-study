package d250731.b18258;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
  private static final Queue<String> queue = new ArrayDeque<>();
  private static final BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
  private static final BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

  // [문제 분석]
  // Queue 자료구조에서 지원하는 기능들을 입력받아 어떤 명령인지 구분하고
  // 해당하는 명령을 실행하는 메서드로 보내 실행

  public static void main(String[] args) {
    try (bufferedReader; bufferedWriter) {
      int testCase = Integer.parseInt(bufferedReader.readLine());
      for (int i = 0; i < testCase; i++) {
        queueService(bufferedReader.readLine()); // 명령을 입력받아 그대로 서비스로 전달
      }

      bufferedWriter.flush();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // 서비스에서 명령의 종류를 구분하고 각 명령을 담당하는 메서드를 실행
  private static void queueService(String input) throws IOException {
    String[] command = input.split(" ");
    switch (command[0]) {
      case "push" -> push(command[1]);
      case "pop" -> pop();
      case "size" -> size();
      case "empty" -> empty();
      case "front" -> front();
      case "back" -> back();
      default -> System.out.println("잘못된 명령입니다.");
    }
  }

  private static void push(String num) {
    queue.offer(num);
  }

  private static void pop() throws IOException {
    bufferedWriter.write(queue.isEmpty() ? "-1\n" : queue.poll() + "\n");
  }

  private static void size() throws IOException {
    bufferedWriter.write(queue.size() + "\n");
  }

  private static void empty() throws IOException {
    bufferedWriter.write(queue.isEmpty() ? "1\n" : "0\n");
  }

  private static void front() throws IOException {
    bufferedWriter.write(queue.isEmpty() ? "-1\n" : queue.peek() + "\n");
  }

  private static void back() throws IOException {
    if (queue.isEmpty()) bufferedWriter.write("-1\n");
    else {
      if (queue instanceof ArrayDeque<?>) {
        ArrayDeque<?> arrayDeque = (ArrayDeque<?>) queue;
        bufferedWriter.write(arrayDeque.peekLast() + "\n");
      }
    }
  }
}

