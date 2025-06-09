package d250604.b11650;

import java.util.Arrays;
import java.util.Scanner;

// 정렬 기준: x좌표를 기준으로 오름차순, x좌표가 같을 경우 y좌표 오름차순
// 정렬해야 할 점의 개수는 1~100,000
// 위치가 같은 점은 없음

// 2차원 배열로 좌표값을 받아야 하나..?
// ㄴ x, y 각각의 좌표값을 받으려면 두 번 타고 들어가야 함...복잡
// 1차원 배열로 하려면 x, y 값 사이에 구분자를 두고 String으로 받아야 할듯
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(); // 점의 개수
		sc.nextLine(); // 개행 문자 제거
		
		String[] xyArr = new String[n]; // x, y 좌표들을 담을 배열
		
		// x, y 좌표를 공백을 사이에 두고 한 줄씩 입력받음
		for (int i = 0; i < xyArr.length; i++) {
			xyArr[i] = sc.nextLine();
		}
		
		// (10^5)^2 = 10^(5*2) = 10^10 => 10^8을 넘으므로 버블정렬(O(N^2)) 사용 불가
		// O(NlogN)의 시간복잡도를 가지는 Arrays.sort(배열, Comparator)을 사용해야 한다고 함
		
		// 문자열 배열을 정렬함
		// split으로 x, y 나눈 다음 int로 바꿔서 비교함
		// 조건1: x좌표 오름차순
		// 조건2: x가 같다면 y좌표 오름차순
		Arrays.sort(xyArr, (s1, s2) -> {
			// 각 문자열을 공백 기준으로 쪼갬
			String[] xy1 = s1.split(" ");
			String[] xy2 = s2.split(" ");

			// 쪼갠 문자열을 int로 변환해서 x, y좌표로 저장
			int x1 = Integer.parseInt(xy1[0]);
			int y1 = Integer.parseInt(xy1[1]);
			int x2 = Integer.parseInt(xy2[0]);
			int y2 = Integer.parseInt(xy2[1]);

			// x좌표를 먼저 비교
			if (x1 != x2) return x1 - x2;

			// x좌표가 같으면 y좌표 비교
			return y1 - y2;
		});	
		
		for (String string : xyArr) {
			System.out.println(string);
		}
	}
}
