package d250610.b10773;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    Deque<Integer> stack = new ArrayDeque<>();

    // [문제 분석]
    // 주어지는 정수를 그대로 받아 적다가 잘못 부른 정수만 그때그때 지우기
    // 입력된 정수를 스택에 push하다가 0일 경우에만 pop으로 가장 최근 스택에 들어간 숫자를 제거
    // "정수가 "0"일 경우에 지울 수 있는 수가 있음을 보장할 수 있다" => pop에 대한 예외 처리를 하지 않아도 됨

    // 정수 K의 개수가 최대 10만개이므로 보조 스트림을 사용
    int numbers = Integer.parseInt(bufferedReader.readLine());
    for (int i = 0; i < numbers; i++) {
      int number = Integer.parseInt(bufferedReader.readLine());
      if (number == 0) { // 입력이 0으로 들어왔을 때만 pop으로 최근 숫자를 제거
        stack.pop();
        continue;
      }

      stack.push(number);
    }

    // 출력 => 스택에서 데이터를 하나씩 pop하면서 더하기
    // "최종적으로 적어낸 수의 합은 2^31 - 1 보다 작거나 같은 정수이다" => 모든 결과가 int형임을 보장
    int result = 0;
    while (!stack.isEmpty()) {
      result += stack.pop();
    }

    System.out.println(result);
  }
}