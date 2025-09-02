package d250819.b5639;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

// [문제 분석]
// 이진 탐색 트리의 전위 순회 결과를 토대로 트리를 생성
// => 생성한 트리를 후위 순회한 결과를 출력하기

// 이진 탐색 트리의 특징: 왼쪽 노드는 반드시 나보다 작고, 오른쪽 노드는 반드시 나보다 큼
// 전위 순회의 특징: 제일 첫 번째 노드의 값이 루트 노드의 값
// => 첫 번째 값을 루트로 지정한 후, 이후의 값들을 이진 탐색 트리의 특징에 따라 적절한 위치에 배치

public class Main {
  private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
  private static final BufferedWriter BW = new BufferedWriter(new OutputStreamWriter(System.out));

  // 트리를 구성할 노드 클래스
  private static class Node {
    int element;
    Node leftNode;
    Node rightNode;

    Node(int element) {
      this.element = element;
    }
  }

  public static void main(String[] args) {
    try (BR; BW) {
      // 첫 번째 값을 루트 노드로 지정
      Node rootNode = new Node(Integer.parseInt(BR.readLine()));

      // 이후의 값들을 받아 적절한 위치에 삽입
      while (true) {
        String input = BR.readLine();
        if (input == null) break;

        int number = Integer.parseInt(input);
        insertNode(rootNode, number);
      }

      // 완성된 트리를 후위 순회
      postorder(rootNode);
      BW.flush();
    } catch (Exception e) { e.printStackTrace(); }
  }

  // 노드를 적절한 위치에 삽입하는 메서드
  private static void insertNode(Node node, int number) {
    // 만약 현재 노드보다 number의 값이 작다면
    // => 왼쪽 노드가 비어 있다면 왼쪽 노드에 삽입 후 종료
    // => 왼쪽 노드가 비어 있지 않다면 해당 노드를 기준으로 메서드를 재귀 호출
    // 오른쪽도 같은 방법으로 진행

    if (node.element > number) {
      if (node.leftNode == null) node.leftNode = new Node(number);
      else insertNode(node.leftNode, number);
    } else {
      if (node.rightNode == null) node.rightNode = new Node(number);
      else insertNode(node.rightNode, number);
    }
  }

  // 후위 순회 메서드
  private static void postorder(Node node) throws Exception {
    if (node == null) return;

    postorder(node.leftNode);
    postorder(node.rightNode);
    BW.write(node.element + "\n");

  }
}

