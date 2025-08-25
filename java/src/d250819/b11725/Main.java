package d250819.b11725;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

// [문제 분석]
// 두 노드 사이의 연결 여부에 대한 데이터만 주어짐 => 누가 부모이고 자식인지 알 수 없음
// 연결된 노드들을 일단 리스트에 넣은 후, 루트 노드(1)를 시작으로 서열을 정리하자

public class Main {
  private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
  private static final BufferedWriter BW = new BufferedWriter(new OutputStreamWriter(System.out));

  // 트리를 구성할 노드 클래스
  private static class Node {
    int element;
    Node parentElement;
    List<Node> linkedElement = new ArrayList<>();

    Node(int element) {
      this.element = element;
    }
  }

  public static void main(String[] args) {
    try (BR; BW) {
      int nodeNum = Integer.parseInt(BR.readLine());

      // 각 노드에 접근하기 쉽도록 노드 리스트를 만들고, 노드의 개수만큼 생성해 추가 (값이 0인 노드는 더미)
      List<Node> nodeList = new ArrayList<>();
      for (int i = 0; i <= nodeNum; i++) {
        nodeList.add(new Node(i));
      }

      // 노드 간의 연결 정보를 받아 서로의 연결된 노드 리스트에 추가
      for (int i = 0; i < nodeNum - 1; i++) {
        String[] numbers = BR.readLine().split(" ");
        int numA = Integer.parseInt(numbers[0]);
        int numB = Integer.parseInt(numbers[1]);

        nodeList.get(numA).linkedElement.add(nodeList.get(numB));
        nodeList.get(numB).linkedElement.add(nodeList.get(numA));
      }

      // 각 노드들의 부모를 찾은 후 출력
      findMyParent(nodeList.get(1));
      printParent(nodeList);
      BW.flush();

    } catch (Exception e) { e.printStackTrace(); }
  }

  // 각 노드의 부모를 찾는 메서드
  // => 현재 노드와 연결된 모든 자식 노드의 부모 노드를 현재 노드로 설정
  // => 이후 모든 자식 노드의 연결된 노트 리스트에서 현재 노드를 제거해,
  // 자식 노드들의 연결된 노트 리스트에는 자식 노드들의 자식 노드들만 남도록 처리
  private static void findMyParent(Node node) {
    for (Node childNode : node.linkedElement) {
      childNode.linkedElement.remove(node);
      childNode.parentElement = node;
    }

    // 모든 처리가 완료되면 자식 노드들을 대상으로 메서드를 재귀 호출
    for (Node childNode : node.linkedElement) {
      findMyParent(childNode);
    }
  }

  // 각 노드들의 부모 노드를 출력하는 메서드
  private static void printParent(List<Node> nodeList) throws IOException {
    for (int i = 2; i < nodeList.size(); i++) {
      BW.write(nodeList.get(i).parentElement.element + "\n");
    }
  }
}

