package d250604.b11650;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws Exception {
      BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
      int num =Integer.parseInt(br.readLine());
      int [][] arr =new int[num][];
      for(int i = 0 ; i < num; i++){
        //3. Arrays.stream()은 문자열 배열에서 Stream<String> 객체를 생성합니다.
        //4. mapToInt(Integer::parseInt)은 스트림의 각 요소에 Integer 클래스의 parseInt() 메서드를 적용하여 문자열을 int로 변환합니다.
        //5. toArray()는 최종적으로 int 배열로 변환합니다.
        arr[i] =Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray(); 
      }
      Arrays.sort(arr, new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
          if(o1[0]==(o2[0])){
            return o1[1]-(o2[1]);
          }else{
            return o1[0]-(o2[0]);
          }
        }
      });
      for(int i = 0; i < num ; i++){
        System.out.println(arr[i][0]+" " +arr[i][1]);
      }

    }
}
