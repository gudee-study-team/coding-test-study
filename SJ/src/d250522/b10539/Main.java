package d250522.b10539;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] buff = br.readLine().split(" ");

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(buff[i]);
        }

        // 점화식 계산해서 새로운 배열에 입력
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            int num;
            int sum = 0;
            for (int j = 0; j < i; j++) {
                sum += answer[j];
            }
            num = arr[i] * (i + 1) - sum;
            answer[i] = num;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int ans : answer)
            bw.write(ans + " ");
        bw.flush();
    }

}
