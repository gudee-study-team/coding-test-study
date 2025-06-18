package d250617.b9095;

import java.io.*;

/* 1, 2, 3 더하기
 * 첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고, 정수 n이 주어진다. n은 양수이며 11보다 작다.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        int[] arr = new int[11];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 4;

        int idx = 3;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            for (int j = idx; j < n; j++) {
                if (arr[j] != 0) continue;
                arr[j] = arr[j - 1] + arr[j - 2] + arr[j - 3];
            }
            idx = n;
            sb.append(arr[n - 1]).append('\n');
        }

        System.out.println(sb);
    }
}

