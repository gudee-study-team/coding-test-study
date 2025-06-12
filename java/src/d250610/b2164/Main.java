package d250610.b2164;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
  // n이 2의 n제곱이면 n 출력

  // n이 2의거듭제곱인 숫자로부터 떨어진 값만큼 2의 배수 출력
  // 예) 17인경우 16으로부터 1만큼 떨어져있으므로 2가 출력됨
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int num = Integer.parseInt(br.readLine());
    int power_2 = 1;
    while (power_2<num) { // num보다 큰 가장가까운 2의 거듭제곱 수를 찾음
      power_2 *=2;
    }
    if(power_2!=1) power_2/=2; // 1이 아니라면 2로 한번 나눠줘서 num보다 작은 가장 가까운 2의거듭제곱수를 만듬 
    int sub;
    sub=num- power_2; // num과 2의거듭제곱 과의 차를 구함
    if(sub==0){// 차가 0이라면 2의 거듭제곱수 이므로 그값 그대로 출력
      System.out.println(num);
    }
    else{ // 아닌경우 2를 곱해줘서 출력
      System.out.println(sub*2);
    }
  } 
}
