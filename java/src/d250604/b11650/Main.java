package d250604.b11650;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // Pair 클래스로 좌표를 저장
        List<Pair> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            String[] buff = br.readLine().split(" ");
            list.add(new Pair(Integer.parseInt(buff[0]), Integer.parseInt(buff[1])));
        }

        // 람다 함수로 정렬
        list.sort((x, y) -> {
            if (x.first == y.first) {
                return x.second - y.second;
            }
            else return x.first - y.first;
        });

        StringBuilder sb = new StringBuilder();
        for (Pair pair : list) {
            sb.append(pair.first).append(' ').append(pair.second).append('\n');
        }

        System.out.println(sb);
    }
}

class Pair {
    int first;
    int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
