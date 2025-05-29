package d250527.b1018;

import java.util.Scanner;

/*
 * 어떻게 접근해야 하지......
 * 8*8로 자르는 모든 경우의 수를 생각해 봤을 때
 * B/W 중 그 수가 적은 색깔을 칠하고, 칠한 갯수 저장
 * 칠한 갯수가 가장 적은 것 출력
 * 
 * 8*8로 자르는 모든 경우의 수....를 어떻게 다룰까
 * 8*8의 2차원 배열을 생성하고, 거기다 매번 초기화를 해줄까
 * 
 * M*N의 보드.... 입력은 N M의 순서로 들어옴
 * 
 * *****
 * 
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int iNum = sc.nextInt();
		int jNum = sc.nextInt();
		sc.nextLine();
		
		String[][] board = new String[iNum][jNum];		
		
		for (int i = 0; i < board.length; i++) { // 10번 반복
			String inputLine = sc.nextLine();
			for (int j = 0; j < board[i].length; j++) { // 13번 반복
				board[i][j] = inputLine.charAt(j)+"";
			}
		}
		
		// 가로, 세로 - 보드길이-체스판길이+1만큼 탐색
		// [0][0]부터 시작하고, 탐색한 마지막 인덱스가 [체스판길이-1][체스판길이-1]이 되면 탐색 끝
		// 시작 인덱스는 [0][0] [0][1]....과 같이 증가하다가 [0][7]이 되면 [1][0] [1][1].....
		// 마지막 줄은 [7][0]....[7][7]
		// 즉, i인덱스건 j인덱스건 시작 인덱스-끝 인덱스=7이 되면 끝난다는 것
		// => 시작 인덱스-끝 인덱스=7이 되면 멈추기
		int startIIdx = 0;
		int endIIdx = 7;
		int startJIdx = 0;
		int endJIdx = 7;
//		int countI = 1;
//		int countJ = 1;
		
		int bNum = 0;
		int wNum = 0;
		
		int minColoringNum = Integer.MAX_VALUE;
		
		while (true) {	
			for (int i = startIIdx; i < endIIdx; i++) {
				for (int j = startJIdx; j < endJIdx; j++) {
					switch (board[i][j]) {
						case "W" -> wNum++;
						case "B" -> bNum++;
					}
				}
				
				if(endJIdx == board[i].length - 1) break;
				
				startJIdx++;
				endJIdx++;
			}
			
			int coloringNum = Math.abs(wNum-bNum);
			
			if (coloringNum == 0) {
				System.out.println(0);
				return;
			} else if (coloringNum < minColoringNum) {
				minColoringNum = coloringNum;
			}
			
			if(endIIdx == board.length - 1) break;
			
			startIIdx++;
			endIIdx++;
		}
		
		System.out.println(minColoringNum);
	}
}
