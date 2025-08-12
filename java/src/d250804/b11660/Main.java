package d250804.b11660;

import java.io.*;
import java.lang.*;

/*
 * 입력되는 숫자들
 * 
 * n m
 * n개의 줄(표에 채워져있는 수들이 한 줄씩 주어짐)
 * m개의 줄(네 개의 정수 - (1,2) ~ (3,4)의 합을 구해야 함)
 * 
 * n: 표의 크기(1~1,024) - n*n
 * m: 합을 구해야하는 횟수(1~100,000)
 * 
 * x축 줄들의 합 구해놓고
 * 전체합 구해놓고
 * 전체합 - [x축 합] - ?
 */
public class Main {
	public static void main(String[] args) throws Exception {
		// 입출력 수가 많으므로 BufferdReader, StringBuilder 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String firstLine[] = br.readLine().split(" ");
		int n = Integer.parseInt(firstLine[0]);
		int m = Integer.parseInt(firstLine[1]);
		
		int num[][] = new int[n][n];
		int sum = 0;
		int sumX[] = new int[n];
		int idx = 0;
		for(int i = 0; i < n; i++) {
			String line[] = br.readLine().split(" ");
			
			int sumRow = 0;
			for (int j = 0; j < line.length; j++) {
				
				num[i][j] = Integer.parseInt(line[j]);
				sum += num[i][j];
				sumRow += num[i][j];
			}
			sumX[i] = sumRow;
		}
		
		for (int i : sumX) {
			System.out.print(i + " ");
		}
		System.out.println();

		for (int i = 0; i < m; i++) {
			String Line[] = br.readLine().split(" ");
			int lineNum[] = new int[4];
			// x값: 1, 3
			// y값: 2, 4
//			sumX[lineNum[3]] - sumX[lineNum[3] - 1];
		}
		
	}
}
