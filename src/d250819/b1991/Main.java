package d250819.b1991;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

// [문제 분석]
// 주어진 노드의 관계 정보를 기반으로 트리를 만들고
// => 만든 트리를 전위, 중위, 후위 순회한 결과를 출력하기

public class Main {
  // 순회 결과를 담을 리스트
  private static final List<String> ORDER_LIST = new ArrayList<>();

  // 트리를 구성할 노드 클래스
  private static class Node {
    char element;
    Node leftNode;
    Node rightNode;

    Node(char element) {
      this.element = element;
    }

  }

  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
      int nodeNum = Integer.parseInt(scanner.nextLine());
      // 각 노드에 빠르게 접근하기 위한 노드 리스트
      List<Node> nodeList = new ArrayList<>();

      // A부터 알파벳 순서대로 노드를 만들어 리스트에 추가
      char c = 'A';
      for (int i = 0; i < nodeNum; i++) {
        nodeList.add(new Node(c++));
      }

      // 노드의 관계 데이터를 받아 처리
      StringTokenizer stringTokenizer;
      for (int i = 0; i < nodeNum; i++) {
        stringTokenizer = new StringTokenizer(scanner.nextLine(), " ");
        Node thisNode = nodeList.get(stringTokenizer.nextToken().charAt(0) - 'A'); // 해당 노드를 찾아 가져옴

        String left = stringTokenizer.nextToken();
        if (!left.equals(".")) {
          thisNode.leftNode = nodeList.get(left.charAt(0) - 'A'); // 노드의 왼쪽 노드가 존재하면 필드에 참조값 반영
        }

        String right = stringTokenizer.nextToken();
        if (!right.equals(".")) {
          thisNode.rightNode = nodeList.get(right.charAt(0) - 'A'); // 노드의 오른쪽 노드가 존재하면 필드에 참조값 반영
        }
      }

      // 완성된 트리를 각각 전위, 중위, 후위 순회 후 출력
      preorder(nodeList.get(0));
      printOrderList();

      inorder(nodeList.get(0));
      printOrderList();

      postorder(nodeList.get(0));
      printOrderList();
    }
  }

  // 전위 순회 메서드
  private static void preorder(Node node) {
    if (node == null) return;

    ORDER_LIST.add(String.valueOf(node.element));
    preorder(node.leftNode);
    preorder(node.rightNode);

  }

  // 중위 순회 메서드
  private static void inorder(Node node) {
    if (node == null) return;

    inorder(node.leftNode);
    ORDER_LIST.add(String.valueOf(node.element));
    inorder(node.rightNode);

  }

  // 후위 순회 메서드
  private static void postorder(Node node) {
    if (node == null) return;

    postorder(node.leftNode);
    postorder(node.rightNode);
    ORDER_LIST.add(String.valueOf(node.element));

  }

  // 순회가 끝난 후 결과를 출력하고 리스트를 청소하는 메서드
  private static void printOrderList() {
    for (String str : ORDER_LIST) {
      System.out.print(str);
    }

    System.out.println();
    ORDER_LIST.clear();
  }
}

