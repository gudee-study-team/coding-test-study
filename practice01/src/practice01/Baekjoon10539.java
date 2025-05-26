package practice01;

import java.util.Scanner;

public class Baekjoon10539 {
	public static void main(String[] args) {
		// 1. 첫째 줄에 수열 B의 길이(1~100)가 입력됨
		// 2. 둘째 둘에 길이만큼 정수가 주어짐(범위:1~10^9)
		// 3. 출력: 수열 A를 이루는 정수들(구분:공백)
		
		Scanner sc = new Scanner(System.in);
		
		int lenB = sc.nextInt();
		int[] seqB = new int[lenB];
		
		for (int i = 0; i < seqB.length; i++) {
			seqB[i] = sc.nextInt();
		}
		
		int sumOfPreNums = 0;
		
		for (int i = 0; i < seqB.length; i++) {
			int n = i + 1;
			int a = seqB[i] * n - sumOfPreNums;
			sumOfPreNums += a;
			System.out.print(a + " ");
		}
	}
}
