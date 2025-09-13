package d250617.b17478;

import java.util.Scanner;

/*
 * 입력: 재귀 횟수
 * 다시 호출될 때마다 "_"의 개수가 두 배씩 늘어남
 * 가장 안쪽 호출에서 "재귀함수는 자기 자신을 호출하는 함수라네"를 출력
 * 재귀 함수 호출 후 "라고 답변하였지." 출력
 */

/*
 * A: "재귀함수가 뭔가요?"
 * B-1: "잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 ~ 물었어."
 * B-2: "재귀함수는 자기 자신을 호출하는 함수라네"
 * C: 라고 답변하였지.
 * D: ____
 * 
 * A
 * B-1
 * D (A
 * D  B-1
 * D  D (A
 * D  D  B-2
 * D  D  C)
 * D C)
 * C
 */
public class Main {
	public static String underbar = "";
	public static String start = "어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n";
	public static String q = "\"재귀함수가 뭔가요?\"\n";
	public static String a11 = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n";
	public static String a12 = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n";
	public static String a13 = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n";
	public static String a2 = "\"재귀함수는 자기 자신을 호출하는 함수라네\"\n";
	public static String end = "라고 답변하였지.\n";
	
	public static StringBuilder recursion(int n) {
		// n이 1일 때/ 1보다 클 때로 나눔
		
		// n이 1이면 -> return StringBuilder(A + B-2 + C);
		// n이 1보다 크면 -> return StringBuilser(A + B-1).append(recursion(n-1)).append(C)
		
		// 언더바 테스트
//		underbar += "____";
//		if (n == 0) return underbar + "\n";
//		else return underbar + "\n" + recursion(n-1);

		underbar += "____";
		
		StringBuilder result = new StringBuilder();
		
		if (n == 1) {
			return new StringBuilder().append(underbar + q)
									  .append(underbar + a2)
									  .append(underbar + end);
		}
		else {
			return new StringBuilder().append(underbar + q)
					  				  .append(underbar + a11)
					  				  .append(underbar + a12)
					  				  .append(underbar + a13)
					  				  .append(recursion(n-1))
					  				  .append(underbar.substring((4*n)-4) + end);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		System.out.print(start);
		System.out.print(q);
		System.out.print(a11 + a12 + a13);
		System.out.print(recursion(n));
		System.out.print("라고 답변하였지.");
	}
}
