package d250804.b11659;

import java.io.*;

/*
 * 입력되는 숫자들
 * 
 * n m
 * n개의 숫자들
 * m개의 줄
 * 
 * n: 숫자의 갯수
 * m: 합을 구해야 하는 횟수
 * n개의 숫자들(1~1,000)
 * m개의 줄: 한 줄당 i j (i~j: 합을 구해야 하는 구간)
 */
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String firstLine[] = br.readLine().split(" ");
		int n = Integer.parseInt(firstLine[0]);
		int m = Integer.parseInt(firstLine[1]);
		
		
		// n개의 숫자들을 입력받아서 배열에 저장한 후 값들을 숫자로 변환(연산해야 하니까)
		String secondLine[] = br.readLine().split(" ");
		int numbers[] = new int[secondLine.length];
		for(int i = 0; i < secondLine.length; i++) {
			numbers[i] = Integer.parseInt(secondLine[i]);
		}
		
		// 인덱스 0에서 각 인덱스까지의 합을 구해놓기
		// 이중 for문이므로 시간 초과가 날 수 있음
		// 시간 초과를 벗어나기 위해서는 누적합을 이용해야 함
		int sums[] = new int[secondLine.length];
		sums[0] = numbers[0];
		for(int i = 1; i < secondLine.length; i++) {
			sums[i] = numbers[i] + sums[i - 1];
		}
		
		// m개의 줄이 입력됨
		// 한 줄이 입력될 때마다 구간 i~j의 합을 구함
		// 단, 이 때 i와 j는 배열의 인덱스보다 1 큼
		// 입출력이 많으므로 BufferedReader와 StringBuilder를 사용하여 입출력
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < m; i++) {
			String interval[] = br.readLine().split(" ");
			int start = Integer.parseInt(interval[0]) - 1;
			int end = Integer.parseInt(interval[1]) - 1;
			
			if (start == 0) sb.append(sums[end]);
			else sb.append(sums[end] - sums[start - 1]);
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
