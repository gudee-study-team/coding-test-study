package d250527.b2231;

import java.util.Scanner;

/*
 * M의 분해합(N) = M + (M의 각 자리수의 합)
 * M: 분해합 N의 생성자 -> 생성자가 없을 수도, 여러개일 수도
 * 분해합 N의 가장 작은 생성자 M을 구해라(M이 없는 경우에는 0 출력)
 * 
 * N의 범위: 1~1,000,000 => 10^6 < 10^8 이기 때문에 2중 반복문 사용 힘듦
 * 
 * 입력: 정수 N(분해합) ex) 123+6 = 129
 * 출력: 정수 M(생성자) ex) 123
 * 
 * M(생성자) = N(분해합) - (M의 각 자리수의 합)
 * 분해합보다 작은 모든 수를 돌면서 그 수의 각 자리수의 합을 빼야하나?
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int input = sc.nextInt();
		
		for (int i = 0; i < input; i++) {
			int tempI = i; // for문의 인덱스 i는 놔두고, i값을 while문 안에서 바꾸기 위해 다른 변수에 옮겨담음
			int digitSum = 0; // i의 각 자리수의 합
			
			// 각 자리수의 합을 구함
			while(!(tempI == 0)) {
			// 각 자리수를 모두 더한 경우 tempI는 0이 되므로 tempI가 0이 되면 반복문을 빠져나옴
				digitSum += tempI % 10; // 각 자리수를 더함
				tempI /= 10; // 더한 자리수 제거
			}
			
			if (i + digitSum == input) {
				System.out.println(i);
				return;
			}
		}
		
		// 위의 반복문을 빠져나왔다는 건 생성자가 존재하지 않다는 뜻 => 0 출력
		System.out.println(0);
	}
}
