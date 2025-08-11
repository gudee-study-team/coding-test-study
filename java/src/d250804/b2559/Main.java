package d250804.b2559;

import java.io.*;
import java.lang.*;


/*
 * 목표: 연속 ?일 온도의 합이 가장 큰 값 구하기
 * 
 * 다음과 같이 입력됨
 * n k
 * n개의 정수(-100~100)
 * 
 * n: 온도 갯수(2~100,000)
 * k: 연속 날짜 숫자(1~n)
 */
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String firstLine[] = br.readLine().split(" ");
		int n = Integer.parseInt(firstLine[0]); // 입력만 받고 안씀
		int k = Integer.parseInt(firstLine[1]);
		
		// 문자열 배열을 정수 배열에 옮겨담음 (배열 안의 값을 연산하기 위해)
		String secondLine[] = br.readLine().split(" ");
		int temps[] = new int[secondLine.length];
		for (int i = 0; i < secondLine.length; i++) {
			temps[i] = Integer.parseInt(secondLine[i]);
		}
		
		// 구간합 변수와 최댓값 변수 초기화 (초기값: 인덱스 0부터 k-1까지의 합)
		int pre = 0; // 구간합 시작 인덱스
		int next = k - 1; // 구간합 끝 인덱스
		int sum = 0;
		for(int i = pre; i <= next; i++) {
			sum += temps[i];
		}
		
		int max = sum;
		pre++; next++; // 구간합을 구한 뒤 인덱스를 1씩 증가
		
		// 슬라이딩 윈도우로 나머지 구간합들을 구함
		while(next <= temps.length - 1) { // 구간합 끝 인덱스가 배열의 마지막 인덱스보다 작거나 같으면 실행
			sum = sum + temps[next] - temps[pre - 1]; // temps[pre] ~ temps[next]가 구간합이므로 temps[pre - 1]을 빼주는 것임
			if(sum > max) max = sum;
			
			pre++; next++;
		}
		
		System.out.println(max);
	}
}
