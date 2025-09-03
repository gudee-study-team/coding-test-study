package d250826.b2606;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

// [문제 분석]
// 1번 컴퓨터와 연결된 모든 컴퓨터는 바이러스에 걸림
// => 1번 컴퓨터를 시작으로 하는 그래프를 모두 탐색하고 결과를 출력하자

// 컴퓨터를 구현할 클래스
class Computer {
  @SuppressWarnings("unused")
  private int comNo; // 컴퓨터의 번호
  private List<Computer> relations = new ArrayList<>(); // 연결된 모든 컴퓨터

  public Computer(int comNo) {
    this.comNo = comNo;
  }

  public List<Computer> getRelations() {
    return relations;
  }
}

public class Main {
  private static final Set<Computer> VIRUS_COM = new HashSet<>();

  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
			Computer[] computers = new Computer[scanner.nextInt() + 1];
			int relates = scanner.nextInt();
			
			// 각 컴퓨터에 접근하기 쉽도록 배열 생성
			for (int i = 1; i < computers.length; i++) {
			  computers[i] = new Computer(i);
			}
			
			// 컴퓨터 간의 연결 데이터 처리
			for (int i = 1; i <= relates; i++) {
			  Computer leftCom = computers[scanner.nextInt()];
			  Computer rightCom = computers[scanner.nextInt()];

			  leftCom.getRelations().add(rightCom);
			  rightCom.getRelations().add(leftCom);
			}

			// 1번 컴퓨터에 바이러스 살포
			virus(computers[1]);
		}

    System.out.println(VIRUS_COM.size() - 1);
  }

  // 재귀 방식으로 그래프 탐색
  static void virus(Computer computer) {
    if (VIRUS_COM.contains(computer)) return;

    VIRUS_COM.add(computer);

    List<Computer> list = computer.getRelations();
    for (Computer com : list) {
      virus(com);
    }
  }
}
