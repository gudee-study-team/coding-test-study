package d250818.b1991;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 전위 순회
 * 루트부터 시작
 *(자식이 여러개면 왼쪽부터 선택
 * 자식이 하나면 자식이 여러개가 되기 전까지 탐색
 * 탐색이 끝나면 {오른쪽 선택})
 * ()를 반복
 * {}이 맨 오른쪽 맨 마지막이면 종료
 * 
 * 중위 순회
 * 맨 왼쪽 끝부터 시작
 * 부모를 선택
 * 부모의 자식이 여러개가 되기 전까지 탐색
 * 부모의 자식이 여러개면 그 부모의 오른쪽 자식 선택
 * 섵
 * 
 */
class Node {
	public String parent;
	public String leftChild;
	public String rightChild;
	
	public Node() {
	
	}
	
	public Node(String parent, String leftChild, String rightChild) {
		this.parent = parent;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}
	
	public void chooseLeft(Node node, String next) {
		if (node.leftChild == null) {
			
		}
	}
}

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
//		Map<String, List<String>> nodeMap = new HashMap<>();
//		
//		for (int i = 0; i < n; i++) {
//			String input[] = br.readLine().split(" ");
//			nodeMap.put(input[0], List.of(input[1], input[2]));
//		}
//		
//		// 전위 순회
//		// 만약 key가 A면 루드 노드로
//		String start = "A";
//		System.out.print(start);
//		
//		// 만약 start의 자식이 여러개라면 stack에 기억해놓기(끝까지 탐색을 완료하면 가장 최근 것부터 돌아가야 함)
//		Deque<String> stack = new ArrayDeque<String>();
//		if (!nodeMap.get(start).contains(".")) stack.push(start);
//		else if (nodeMap.get(start).get(0).equals(".") && nodeMap.get(start).get(1).equals(".")) {
//			
//		}
//		
//		while (true) {
//			if (nodeMap.get(start) == null) break;
//			
//			// 만약 왼쪽 자식이 있다면 선택 없다면 오른쪽 선택
//			String leftChild = nodeMap.get(start).get(0);
//			String rightChild = nodeMap.get(start).get(1);
//			if (!leftChild.equals(".")) start = leftChild;
//			else start = rightChild;
//			
//			System.out.print(start);			
//		}
	}
}
