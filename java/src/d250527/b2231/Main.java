package d250527.b2231;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        // 분해합
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        String buff = br.readLine();
        int input = Integer.parseInt(buff);

        int answer = 0;
        // 생성자는 문자열 길이 * 9 보다 작아질 수 없음
        int start = input - buff.length() * 9;
        for (int i = start; i < input; i++) {
            int num = i;
            int sum = 0;
            // 각 자리를 잘라서 더해줌
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            // 탐색한 값 + 각 자리 합이 입력값과 같으면 탈출
            if (i + sum == input) {
                answer = i;
                break;
            }
        }

        System.out.println(answer);
    }
}
