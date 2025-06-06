package d250604.b1427;

import java.io.*;
import java.util.*;

// 소트인사이드
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        char[] arr = str.toCharArray();
        // char 배열의 sort에는 Comparator를 넣을 수 없음
        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arr.length; i++) {
            // 거꾸로 출력
            sb.append(arr[arr.length - 1 - i]);
        }
        
        System.out.println(sb);
    }
}
