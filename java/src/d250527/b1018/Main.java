package d250527.b1018;

import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        // 체스판
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String buff = br.readLine();

        int n = Integer.parseInt(buff.split(" ")[0]);
        int m = Integer.parseInt(buff.split(" ")[1]);

        // 값을 받아서 배열로 저장
        char[][] arr = new char[n][];
        for (int i = 0; i < n; i++) {
            buff = br.readLine();
            arr[i] = buff.toCharArray();
        }

        // 최종 값을 담을 변수
        int count = Integer.MAX_VALUE;
        // 체스판 값 비교
        char[] checker = { 'W', 'B' };
        // 전체 범위
        for (int i = 0; i <= n - 8; i++) {
            for (int j = 0; j <= m - 8; j++) {

                int wCount = 0, bCount = 0;
                // 8 x 8 범위
                for (int k = i; k < i + 8; k++) {
                    for (int l = j; l < j + 8; l++) {
                        // 시작이 W일때 B일때를 나누어서 카운트
                        int idx = (i + j) % 2;
                        if ((k + l) % 2 == 0) {
                            if (arr[k][l] != checker[idx])
                                wCount++;
                            else
                                bCount++;
                        } else {
                            if (arr[k][l] == checker[idx])
                                wCount++;
                            else
                                bCount++;
                        }
                    }
                }
                // 더 작은 값을 반영
                int subCount = wCount < bCount ? wCount : bCount;
                count = count < subCount ? count : subCount;
            }
        }

        System.out.println(count);
    }
}
