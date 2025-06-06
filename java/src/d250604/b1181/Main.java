package d250604.b1181;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 중복 제거를 위해 Set로 입력받음
        Set<String> set = new HashSet<>(n);
        for (int i = 0; i < n; i++) {
            set.add(br.readLine());
        }
        
        // 정렬하기 위해 리스트에 복사, 람다 함수로 정렬
        List<String> list = new ArrayList<>(set);
        list.sort((x, y) -> {
            if(x.length() == y.length())
                return x.compareTo(y);
            else return x.length() - y.length();
        });

        StringBuilder sb = new StringBuilder();
        for(String s : list)
            sb.append(s).append('\n');

        System.out.println(sb);
    }
}
