package d250610.b10773;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
  public static void main(String[] args) throws Exception{
    //0이 들어오면 최근 숫자를 지우면 됌 stack을 이용하면 편한듯해 보인다
    //0이 들어왔을때 이전 숫자가 0일 경우만 생각해주자 
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
    int num = Integer.parseInt(br.readLine()); // 첫번째 숫자 받기
    Stack<String> st = new Stack<>();
    String str;
    StringBuilder sb = new StringBuilder();

    for(int i =0; i<num; i++){
      str=br.readLine();
      if(str.equals("0")){ // 들어온 숫자가 0 이면 최근 stack에 들어간 숫자를 pop시킴
        st.pop();
      }
      else st.push(str); 
    }
    num = 0;// stack에 남아있는 숫자를 더하기 위해 num변수 0으로 초기화
    while (!st.isEmpty()) {
      num+= Integer.parseInt(st.pop());
    }
    System.out.println(num);
  }
}
