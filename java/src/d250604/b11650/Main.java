package d250604.b11650;

import java.util.Scanner;

// 정렬 기준: x좌표를 기준으로 오름차순, x좌표가 같을 경우 y좌표 오름차순
// 정렬해야 할 점의 개수는 1~100,000
// 위치가 같은 점은 없음

// 2차원 배열로 좌표값을 받아야 하나..?
// ㄴ x, y 각각의 좌표값을 받으려면 두 번 타고 들어가야 함
// 1차원 배열로 하려면 x, y 값 사이에 구분자를 두고 String으로 받아야 할듯
public class Main {
	public static void exchange(String str1, String str2) {
		String temp = str1;
		str1 = str2;
		str2 = temp;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); // 점의 개수
		sc.nextLine();
		String[] xyArr = new String[n]; // x, y 좌표들
		
		// x, y 좌표를 공백을 사이에 두고 한 줄씩 입력받음
		for (int i = 0; i < xyArr.length; i++) {
			xyArr[i] = sc.nextLine();
		}
		
		// xyArr를 돌며 xyArr[i].split(" ")[0] 값을 현재 인덱스부터 맨 끝 인덱스까지 비교
		// 만약 현재 인덱스의 값 > 비교 인덱스의 값 이라면 두 값의 자리를 바꿈
		// 만약 현재 인덱스의 값 == 비교 인덱스의 값 이라면 xyArr[i].split(" ")[1]의 값을 비교
		// ㄴ 만약 현재 인덱스의 값 > 비교 인덱스의 값이라면 두 값의 자리를 바꿈
		
		for (int i = 0; i < xyArr.length; i++) {
			String[] currXY = xyArr[i].split(" ");
			int currX = Integer.parseInt(currXY[0]);
			int currY = Integer.parseInt(currXY[1]);
//			System.err.println("currX: " + currX + ", currY: " + currY);
			
			for (int j = 0; j < xyArr.length; j++) {
				String[] compXY = xyArr[j].split(" ");
				int compX = Integer.parseInt(compXY[0]);
				int compY = Integer.parseInt(compXY[1]);
				
				if (currX > compareX) { // 두 값의 자리를 바꿈
					// xyArr[i], xyArr[j]가 있음
					// String temp에 xyArr[i]를 저장해 놓고
					// xyArr[i]에 xyArr[j] 값을 넣어줌
					// xyArr[j]에는 temp를 넣어줌
					String temp = xyArr[i];
					xyArr[i] = xyArr[j];
					xyArr[j] = temp;
				} else if (currX == compareX) { // xyArr[i].split(" ")[1]의 값을 비교
					
					if (currY < compareY) { // 두 값의 자리를 바꿈
						String temp = xyArr[i];
						xyArr[i] = xyArr[j];
						xyArr[j] = temp;
					}
				}
			}
		}
		
		for (String string : xyArr) {
			System.out.println(string);
		}
	}
}
