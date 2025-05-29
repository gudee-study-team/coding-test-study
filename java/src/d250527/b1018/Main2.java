package d250527.b1018;

import java.util.Scanner;

/*
 * 체스판을 칠하는 경우의 수는 두 가지
 * 1. 흰검흰검...
 * 2. 검흰검흰...
 * 
 */
public class Main2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// N, M을 입력받음
		int n = sc.nextInt();
		int m = sc.nextInt();
		sc.nextLine();
		
		// N*M만큼 입력받은 값들을 저잘할 배열 생성
		char[][] board = new char[n][m];		
		
		for (int i = 0; i < board.length; i++) { // N번 반복
			String inputLine = sc.nextLine();
			for (int j = 0; j < board[i].length; j++) { // M번 반복
				board[i][j] = inputLine.charAt(j);
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
		
		// TODO 어떻게 빠져나올지 생각.....
		while (true) {	
			for (int i = startIIdx; i <= endIIdx; i++) { // 반복문I(열)
				for (int j = startJIdx; j <= endJIdx; j++) { // 반복문J(행)
					System.out.println("i: "+i+" j: "+j);
					
				}
				
				System.out.println();

				startIIdx++;
				endIIdx++;
			}
			
			startJIdx++;
			endJIdx++;
		}
	}
}
