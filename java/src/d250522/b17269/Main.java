package d250522.b17269;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// 1. 첫째 줄에 두 이름의 길이(2~100), 둘째 줄에 이름 A와 B를 입력받음(대문자)
		// 2. 출력: 이름궁합(단, 십의 자리가 0일 경우엔 일의 자리만 출력)
		
		Scanner sc = new Scanner(System.in);
		
		// 입력
		sc.nextInt();
		sc.nextInt();
		
		// 1) 문자열 합치기
		StringBuilder name1 = new StringBuilder(sc.next());
		StringBuilder name2 = new StringBuilder(sc.next());
		
		StringBuilder resultName = new StringBuilder();
		
		// 긴 쪽에 짧은 쪽을 추가
		int insertIdx = 0;
		int nameIdx = 0;
		
		if (name1.length() < name2.length()) {
			while (nameIdx < name1.length()) {
				// name2의 currentIdx 값이 name1의 currentIdx 값 뒤에 들어가면 됨
				name2.insert(insertIdx, name1.charAt(nameIdx));
				// currentIdx가 0 2 4 6...와 같이 바뀌어야 하므로
				insertIdx += 2;
				nameIdx++;
			}
			
			resultName = name2;
		} else {
			while (nameIdx < name2.length()) {
				name1.insert(insertIdx + 1, name2.charAt(nameIdx));
				insertIdx += 2;
				nameIdx++;
			}
			
			resultName = name1;
		}
		
		// 이름 문자열을 획수 문자열로
		int idx = 0;
		StringBuilder strokes = new StringBuilder();
		
		while(idx < resultName.length()) {
			switch (resultName.charAt(idx)) {
			case 'E' :
				strokes.append(4);
				break;
			case 'A', 'F', 'H', 'K', 'M' :
				strokes.append(3);
				break;
			case 'B', 'D', 'N', 'P', 'Q', 'R', 'T', 'X', 'Y' :
				strokes.append(2);
				break;
			default:
				strokes.append(1);
				break;
			}
			
			idx++;			
		}
				
		// 2) 이름궁합 출력
		// 이름궁합 1회전 후의 결과를 담는 변수
		StringBuilder tempResult = new StringBuilder();
		// 이전 인덱스의 값 + 현재 인덱스의 값을 담는 변수
		int tempSum = 0;
		
		while(strokes.length() > 2) {
			for (int i = 1; i < strokes.length(); i++) {
				tempSum = Integer.parseInt(strokes.charAt(i - 1) + "");
				
				tempSum += Integer.parseInt(strokes.charAt(i) + "");
				tempSum %= 10; // 합이 일의 자리가 넘는 경우 일의 자리만 남김
				
				tempResult.append(tempSum);
			}
						
			strokes = new StringBuilder(tempResult); // 이름궁합 1회전 대상 초기화
			
			tempResult.setLength(0); // 이름궁합 1회전 후의 결과를 담는 변수 초기화
		}
		
		System.out.println(Integer.parseInt(strokes.toString()) + "%");
	}
}