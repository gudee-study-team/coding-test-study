package d250522.b10539;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] buff = br.readLine().split(" ");

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(buff[i]);
        }

        /* 점화식 계산해서 새로운 배열에 입력
         * a/1	(a+b)/2     (a+b+c)/3
         * a	2x - a		3x - a - b
        */
        int[] answer = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (i != 0)
                sum += answer[i - 1];
            answer[i] = arr[i] * (i + 1) - sum;
        }

        StringBuilder sb = new StringBuilder();
        for (int ans : answer) {
            sb.append(ans);
            sb.append(' ');
        }
        System.out.println(sb.toString());
    }

}
