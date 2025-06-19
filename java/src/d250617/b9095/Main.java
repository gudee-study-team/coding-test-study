package d250617.b9095;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args)throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int num = Integer.parseInt(br.readLine());
    int n;
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i<num; i++){
      n = Integer.parseInt(br.readLine());
      sb.append(recursion(n)).append("\n");
      

    }
    System.out.println(sb);
    
  }
  /*N을 1,2,3의 합으로 나타내는 방법의 수 =
  (1 + (N-1))을 나타내는 방법 수+ (2 + (N-2))를 나타내는 방법 수+(3 + (N-3))을 나타내는 방법수 
  */
  public static int recursion(int num){
    if(num==1) return 1; // 1을 나타내는 방법수
    if(num==2) return 2; // 2를 나타내는 방법수
    if(num==3) return 4; // 3을 나타내는 방법수
    return recursion(num-1)+recursion(num-2)+recursion(num-3);
  }

}
