package d250812.b25192;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
  private static final Set<String> USER_SET = new HashSet<>();
  private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));

  private static int gomCount = 0;

  // [문제 분석]
  // 참가자의 첫 채팅은 무조건 곰곰티콘 + 두 번째부터는 평범한 채팅 기록
  // 누군가가 들어오면 ENTER => 이후 다시 참가자의 첫 채팅이 무조건 곰곰티콘
  // => 참가자들을 Set에 넣고, ENTER가 발생한 경우 Set의 size를 변수에 저장하고 초기화

  public static void main(String[] args) {
    try (BR) {
      int chatLogCount = Integer.parseInt(BR.readLine());
      for (int i = 0; i < chatLogCount; i++) {
        analyzeLog(BR.readLine());
      }

      System.out.println(gomCount + USER_SET.size());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // 로그를 분석해 각 함수로 보내는 메서드
  private static void analyzeLog(String log) {
    if (log.equals("ENTER")) cleanUserSet();
    else addUserSet(log);
  }

  // ENTER가 발생할 경우 size 값을 변수에 더하고 set을 초기화하는 메서드
  private static void cleanUserSet() {
    gomCount += USER_SET.size();
    USER_SET.clear();
  }

  // 참가자를 set에 넣는 메서드
  private static void addUserSet(String user) {
    USER_SET.add(user);
  }
}

