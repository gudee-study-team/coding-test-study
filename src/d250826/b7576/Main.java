package d250826.b7576;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// [문제 분석]
// 격자 모양 상자에 토마토가 들어있음
// 익은 토마토 근처의 안 익은 토마토는 다음날 익음
// BFS로 구현할 수 있을 것 같지만 날짜를 세어야 하는 것이 문제
// => 날짜별로 새로운 리스트를 생성해 교체하면서 해결해보자

public class Main {
	private static final BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));
	private static List<Node> ripingTomatoes = new ArrayList<>(); // 익은 토마토를 보관하는 리스트
	private static int ripeDays = 0; // 날짜 카운터
	
	// 토마토를 구현할 노드
	private static class Node {
		int state;
		Node topNode;
		Node downNode;
		Node leftNode;
		Node rightNode;
		
		Node(int state) {
			this.state = state;
		}
	}
	
	public static void main(String[] args) {
		try (BR) {
			String[] settings = BR.readLine().split(" ");
			int col = Integer.parseInt(settings[0]);
			int row = Integer.parseInt(settings[1]);
			
			// 박스를 생성하고 토마토를 담기
			Node[][] tomatoBox = new Node[row][col];
			StringTokenizer stringTokenizer;
			for (int i = 0; i < tomatoBox.length; i++) {
				stringTokenizer = new StringTokenizer(BR.readLine(), " ");
				
				for (int j = 0; j < tomatoBox[i].length; j++) {
					int state = Integer.parseInt(stringTokenizer.nextToken());
					Node node = state != -1 ? new Node(state) : null; // -1이라면 토마토가 없으므로 null을 입력
					tomatoBox[i][j] = node;
					
					// 익은 토마토는 리스트에 추가
					if (state == 1) {
						ripingTomatoes.add(node);
					}
				}
			}
			
			// 토마토간의 관계를 설정
			for (int i = 0; i < tomatoBox.length; i++) {
				for (int j = 0; j < tomatoBox[i].length; j++) {
					Node node = tomatoBox[i][j];
					
					if (node != null) {
						if (i != 0) node.topNode = tomatoBox[i - 1][j];
						if (j != 0) node.leftNode = tomatoBox[i][j - 1];
						if (j != col - 1) node.rightNode = tomatoBox[i][j + 1];
						if (i != row - 1) node.downNode = tomatoBox[i + 1][j];											
					}
				}
			}
			
			// 토마토를 익힘
			ripeTomato();
			
			// 연결된 모든 토마토가 익었음에도 익지 않은 토마토가 남았다면 그 토마토의 접근 방법이 없으므로 -1 출력
			for (int i = 0; i < tomatoBox.length; i++) {
				for (int j = 0; j < tomatoBox[i].length; j++) {
					if (tomatoBox[i][j] != null && tomatoBox[i][j].state == 0) {
						System.out.println(-1);
						return;
					}
				}
			}
			
			// 그렇지 않다면 그대로 결과를 출력
			System.out.println(ripeDays);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 모든 토마토가 익을 때까지의 일수를 계산하는 메서드
	private static void ripeTomato() {
		if (ripingTomatoes.size() == 0) return; // 처음부터 익은 토마토가 없으면 익을 토마토도 없으니 즉시 리턴
		
		// 하루에 일어나는 일
		while (true) {
			List<Node> newRipingTomatoes = new ArrayList<>(); // 새롭게 익은 토마토를 담을 리스트
			// 익은 토마토의 상하좌우 토마토들을 익힘
			for (Node tomato : ripingTomatoes) {
				// 비어있지 않고, 토마토가 없지 않고, 토마토가 익지 않았다면 익지 않은 토마토가 반드시 있으므로 그 토마토를 익히고 익은 토마토 리스트에 추가
				if (tomato.topNode != null && tomato.topNode.state != 1 && tomato.topNode.state != -1) {
					tomato.topNode.state = 1;
					newRipingTomatoes.add(tomato.topNode);
				}
				
				if (tomato.downNode != null && tomato.downNode.state != 1 && tomato.downNode.state != -1) {
					tomato.downNode.state = 1;
					newRipingTomatoes.add(tomato.downNode);
				}
				
				if (tomato.leftNode != null && tomato.leftNode.state != 1 && tomato.leftNode.state != -1) {
					tomato.leftNode.state = 1;
					newRipingTomatoes.add(tomato.leftNode);
				}
				
				if (tomato.rightNode != null && tomato.rightNode.state != 1 && tomato.rightNode.state != -1) {
					tomato.rightNode.state = 1;
					newRipingTomatoes.add(tomato.rightNode);
				}
			}
			
			// 새롭게 익은 토마토가 있다면 일수를 추가하고 익은 토마토들을 기존 리스트와 교체
			// 없다면 더 이상 익을 토마토가 없으므로 메서드를 종료
			if (!newRipingTomatoes.isEmpty()) {
				ripeDays++;
				ripingTomatoes = newRipingTomatoes;
			} else {
				break;
			}
		}
		
	}
	
}
