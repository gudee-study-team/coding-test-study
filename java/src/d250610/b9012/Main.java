package d250610.b9012;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws Exception {
    
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  int num = Integer.parseInt(br.readLine()); // 첫번째 숫자 입력 받음
  int count; // '(' 의 개수
  String str[];
  StringBuilder sb = new StringBuilder();

  for(int i =0; i< num; i++){ 
    //문자열을 입력 받아서 str 배열에 하나씩 저장
    count =0;
    str= br.readLine().split("");
    for(int j = 0 ; j<str.length; j++){
      //str배열에서 하나씩 꺼내와서 순서대로 비교
    if(str[j].equals("(")){count++; continue;}
    // ( 이들어오면 count를 1증가시킴

    if(count>0) count --;
    // count>0일때 즉 '(' 이 있을 때 ')'이 들어오면 count를 1 감소 시킴
    else {count = 1; break;}
    // count>0이 아닐때 즉 '(' 이 없을 때 ')'가 들어오면 VPS가 성립되지 않으므로 바로 탈출

    }
  if(count!=0) // count 가 0이 아니라면 VPS가 아니기 때문에 NO를 출력
  sb.append("NO").append("\n");
  else   sb.append("YES").append("\n"); // count가 0이면 VPS가 되기에 YES를 출력
  }
  System.out.println(sb);

  }
}
