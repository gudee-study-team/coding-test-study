package d250826.b1260;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

// [문제 분석]
// 주어진 그래프를 DFS, BFS로 탐색한 결과를 출력하기
// DFS는 Stack, BFS는 Queue를 사용해 구현 가능

public class Main {
	private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
	private static final List<String> RESULT_LIST = new ArrayList<>();
	
	// 그래프를 구현할 노드
	private static class Node {
		int number; // 노드의 값
		boolean visited = false; // 노드 방문 여부
		List<Node> linkedNodeList = new ArrayList<>(); // 연결된 모든 노드
		
		Node(int number) {
			this.number = number;
		}
	}
	
	public static void main(String[] args) {
		try (BR) {
			String[] settings = BR.readLine().split(" ");
			int nodeNum = Integer.parseInt(settings[0]);
			int graphNum = Integer.parseInt(settings[1]);
			int startNode = Integer.parseInt(settings[2]);
			
			// 각 노드에 접근하기 쉽도록 배열 생성
			Node[] nodeArr = new Node[nodeNum + 1];
			for (int i = 0; i < nodeArr.length; i++) {
				nodeArr[i] = new Node(i);
			}
			
			// 노드간의 연결 데이터 처리
			for (int i = 0; i < graphNum; i++) {
				String[] input = BR.readLine().split(" ");
				Node leftNode = nodeArr[Integer.parseInt(input[0])];
				Node rightNode = nodeArr[Integer.parseInt(input[1])];
				
				leftNode.linkedNodeList.add(rightNode);
				rightNode.linkedNodeList.add(leftNode);
			}
			
			// 완성된 그래프를 각각 DFS, BFS 방식으로 탐색하고 결과를 출력
			dfs(nodeArr[startNode]);
			System.out.println(String.join(" ", RESULT_LIST));
			
			for (Node node : nodeArr) {
				node.visited = false;
			}
			RESULT_LIST.clear();
			
			bfs(nodeArr[startNode]);
			System.out.println(String.join(" ", RESULT_LIST));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// Stack을 사용한 DFS 탐색 메서드
	private static void dfs(Node startNode) {
		ArrayDeque<Node> stack = new ArrayDeque<>();
		stack.push(startNode);
		
		while (!stack.isEmpty()) {
			Node node = stack.pop();
			if (node.visited) continue;
			
			RESULT_LIST.add(String.valueOf(node.number));
			node.visited = true;
			
			node.linkedNodeList.sort((o1, o2) -> Integer.compare(o2.number, o1.number));
			for (Node linkedNode : node.linkedNodeList) {
				if (!linkedNode.visited) {
					stack.push(linkedNode);
				}
			}
		}
	}
	
	// Queue를 사용한 BFS 탐색 메서드
	private static void bfs(Node startNode) {
		Queue<Node> queue = new ArrayDeque<>();
		queue.offer(startNode);
		
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			if (node.visited) continue;
			
			RESULT_LIST.add(String.valueOf(node.number));
			node.visited = true;
			
			node.linkedNodeList.sort((o1, o2) -> Integer.compare(o1.number, o2.number));
			for (Node linkedNode : node.linkedNodeList) {
				if (!linkedNode.visited) {
					queue.offer(linkedNode);
				}
			}
		}
	}
	
}
