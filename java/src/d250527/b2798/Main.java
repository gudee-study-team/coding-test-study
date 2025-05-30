package d250527.b2798;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        // 블랙잭
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] buff = br.readLine().split(" ");
        int n = Integer.parseInt(buff[0]);
        int m = Integer.parseInt(buff[1]);

        // 값을 배열에 저장하고 정렬
        buff = br.readLine().split(" ");
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(buff[i]);
        Arrays.sort(arr);

        // 가장 큰 값(i)을 하나씩 올리면서 내부에서 전체적으로 탐색
        int max = 0;
        iLoop: for(int i = 2; i < n; i++){
            jLoop: for(int j = 1; j < i; j++){
                for(int k = 0; k < j; k++){
                    int curr = arr[i] + arr[j] + arr[k];
                    // 목표 값을 넘어버리면 가장 안쪽 루프 스킵
                    if(curr > m) continue jLoop;
                    else {
                        if(curr > max) {
                            max = curr;
                            // 목표 값에 도달하면 루프 종료
                            if(max == m) break iLoop;
                        }
                    } 
                }
            }
        }

        System.out.println(max);
    }
}
