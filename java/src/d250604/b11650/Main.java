package d250604.b11650;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

    // [문제 분석]
    // x, y 좌표가 공백을 사이에 두고 주어짐
    // 정렬의 순서: 1. x 좌표의 크기 2. y 좌표의 크기
    // 점의 개수가 미리 주어지고 String 자료형이므로 배열을 사용해 정렬해보자

    // 배열 생성 후 좌표 입력
    String[] points = new String[Integer.parseInt(bufferedReader.readLine())];
    for (int i = 0; i < points.length; i++) {
      points[i] = bufferedReader.readLine();
    }

    // 조건에 맞는 compare를 오버라이딩한 Comparator 익명 클래스 객체를 활용
    Arrays.sort(points, new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        int x1 = Integer.parseInt(o1.split(" ")[0]);
        int x2 = Integer.parseInt(o2.split(" ")[0]);

        int y1 = Integer.parseInt(o1.split(" ")[1]);
        int y2 = Integer.parseInt(o2.split(" ")[1]);

        if (x1 == x2) { // 서로의 x 값이 같으면 => y의 값을 비교
          return Integer.compare(y1, y2);
        } else {
          return Integer.compare(x1, x2);
        }
      }
    });

    // 출력
    for (String point : points) {
      bufferedWriter.write(point + "\n");
    }

    bufferedWriter.flush();

    bufferedReader.close();
    bufferedWriter.close();
  }
}
